package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.EmployeeManager;
import java.util.ArrayList;
import problemDomain.*;
import logic.BookingManager;
import java.text.SimpleDateFormat;
import logic.InvoiceManager;

public final class InvoiceInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	
	
	int client_id = 0;
	int invoice_no = 0;
	Invoice invoice = null;
	if(request.getParameter("client") != null) {
		client_id = Integer.parseInt(request.getParameter("client"));
	}else if(request.getParameter("invoice") != null) {
		InvoiceManager im = new InvoiceManager();
		invoice_no = Integer.parseInt(request.getParameter("invoice"));
		invoice = im.getInvoiceInfo(invoice_no);
		client_id = invoice.getClient().getId();
		im.close();
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.comboselect.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.selso.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.comboselect.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:47%;\r\n");
      out.write("\t}\r\n");
      out.write("\t-->\r\n");
      out.write("</style>\r\n");
      out.write("<form action=\"InvoiceManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 400px\">\r\n");
      out.write("\t\t<div style=\"width:100%;float:left\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<legend>Bookings</legend>\r\n");
      out.write("\t\t\t\t<div style=\"padding:0px 10px\">\r\n");
      out.write("\t\t\t\t\tSearch Bookings: <br />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" /><input type=\"button\" value=\"Search\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<select name=\"bookings\" id=\"bookings\" size=\"10\" style=\"width:100%\" multiple=\"multiple\">\r\n");
      out.write("\t\t\t\t\t");

					BookingManager bm = new BookingManager();
					ArrayList<Booking> bookings = (ArrayList<Booking>) bm.getAllBookingsForClient(client_id);
					for(Booking b : bookings) {
						String selected = "";
						if(request.getParameter("invoice") != null && b.getInvoice_no() == invoice_no)
							selected = "selected=\"selected\"";
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print( b.getId() );
      out.write('"');
      out.print( selected );
      out.write('>');
      out.print( b.getEventTitle() );
      out.write('-');
      out.write(' ');
      out.print( new SimpleDateFormat("MM/dd/yyyy h:mm a").format(b.getStartTime()) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");

					}
					
					bm.close();
					
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"clear:both;padding-top:10px\">\r\n");
      out.write("\t\t\t<span style=\"text-align: left\">Additional Information:</span>\r\n");
      out.write("\t\t\t<textarea rows=\"3\" cols=\"47\" name=\"desc\">");
      out.print( invoice!=null?invoice.getDescription():"" );
      out.write("</textarea>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t\t<!-- <input type=\"reset\" value=\"Reset\" /> -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"client\" value=\"");
      out.print( client_id );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"invoice\" value=\"");
      out.print( invoice_no );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"save\" value=\"Save\" />\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"delete\" value=\"Delete\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>");
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
