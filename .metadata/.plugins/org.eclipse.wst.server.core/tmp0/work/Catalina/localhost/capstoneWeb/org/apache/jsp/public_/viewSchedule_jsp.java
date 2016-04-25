package org.apache.jsp.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.BookingManager;
import problemDomain.Facility;
import logic.FacilityManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import problemDomain.Booking;
import java.util.ArrayList;
import logic.BookingManager;
import logic.EmployeeManager;
import exceptions.*;
import java.util.Date;

public final class viewSchedule_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html><!-- InstanceBegin template=\"/Templates/indus.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\r\n");
      out.write("<head>\r\n");
      out.write("<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n");
      out.write("<title>Indus Recreation Centre - Indus, Alberta, Canada</title>\r\n");
      out.write("<!-- InstanceEndEditable --><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<link href=\"http://www.indusrec.ca/master.css\" rel=\"stylesheet\" type=\"text/css\"><!-- Schedule specific styling -->\r\n");
      out.write("<link href=\"../css/schedule.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style4 {color: #003E7E}\r\n");
      out.write(".style6 {\r\n");
      out.write("\tfont-size: x-large;\r\n");
      out.write("\tfont-family: Geneva, Arial, Helvetica, sans-serif;\r\n");
      out.write("\tcolor: #5191CD;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write(".style7 {\r\n");
      out.write("\tfont-family: Geneva, Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: x-large;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write(".style8 {color: #5191CD}\r\n");
      out.write("\r\n");
      out.write("#schedule .open, .unpaidBooking, .paidBooking {\r\n");
      out.write("\tcursor: default !important;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n");
      out.write("\t\t<!-- JQuery Main -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-latest.js\"></script>\r\n");
      out.write("\t\t<!-- JQuery Datepicker -->\r\n");
      out.write("  \t\t<link type=\"text/css\" href=\"../css/jquery.ui.all.css\" rel=\"stylesheet\" />\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"../js/jquery-1.4.1.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-ui.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t//Run on page load\r\n");
      out.write("\t\t    jQuery(document).ready(function($) {\r\n");
      out.write("\t\t      \t//setup for datepicker\r\n");
      out.write("\t\t      \t$(\"#datepicker\").datepicker();\r\n");
      out.write("\r\n");
      out.write("\t\t      \t//Tooltips for schedule\r\n");
      out.write("\t\t      \t$(\"#schedule *\").removeAttr('title')\r\n");
      out.write("\t\t      \t.removeAttr('onclick'); \r\n");
      out.write("\t\t    });\r\n");
      out.write("\t  \t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"871\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"title\">\r\n");
      out.write("  <tr>\r\n");
      out.write("\r\n");
      out.write("    <td width=\"198\"><img src=\"http://www.indusrec.ca/images/IndusLogo.gif\" alt=\"\" width=\"190\" height=\"84\"></td>\r\n");
      out.write("    <td width=\"252\" valign=\"top\"><span class=\"style6\">INDUS</span><span class=\"style7\"><br>\r\n");
      out.write("            <span class=\"style4\">RECREATION<br>\r\n");
      out.write("      CENTRE</span></span></td>\r\n");
      out.write("    <td width=\"421\" valign=\"bottom\">\r\n");
      out.write("      <table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("\r\n");
      out.write("        <td align=\"left\"><span class=\"style8\">    225155A Range Road 281A      &#8226;\r\n");
      out.write("            Indus &#8226; Alberta &#8226; Canada &#8226; T1X-0H7</span></td>\r\n");
      out.write("\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"page\">\r\n");
      out.write("  <tr valign=\"top\">\r\n");
      out.write("    <td>\r\n");
      out.write("      <table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"body\" height=\"619\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"192\" valign=\"top\" height=\"602\">\r\n");
      out.write("            <!-- InstanceBeginEditable name=\"EditRegion5\" -->\r\n");
      out.write("\r\n");
      out.write("            <table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"nav\">\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"index.html\">HOME</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/about.html\">ABOUT US </a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/news.html\">NEWS &amp; EVENTS</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/hours.html\">HOURS OF OPERATION</a> </td>\r\n");
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/arena.html\">ARENA </a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/banquet.html\">BANQUET HALL </a></td>\r\n");
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/meeting.html\">MEETING ROOMS</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/map.html\">MAP &amp; DIRECTIONS </a></td>\r\n");
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/programs.html\">PROGRAMS</a> </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td><img src=\"http://www.indusrec.ca/images/arrow.gif\" alt=\"\" width=\"9\" height=\"10\"> <a href=\"pages/contact.html\">CONTACT US</a> </td>\r\n");
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("\r\n");
      out.write("            <!-- InstanceEndEditable -->\r\n");
      out.write("            <table border=\"3\" bordercolor=\"#6699CC\" align=\"left\">\r\n");
      out.write("\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <p align=\"left\"><span class=\"style6\"><font size=\"3\">What's New</font></span></p>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <p align=\"left\"><span class=\"style6\"><font size=\"2\"><a href=\"pages/summercamp.htm\">Summer\r\n");
      out.write("                    Camps</font></a></font></span></p>\r\n");
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <p align=\"left\"><span class=\"style6\"><font size=\"2\"><a href=\"pages/news.html\">Registration\r\n");
      out.write("                    Day</a> </font></span></p>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t            <p>&nbsp;</p>\r\n");
      out.write("          </td>\r\n");
      out.write("          <td valign=\"top\" width=\"701\" height=\"602\">\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<!--<form method=\"post\"SubjectFormPages\"enctype=\"text/html\"> -->\r\n");
      out.write("\r\n");
      out.write("<left>\r\n");
      out.write("<br />\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"search\" style=\"width:400px\">\r\n");
      out.write("\t\t\t<table style=\"width: 100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"left\">Facility: \r\n");
      out.write("\t\t\t\t\t\t<select name=\"facility\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								FacilityManager fm = new FacilityManager();
								ArrayList<Facility> facilites = (ArrayList<Facility>) fm.getFacilityList();
								
								for (Facility f : facilites) {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print( f.getId() );
      out.write('"');
      out.write('>');
      out.print( f.getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t");
 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">Date: <input type=\"text\" id=\"datepicker\" name=\"date\" value=\"");
      out.print( formatter.format(new Date()) );
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">View: \r\n");
      out.write("\t\t\t\t\t\t<select name=\"view\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\">Single Day</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2\">Single Week</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"3\">Single Month</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br /><br />\r\n");
      out.write("\t<div id=\"schedule\"></div>\r\n");
      out.write("</table>\r\n");
      out.write("<script>\r\n");
      out.write("   \t$(\"select\").change(function () {\r\n");
      out.write("       \tvar update = \"../BookingManager?f=\";\r\n");
      out.write("         \t$(\"select[name='facility'] option:selected\").each(function () {\r\n");
      out.write("         \t\tupdate += $(this).val() + \"&date=\" + $(\"input[name='date']\").val() + \"&view=\";\r\n");
      out.write("           });\r\n");
      out.write("         \t$(\"select[name='view'] option:selected\").each(function () {\r\n");
      out.write("         \t\tupdate += $(this).val();\r\n");
      out.write("           });\r\n");
      out.write("\r\n");
      out.write("           $('#schedule').html('<center><strong>Loading Schedule</strong><br /><img src=\"../img/facebox/loading.gif\" alt=\"loading\" /></center>');\r\n");
      out.write("           \r\n");
      out.write("           $('#schedule').load(update, function() {\r\n");
      out.write("        \t\t$(\"td\").removeAttr('title')\r\n");
      out.write("        \t\t.removeAttr('onclick'); \r\n");
      out.write("        \t});\r\n");
      out.write("       }).change();\r\n");
      out.write("\r\n");
      out.write("       $(\"input[name='date']\").change(function () {\r\n");
      out.write("       \tvar update = \"../BookingManager?f=\";\r\n");
      out.write("         \t$(\"select[name='facility'] option:selected\").each(function () {\r\n");
      out.write("         \t\tupdate += $(this).val() + \"&date=\" + $(\"input[name='date']\").val() + \"&view=\";\r\n");
      out.write("           });\r\n");
      out.write("         \t$(\"select[name='view'] option:selected\").each(function () {\r\n");
      out.write("         \t\tupdate += $(this).val();\r\n");
      out.write("           });\r\n");
      out.write("\r\n");
      out.write("           $('#schedule').html('<center><strong>Loading Schedule</strong><br /><img src=\"../img/facebox/loading.gif\" alt=\"loading\" /></center>');\r\n");
      out.write("           \r\n");
      out.write("           $('#schedule').load(update, function() {\r\n");
      out.write("         \t\t$(\"td\").removeAttr('title')\r\n");
      out.write("         \t\t.removeAttr('onclick'); \r\n");
      out.write("         \t});\r\n");
      out.write("       });\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
