<%-- 
    Document   : clientinvoice
    Created on : Mar 14, 2010, 1:23:00 PM
    Author     : 504303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="logic.InvoiceManager,problemDomain.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>

<%
    InvoiceManager im = new InvoiceManager();
    ArrayList<Invoice> invoice = (ArrayList<Invoice>)im.getInvoicesForClient((Integer)session.getAttribute("clientid"));
    im.close();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recent Transactions</title>
    </head>
    <body>
        <table style=width:100% border="3" bordercolor="#6699CC">
        <tr><td><font color="#5191CD"> <h1>Recent Transactions</h1></font></td><td align="center"><a href="viewScheduleLoggedIn.jsp">Schedule</a></td><td align="center"><a href="login.jsp?logout=true">Logout</a></td></tr></table>
       
       
       <div style="clear:both; width: 100%">
        <table style=width:100% border="3" bordercolor="#6699CC"><tr><td>
        <%
        for (Invoice i: invoice)
        {
        	
        
        %>
        <h2>Invoice: <%= i.getId() %> - <%= new SimpleDateFormat("M/dd/yyyy").format(i.getDate()) %></h2>
       <div style="clear:both">
            <table style="width:100%; text-align: center;">
                <tr>
                    <th style="padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;">Description</th>
                    <th style="padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;">Dates / Times</th>
                    <th style="padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;">Qty</th>
                    <th style="padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;">Rate</th>
                    <th style="padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;">Price</th>
                </tr>
                <%
                	ArrayList<Rate> rates = new ArrayList<Rate>();
                	for (Booking b : i.getBookings()) {
                		if (!rates.contains(b.getRate()))
                			rates.add(b.getRate());
                	}

                	double price = 0;
                	for (Rate r : rates) {
                		boolean first = true;
                		double length = 0;
                		boolean hourly = false;
                		for (Booking b : i.getBookings()) {
                			if (b.getRate().getId() == r.getId()) {
                				if (r.isHourly()) {
                					hourly = true;
                					length += b.getLength();
                				} else
                					length++;
                			}
                		}
                		if (hourly)
                			length = length / 60;
                		price += length * r.getRate();
                		for (Booking b : i.getBookings()) {
                			if (b.getRate().getId() == r.getId()) {
                				String bookingDate = new SimpleDateFormat(
                						"EEE M/d/yyyy h:mm a").format(b.getStartTime())
                						+ " - "
                						+ new SimpleDateFormat("h:mm a").format(b.getEndTime());
                %>
                <tr>
                    <td><%=first ? r.getDescription() : ""%></td>
                    <td><%=bookingDate%></td>
                    <td><%=first ? length : ""%></td>
                    <td><%=first ? NumberFormat.getCurrencyInstance().format(r.getRate()) : ""%></td>
                    <td><%=first ? NumberFormat.getCurrencyInstance().format(length * r.getRate()) : ""%></td>
                </tr>
                <%
                	first = false;
                			}
                		}
                	}
                %>
            </table><br/></br>
            </div>
            Additional items/services:<br />
            <table style="clear: both">
            <%
            	double damageD = 0;
            	double bookingD = 0;
            	for (Booking b : i.getBookings()) {
            		bookingD += b.getRate().getBookingDeposit();
            		damageD += b.getRate().getDamageDeposit();
            		for (AdditionalCharge ac : b.getAdditionalCharges()) {
            		    price += ac.getCost();
            %>
                <tr>
                    <td><%=ac.getName()%>: </td>
                    <td><%=NumberFormat.getCurrencyInstance().format(ac.getCost())%></td>
                </tr>
            <%
            	}
            	}
            	price += damageD + bookingD;
            %>
                <tr>
                    <td>Damage Deposit: </td>
                    <td><%=NumberFormat.getCurrencyInstance().format(damageD)%></td>
                </tr>
                <tr>
                    <td>Booking Deposit: </td>
                    <td><%=NumberFormat.getCurrencyInstance().format(bookingD)%></td>
                </tr>
            </table>

            <table style="text-align: right;float: right; clear: both">
                <tr>
                    <td style="padding-right:5px">Discount:</td>
                    <td><%=NumberFormat.getCurrencyInstance().format(price * (i.getClient().getDiscount()) / 100)%></td>
                </tr>
                <tr>
                    <td style="padding-right:5px">GST:</td>
                    <td><%=NumberFormat.getCurrencyInstance().format((price - (price* (i.getClient().getDiscount()) / 100)) * 0.05)%></td>
                </tr>
                <tr>
                    <td style="padding-right:5px">Subtotal:</td>
                    <td><%=NumberFormat.getCurrencyInstance().format(i.getSubtotal())%></td>
                </tr>
                <tr>
                    <td style="padding-right:5px">Paid:</td><%
                    	double paid = 0;
                    	for (Payment p : i.getPayments())
                    		   paid += p.getAmount();
                    %>
                    <td><%=NumberFormat.getCurrencyInstance().format(paid)%></td>
                </tr>
                <tr style="font-weight: bold; text-transform: uppercase">
                    <td style="padding-right:5px">Balance:</td>
                    <td><%=NumberFormat.getCurrencyInstance().format(i.getPaymentDue())%></td>
                </tr>
            </table>
            
            <table style="width: 100%">
                <tr>
                    <th colspan="3" style="border-top: 1px solid black;border-bottom: 1px solid black;">Payment History</th>
                </tr>
                <%
                	for (Payment p : i.getPayments()) {
                %>
                <tr>
                    <td style="width: 90%"><%=new SimpleDateFormat("M/dd/yyyy").format(p.getDate())%></td>
                    <td style="width: 5%"><%=p.getType()%></td>
                    <td style="width: 5%"><%=NumberFormat.getCurrencyInstance().format(p.getAmount())%></td>
                </tr>
                <%
                	}
                %>
            </table>
            <hr />
            <%
        }
            %>
            </td></tr></table>
            </div>
       

        

    </body>
</html>
