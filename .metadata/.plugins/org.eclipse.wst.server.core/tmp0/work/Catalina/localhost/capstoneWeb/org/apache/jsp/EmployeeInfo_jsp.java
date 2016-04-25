package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.Employee;
import java.util.ArrayList;
import logic.EmployeeManager;
import exceptions.*;

public final class EmployeeInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

Employee employee = new Employee();

int id=0;
String username = "";
String givenName = "";
String surname = "";
String password = "";
String employeeLevel = "0";

if(request.getParameter("employee") != null) {
	employee = em.getEmployeeInfo(Integer.parseInt(request.getParameter("employee")));
	em.close();

	id = employee.getId();
	givenName = (employee.getGivenName()==null)?"":employee.getGivenName();
	surname = (employee.getSurname()==null)?"":employee.getSurname();
	username = (employee.getUsername()==null)?"":employee.getUsername();
	password = (employee.getPassword()==null)?"":employee.getPassword();
	employeeLevel = employee.getEmployeeLevel()+"";
}

if(request.getParameter("error") != null) {
	//0-id, 1-username, 2-password, 3-givenName, 4-surname
	ArrayList<String> errorText = (ArrayList<String>) session.getAttribute("errorText");
	
	id = Integer.parseInt(errorText.get(0));
	givenName = errorText.get(3);
	surname = errorText.get(4);
	username = errorText.get(1);
	password = errorText.get(2);

      out.write("\r\n");
      out.write("<script type=\"text/javascript\" >\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$('label[for=");
      out.print( session.getAttribute("errorField") );
      out.write("]').parent().parent().addClass(\"error\");\r\n");
      out.write("\t\t});\r\n");
      out.write("</script>\r\n");
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
      out.write("<form action=\"EmployeeManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 235px\">\r\n");
      out.write("\t");
 if(request.getParameter("error") != null) { 
      out.write("\r\n");
      out.write("\t\t<div id=\"errorDesc\">\r\n");
      out.write("\t\t\t");
      out.print( session.getAttribute("errorMessage") );
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\t<fieldset> \r\n");
      out.write("\t\t\t<legend><strong>Employee Details</strong></legend>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"givenName\">Given Name:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"givenName\" size=\"15\" value=\"");
      out.print( givenName );
      out.write("\" /> *</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"surname\">Surname:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"surname\" size=\"15\" value=\"");
      out.print( surname );
      out.write("\" /> *</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"username\">Username:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"username\" size=\"15\" value=\"");
      out.print( username );
      out.write("\" /> *</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"password\">Password:</label></div><div class=\"rightDiv\"><input type=\"password\" name=\"password\" size=\"15\" value=\"");
      out.print( password );
      out.write("\" /> *</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"employeeLevel\">Role:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"employeeLevel\" size=\"1\" value=\"");
      out.print( employeeLevel );
      out.write("\" /> *</div></div>\r\n");
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
