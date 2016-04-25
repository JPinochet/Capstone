package org.apache.jsp.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import logic.EmployeeManager;
import logic.InvoiceManager;
import problemDomain.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;

public final class clientinvoice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");

	InvoiceManager im = new InvoiceManager();
	ArrayList<Invoice> invoice = (ArrayList)im.getInvoicesForClient((Integer)session.getAttribute("clientid"));
	im.close();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Recent Transactions</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table style=width:53% border=\"3\" bordercolor=\"#6699CC\">\n");
      out.write("        <tr><td><font color=\"#5191CD\"> <h1>Recent Transactions</h1></font></td><td align=\"center\"><a href=\"requestbooking.jsp\">Booking Request</a></td><td align=\"center\"><a href=\"login.jsp?logout=true\">Logout</a></td></tr></table>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("       <div style=\"clear:both; width: 55%\">\n");
      out.write("        <table border=\"3\" bordercolor=\"#6699CC\"><tr><td>\n");
      out.write("        ");

        for (Invoice i: invoice)
        {
        	
        
        
      out.write("\n");
      out.write("        <h2>Invoice: ");
      out.print( i.getId() );
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print( new SimpleDateFormat("M/dd/yyyy").format(i.getDate()) );
      out.write("</h2>\n");
      out.write("       <div style=\"clear:both\">\n");
      out.write("            <table style=\"width:100%; text-align: center;\">\n");
      out.write("                <tr>\n");
      out.write("                    <th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Description</th>\n");
      out.write("                    <th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Dates / Times</th>\n");
      out.write("                    <th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Qty</th>\n");
      out.write("                    <th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Rate</th>\n");
      out.write("                    <th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Price</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(first ? r.getDescription() : "");
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(bookingDate);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(first ? length : "");
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(first ? NumberFormat.getCurrencyInstance().format(r.getRate()) : "");
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(first ? NumberFormat.getCurrencyInstance().format(length * r.getRate()) : "");
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                	first = false;
                			}
                		}
                	}
                
      out.write("\n");
      out.write("            </table><br/></br></br>\n");
      out.write("            \n");
      out.write("            Additional items/services:<br />\n");
      out.write("            <table style=\"clear: both\">\n");
      out.write("            ");

            	double damageD = 0;
            	double bookingD = 0;
            	for (Booking b : i.getBookings()) {
            		bookingD += b.getRate().getBookingDeposit();
            		damageD += b.getRate().getDamageDeposit();
            		for (AdditionalCharge ac : b.getAdditionalCharges()) {
            		    price += ac.getCost();
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(ac.getName());
      out.write(": </td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(ac.getCost()));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            ");

            	}
            	}
            	price += damageD + bookingD;
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Damage Deposit: </td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(damageD));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Booking Deposit: </td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(bookingD));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <table style=\"text-align: right;float: right; clear: both\">\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"padding-right:5px\">Discount:</td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(price * (i.getClient().getDiscount()) / 100));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"padding-right:5px\">GST:</td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format((price - (price* (i.getClient().getDiscount()) / 100)) * 0.05));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"padding-right:5px\">Subtotal:</td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(i.getSubtotal()));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"padding-right:5px\">Paid:</td>");

                    	double paid = 0;
                    	for (Payment p : i.getPayments())
                    		   paid += p.getAmount();
                    
      out.write("\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(paid));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr style=\"font-weight: bold; text-transform: uppercase\">\n");
      out.write("                    <td style=\"padding-right:5px\">Balance:</td>\n");
      out.write("                    <td>");
      out.print(NumberFormat.getCurrencyInstance().format(i.getPaymentDue()));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            <table style=\"width: 100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"3\" style=\"border-top: 1px solid black;border-bottom: 1px solid black;\">Payment History</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                	for (Payment p : i.getPayments()) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"width: 90%\">");
      out.print(new SimpleDateFormat("M/dd/yyyy").format(p.getDate()));
      out.write("</td>\n");
      out.write("                    <td style=\"width: 5%\">");
      out.print(p.getType());
      out.write("</td>\n");
      out.write("                    <td style=\"width: 5%\">");
      out.print(NumberFormat.getCurrencyInstance().format(p.getAmount()));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                	}
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <hr />\n");
      out.write("            ");

        }
            
      out.write("\n");
      out.write("            </td></tr></table>\n");
      out.write("            </div>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("       ");
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
