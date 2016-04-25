package org.apache.jsp.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html><!-- InstanceBegin template=\"/Templates/indus.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\n");
      out.write("<head>\n");
      out.write("<!-- InstanceBeginEditable name=\"doctitle\" -->\n");
      out.write("<title>Indus Recreation Centre - Indus, Alberta, Canada</title>\n");
      out.write("<!-- InstanceEndEditable --><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("<link href=\"http://www.indusrec.ca/master.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<style type=\"text/css\">\n");
      out.write("<!--\n");
      out.write(".style4 {color: #003E7E}\n");
      out.write(".style6 {\n");
      out.write("\tfont-size: x-large;\n");
      out.write("\tfont-family: Geneva, Arial, Helvetica, sans-serif;\n");
      out.write("\tcolor: #5191CD;\n");
      out.write("\tfont-weight: bold;\n");
      out.write("}\n");
      out.write(".style7 {\n");
      out.write("\tfont-family: Geneva, Arial, Helvetica, sans-serif;\n");
      out.write("\tfont-size: x-large;\n");
      out.write("\tfont-weight: bold;\n");
      out.write("}\n");
      out.write(".style8 {color: #5191CD}\n");
      out.write("-->\n");
      out.write("</style>\n");
      out.write("<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<table width=\"871\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"title\">\n");
      out.write("  <tr>\n");
      out.write("\n");
      out.write("    <td width=\"198\"><img src=\"http://www.indusrec.ca/images/IndusLogo.gif\" alt=\"\" width=\"190\" height=\"84\"></td>\n");
      out.write("    <td width=\"252\" valign=\"top\"><span class=\"style6\">INDUS</span><span class=\"style7\"><br>\n");
      out.write("            <span class=\"style4\">RECREATION<br>\n");
      out.write("      CENTRE</span></span></td>\n");
      out.write("    <td width=\"421\" valign=\"bottom\">\n");
      out.write("      <table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("      <tr>\n");
      out.write("\n");
      out.write("        <td align=\"left\"><span class=\"style8\">    225155A Range Road 281A      &#8226;\n");
      out.write("            Indus &#8226; Alberta &#8226; Canada &#8226; T1X-0H7</span></td>\n");
      out.write("\n");
      out.write("      </tr>\n");
      out.write("    </table></td>\n");
      out.write("\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"page\">\n");
      out.write("  <tr valign=\"top\">\n");
      out.write("    <td>\n");
      out.write("      <table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"body\" height=\"619\">\n");
      out.write("        <tr>\n");
      out.write("          <td width=\"192\" valign=\"top\" height=\"602\">\n");
      out.write("            <!-- InstanceBeginEditable name=\"EditRegion5\" -->\n");
      out.write("\n");
      out.write("            <table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"nav\">\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"index.html\">HOME</a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/about.html\">ABOUT US </a></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/news.html\">NEWS &amp; EVENTS</a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/hours.html\">HOURS OF OPERATION</a> </td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/arena.html\">ARENA </a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/banquet.html\">BANQUET HALL </a></td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/meeting.html\">MEETING ROOMS</a></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/map.html\">MAP &amp; DIRECTIONS </a></td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/programs.html\">PROGRAMS</a> </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/contact.html\">CONTACT US</a> </td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("              <td>&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("          </table>\n");
      out.write("\n");
      out.write("            <!-- InstanceEndEditable -->\n");
      out.write("            <table border=\"3\" bordercolor=\"#6699CC\" align=\"left\">\n");
      out.write("\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <p align=\"left\"><span class=\"style6\"><font size=\"3\">What's New</font></span></p>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <p align=\"left\"><span class=\"style6\"><font size=\"2\"><a href=\"pages/summercamp.htm\">Summer\n");
      out.write("                    Camps</font></a></font></span></p>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <p align=\"left\"><span class=\"style6\"><font size=\"2\"><a href=\"pages/news.html\">Registration\n");
      out.write("                    Day</a> </font></span></p>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\t\t\t            <p>&nbsp;</p>\n");
      out.write("          </td>\n");
      out.write("          <td valign=\"top\" width=\"701\" height=\"602\">\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<!--<form method=\"post\"SubjectFormPages\"enctype=\"text/html\"> -->\n");
      out.write("\n");
      out.write("<left>\n");
      out.write("<br />\n");
      out.write("\n");
      out.write("<table border=\"3\" bordercolor=\"#6699CC\">\n");
      out.write("        <tr><td>\n");
      out.write("                <table><tr><span class=\"style6\">Indus Client Login</span></tr></table>\n");
      out.write("        <form action=\"../PublicLoginManager\" method=\"POST\">\n");
      out.write("            <table><tr><td>Email:</td><td><input type=\"text\" name=\"email\"></td></tr>\n");
      out.write("                <tr><td>Password:</td><td><input type=\"password\" name=\"password\"></td></tr>\n");
      out.write("                <tr><td colspan=\"3\" align=\"right\"><input type=\"submit\" value=\"Login\"></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form></td></tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");

    String message=request.getParameter("message");
    if (message!=null)
        out.println("<b>" + message + "</b>");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</body>\n");
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
