package org.apache.jsp.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class requestbooking_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t<title>Request Booking</title>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<link type=\"text/css\" href=\"http://jqueryui.com/latest/themes/base/jquery.ui.all.css\" rel=\"stylesheet\" />\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"http://jquery-ui.googlecode.com/svn/tags/1.8rc1/jquery-1.4.1.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"http://jquery-ui.googlecode.com/svn/tags/1.8rc1/ui/jquery-ui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t//Run on page load\r\n");
      out.write("\t\t    jQuery(document).ready(function($) {\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t      \t//setup for datepicker\r\n");
      out.write("\t\t      \t$(\"#datepicker\").datepicker();\r\n");
      out.write("\t\t    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t    function sendEmail()\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t    var message=\"\";\r\n");
      out.write("\t\t\t    message = message + document.emailForm.givename.value + \"\\n\";\r\n");
      out.write("\t\t\t    message = message + \"Email=\" + document.emailForm.email.value + \"\\n\";\r\n");
      out.write("\t\t\t    message = message + \"Event date=\" + document.emailForm.eventDate.value + \"\\n\";\r\n");
      out.write("\t\t\t    message = message + \"Start time=\" + document.emailForm.starttime.value + \"\\n\";\r\n");
      out.write("\t\t\t    message = message + \"End time=\" + document.emailForm.endtime.value + \"\\n\";\r\n");
      out.write("\t\t\t    document.sendForm.From.value = message;\r\n");
      out.write("\t\t\t    document.sendForm.submit();\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t  \t</script>\t\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	String fullname="";

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/indusdb", "root","password");
	Statement s = conn.createStatement();
	String sql="select givenName,surname from client where email='" + (String)session.getAttribute("email") + "';";
	
	s.executeQuery(sql);
	
	ResultSet rs = s.getResultSet();
	
	while (rs.next())
	{
		fullname=rs.getString(1) + " " + rs.getString(2);
	}
	
	rs.close();
	conn.close();
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body bgcolor=\"#FFFFFF\">\r\n");
      out.write("<table style=width:45% border=\"3\" bordercolor=\"#6699CC\">\r\n");
      out.write("        <tr><td><font color=\"#5191CD\"> <h1>Booking Request Form</h1></font></td><td align=\"center\"><a href=\"clientinvoice.jsp\">Back</a></td><td align=\"center\"><a href=\"login.jsp?logout=true\">Logout</a></td></tr></table>\r\n");
      out.write(" <table style=width:45% border=\"3\" bordercolor=\"#6699CC\" ><tr><td>\r\n");
      out.write(" <form name=\"emailForm\" method=\"post\" action=\"mailto:kmoloughlin@gmail.com?subject=Request Booking\" enctype=\"application/x-www-form-urlencoded\">\r\n");
      out.write("\t<font color=\"#5191CD\"></font>\t\r\n");
      out.write("\t<table align=\"center\" style=\"width:50%; border=\"2\" bordercolor=\"#6699CC\">\r\n");
      out.write("\t<tr><td style=\"padding-right:5px\">Name:</td>\r\n");
      out.write("\t <td>\r\n");
      out.write("\t   <input type=\"text\" name=\"givename\" value=\"");
      out.print( fullname );
      out.write("\"/>\r\n");
      out.write("\t </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr><td style=\"padding-right:5px\">Email:</td>\r\n");
      out.write("\t <td><input type=\"text\" name=\"email\" value=\"");
      out.print( (String)session.getAttribute("email") );
      out.write("\"/>\r\n");
      out.write("\t </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr><td style=\"padding-right:5px\">Event Date:</td>\r\n");
      out.write("     <td><input name=\"eventDate\" type=\"text\" id=\"datepicker\" />\r\n");
      out.write("     </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("    <tr><td style=\"padding-right:5px\">Start Time:</td>\r\n");
      out.write("      <td><input type=\"text\" name=\"starttime\" />\r\n");
      out.write("      </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("    <tr><td style=\"padding-right:5px\">End Time:</td>\r\n");
      out.write("     <td><input type=\"text\" name=\"endtime\" />\r\n");
      out.write("     </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr><td align=\"right\" colspan=\"3\"><input type=\"button\" value=\"Submit\" onClick=\"sendEmail();\"></input><input type=\"reset\" value=\"Clear\"></input></td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write(" </form></td></tr></table>\r\n");
      out.write(" \r\n");
      out.write(" <form name=\"sendForm\" action=\"mailto:kmoloughlin@gmail.com?subject=Request Booking\" method=\"post\" enctype=\"text/plain\">\r\n");
      out.write("    <input type=\"hidden\" name=\"From\" value=\"\"></input>\r\n");
      out.write(" </form>\r\n");
      out.write(" </body>\r\n");
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
