package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.AdditionalCharge;
import java.util.ArrayList;
import logic.AdditionalChargeManager;
import exceptions.*;
import logic.EmployeeManager;

public final class AdditionalChargeInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	AdditionalChargeManager acm = new AdditionalChargeManager();

	AdditionalCharge addition = new AdditionalCharge();
	
	int id = 0;
	String name = "";
	double cost = 0;
	
	if(request.getParameter("addition") != null)
	{
		addition = acm.getAdditionalChargeInfo(Integer.parseInt(request.getParameter("addition")));
		acm.close();
		
		id = addition.getId();
		name = (addition.getName()==null)?"":addition.getName();
		cost = addition.getCost();
	}

      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:75px;\r\n");
      out.write("\t}\n");
      out.write("\t-->\n");
      out.write("</style>\r\n");
      out.write("<form action=\"AdditionalChargeManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 260px\">\r\n");
      out.write("\t\t<fieldset> \r\n");
      out.write("\t\t\t<legend><strong>Additional Charge Details</strong></legend>\r\n");
      out.write("\t\t\t<div class=\"leftDiv\"><label for=\"name\">Name:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"name\" size=\"15\" value=\"");
      out.print( name );
      out.write("\" />* </div>\r\n");
      out.write("\t\t\t<div class=\"leftDiv\"><label for=\"cost\">Cost: $</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"cost\" size=\"3\" value=\"");
      out.print( cost );
      out.write("\" /> *</div>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\" />\r\n");
      out.write("\t\t\t<!-- <input type=\"reset\" value=\"Reset\" /> -->\r\n");
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
