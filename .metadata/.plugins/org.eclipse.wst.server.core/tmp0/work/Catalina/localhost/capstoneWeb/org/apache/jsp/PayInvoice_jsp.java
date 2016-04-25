package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.EmployeeManager;
import logic.InvoiceManager;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public final class PayInvoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String due = "";
	if(request.getParameter("invoice") != null) {
		InvoiceManager im = new InvoiceManager();
		NumberFormat nf = new DecimalFormat("#.00"); 
		due = nf.format(im.getInvoiceInfo(Integer.parseInt(request.getParameter("invoice"))).getPaymentDue()) + "";
		im.close();
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\r\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:47%;\r\n");
      out.write("\t}\r\n");
      out.write("\t-->\r\n");
      out.write("</style>\r\n");
      out.write("<form action=\"InvoiceManager?do=pay\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 200px\">\r\n");
      out.write("\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t<div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t<label for=\"setup\">Amount Due:</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t$<input type=\"text\" size=\"5\" value=\"");
      out.print( due );
      out.write("\" disabled=\"disabled\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t<div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t<label for=\"setup\">Payment:</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t$<input type=\"text\" name=\"amount\" size=\"5\" value=\"0.00\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"field\">\r\n");
      out.write("\t\t\t<div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t<label for=\"setup\">Payment Type:</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t<select name=\"type\">\r\n");
      out.write("\t\t\t\t\t<option value=\"check\">Check</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"credit\">Credit</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"cash\">Cash</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"debit\">Debit</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t<!-- <input type=\"reset\" value=\"Reset\" /> -->\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"invoice\" value=\"");
      out.print( request.getParameter("invoice") );
      out.write("\" />\r\n");
      out.write("\t\t<input type=\"submit\" name=\"pay\" value=\"Pay\" />\r\n");
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
