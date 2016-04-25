package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.EmployeeManager;
import logic.InvoiceManager;
import problemDomain.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;

public final class invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
	
	Invoice i = null;
	if(request.getParameter("invoice") != null){
		InvoiceManager im = new InvoiceManager();
		i = im.getInvoiceInfo(Integer.parseInt(request.getParameter("invoice")));
		im.close();
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />\r\n");
      out.write("\t\t<title>Invoice</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"font-size: 80%\" onload=\"window.print();\">\r\n");
      out.write("\t\t<div style=\"float:left\">\r\n");
      out.write("\t\t\tBow Valley Agricultural Society<br />\r\n");
      out.write("\t\t\t225155A Range Road 281A<br />\r\n");
      out.write("\t\t\tIndus, AB T1X 0H7<br />\r\n");
      out.write("\t\t\tPhone: 403-936-5474 Ext. 2<br />\r\n");
      out.write("\t\t\tFax: 403-936-5473<br />\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<strong>Bill to:</strong><br />\r\n");
      out.write("\t\t\t");
      out.print( i.getClient().getGivenName() + " " + i.getClient().getSurname() );
      out.write("<br />\r\n");
      out.write("\t\t\t");
      out.print( i.getClient().getAddress() );
      out.write("<br />\r\n");
      out.write("\t\t\t");
      out.print( i.getClient().getCity() );
      out.write(',');
      out.write(' ');
      out.print( i.getClient().getProvince() );
      out.write(' ');
      out.print( i.getClient().getPostalCode() );
      out.write("<br />\r\n");
      out.write("\t\t\tH: ");
      out.print( i.getClient().getHomePhone() );
      out.write("<br />\r\n");
      out.write("\t\t\tW: ");
      out.print( i.getClient().getWorkPhone() );
      out.write("<br />\r\n");
      out.write("\t\t\tC: ");
      out.print( i.getClient().getCellPhone() );
      out.write("<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"float:right\">\r\n");
      out.write("\t\t\t<span style=\"text-transform: uppercase;font-weight: bold; font-size: 300%; font-style: italic\">Invoice</span><br />\r\n");
      out.write("\t\t\tInvoice Number: ");
      out.print( i.getId() );
      out.write("<br />\r\n");
      out.write("\t\t\tInvoice Date: ");
      out.print( new SimpleDateFormat("M/dd/yyyy").format(i.getDate()) );
      out.write("<br />\r\n");
      out.write("\t\t\tDue Date: ");
      out.print( new SimpleDateFormat("M/dd/yyyy").format(i.getDueDate()) );
      out.write("<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"clear:both\">\r\n");
      out.write("\t\t\t<table style=\"width:100%; text-align: center;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Description</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Dates / Times</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Qty</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Rate</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"padding:5px;border-top: 1px solid black;border-bottom: 1px solid black;\">Price</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				ArrayList<Rate> rates = new ArrayList<Rate>();
				for(Booking b : i.getBookings()) {
					if(!rates.contains(b.getRate()))
						rates.add(b.getRate());
				}

				double price = 0;
				for(Rate r : rates) {
					boolean first = true;
					double length = 0;
					boolean hourly = false;
					for(Booking b : i.getBookings()) {
						if(b.getRate().getId() == r.getId()){
							if(r.isHourly()){
								hourly = true;
								length += b.getLength();
							}else
								length++;
						}
					}
					if(hourly)
						length = length / 60;
					price += length*r.getRate(); 
					for(Booking b : i.getBookings()) {
						if(b.getRate().getId() == r.getId()) {
							String bookingDate = new SimpleDateFormat("EEE M/d/yyyy h:mm a").format(b.getStartTime()) + " - " + new SimpleDateFormat("h:mm a").format(b.getEndTime());
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( first?r.getDescription():"" );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( bookingDate );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( first?length:"" );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( first?NumberFormat.getCurrencyInstance().format(r.getRate()):"" );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( first?NumberFormat.getCurrencyInstance().format(length*r.getRate()):"" );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

							first=false;
						}
					}
				}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tAdditional items/services:<br />\r\n");
      out.write("\t\t\t<table style=\"clear: both\">\r\n");
      out.write("\t\t\t");

			double damageD = 0;
			double bookingD = 0;
			for(Booking b : i.getBookings()) {
				bookingD += b.getRate().getBookingDeposit();
				damageD += b.getRate().getDamageDeposit();
				for(AdditionalCharge ac : b.getAdditionalCharges()) {
					price += ac.getCost();
					
			
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( ac.getName() );
      out.write(": </td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(ac.getCost()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
			}
			price += damageD + bookingD;
			
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Damage Deposit: </td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(damageD) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Booking Deposit: </td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(bookingD) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table style=\"text-align: right;float: right; clear: both\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-right:5px\">Discount:</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(price * (i.getClient().getDiscount())/100) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-right:5px\">GST:</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format((price - (price * (i.getClient().getDiscount())/100)) * 0.05) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-right:5px\">Subtotal:</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(i.getSubtotal()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-right:5px\">Paid:</td>");
 double paid = 0; for(Payment p : i.getPayments()) paid += p.getAmount(); 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(paid) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr style=\"font-weight: bold; text-transform: uppercase\">\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-right:5px\">Balance:</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( NumberFormat.getCurrencyInstance().format(i.getPaymentDue()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table style=\"width: 100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"3\" style=\"border-top: 1px solid black;border-bottom: 1px solid black;\">Payment History</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				for(Payment p : i.getPayments()) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 90%\">");
      out.print( new SimpleDateFormat("M/dd/yyyy").format(p.getDate()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 5%\">");
      out.print( p.getType() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 5%\">");
      out.print( NumberFormat.getCurrencyInstance().format(p.getAmount()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<center>\r\n");
      out.write("\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\tPayment must be received prior to facility use<br />\r\n");
      out.write("\t\t\t\t\tPlease Make All Cheques Payable To: <br /><br />\r\n");
      out.write("\t\t\t\t\tBow Valley Agricultural Society<br /><br />\r\n");
      out.write("\t\t\t\t\tPlease include invoice with payment or <br />\r\n");
      out.write("\t\t\t\t\tcontact the office to pay by credit card.\r\n");
      out.write("\t\t\t\t</strong>\r\n");
      out.write("\t\t\t</center>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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
