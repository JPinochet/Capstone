package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.Booking;
import java.util.ArrayList;
import logic.BookingManager;
import logic.EmployeeManager;
import exceptions.*;
import java.util.Date;
import logic.BookingManager;
import problemDomain.Facility;
import logic.FacilityManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class ScheduleWindow_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	BookingManager bm = new BookingManager();

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t\t<title>Indus Recreational Facility | Scheduling</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Main page styling -->\r\n");
      out.write("\t\t<link href=\"css/style.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t\t<!-- Schedule specific styling -->\r\n");
      out.write("\t\t<link href=\"css/schedule.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- JQuery Main -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery-latest.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- JQuery AutoComplete -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/jquery.autocomplete.css\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery.bgiframe.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery.dimensions.js\"></script>\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"js/jquery.autocomplete.js\"></script>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<!-- JQuery Datepicker -->\r\n");
      out.write("  \t\t<link type=\"text/css\" href=\"css/jquery.ui.all.css\" rel=\"stylesheet\" />\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"js/jquery-1.4.1.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery-ui.js\"></script>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<!-- JQuery Tooltip -->\r\n");
      out.write("  \t\t<link type=\"text/css\" href=\"css/jquery.tooltip.css\" rel=\"stylesheet\" />\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"js/jquery.bgiframe.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery.tooltip.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Lightbox -->\r\n");
      out.write("\t\t<link href=\"css/facebox.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t\t<script src=\"js/facebox.js\" type=\"text/javascript\"></script> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t//Run on page load\r\n");
      out.write("\t\t    jQuery(document).ready(function($) {\r\n");
      out.write("\t\t\t\t//Make all a tags with a rel=\"facebox\" open a facebox\r\n");
      out.write("\t\t      \t$('a[rel*=facebox]').facebox({\r\n");
      out.write("\t\t        \tloading_image : '/facebox/loading.gif',\r\n");
      out.write("\t\t        \tclose_image   : '/facebox/closelabel.gif'\r\n");
      out.write("\t\t      \t}); \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t//setup for autocomplete\r\n");
      out.write("\t\t      \t$(\"#searchAC\").autocomplete(\"BookingManager\");\r\n");
      out.write("\r\n");
      out.write("\t\t      \t//setup for datepicker\r\n");
      out.write("\t\t      \t$(\"#datepicker\").datepicker();\r\n");
      out.write("\r\n");
      out.write("\t\t      \t//Tooltips for schedule\r\n");
      out.write("\t\t      \t$(\"#schedule *\").tooltip({\r\n");
      out.write("\t\t      \t\tshowBody: \" -- \"\r\n");
      out.write("\t\t      \t});\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t  \t</script>\t\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"topbg\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t<div id=\"header\">\r\n");
      out.write("\t\t\t\t<div id=\"hdr-overlay\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"hdr-box1\" class=\"box\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"hdr-box2\" class=\"box\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"hdr-box3\" class=\"box\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"hdr-box4\" class=\"box\"></div>\r\n");
      out.write("\t\t\t\t<h1>Indus Recreational Facility</h1>\r\n");
      out.write("\t\t\t\t<div id=\"logout\">\r\n");
      out.write("\t\t\t\t\t<a href=\"LoginManager?logout=true\">Logout</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<ul id=\"menu\">\r\n");
      out.write("\t\t\t\t<li><a href=\"index.jsp\"><span></span>Home</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"sel\" href=\"ScheduleWindow.jsp\"><span></span>Schedule</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"AccountingWindow.jsp\"><span></span>Accounting</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"ClientWindow.jsp\"><span></span>Clients</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"FacilityWindow.jsp\"><span></span>Facilities</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"EmployeeWindow.jsp\"><span></span>Employees</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"OrganizationWindow.jsp\"><span></span>Organizations</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"ManagementWindow.jsp\"><span></span>Management</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t<div class=\"search\" style=\"width:400px\">\r\n");
      out.write("\t\t\t\t\t<form action=\"ScheduleManager?do=search\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<table style=\"width: 100%\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"left\">Facility: \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"facility\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											FacilityManager fm = new FacilityManager();
											ArrayList<Facility> facilites = (ArrayList<Facility>) fm.getFacilityList();
											
											for (Facility f : facilites) {
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print( f.getId() );
      out.write('"');
      out.write('>');
      out.print( f.getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											}
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\">Date: <input type=\"text\" id=\"datepicker\" name=\"date\" value=\"");
      out.print( formatter.format(new Date()) );
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"right\">View: \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"1\">Single Day</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"2\">Single Week</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"3\">Single Month</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tSearch Bookings: <br />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"searchAC\" name=\"searchText\" /> <input type=\"submit\" name=\"search\" value=\"Search\" /> <input type=\"submit\" name=\"reset\" value=\"Clear Results\" />\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\t<div id=\"schedule\"></div>\r\n");
      out.write("\t\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\t&nbsp;<u>Available Time</u><br />\r\n");
      out.write("\t\t\t\t&nbsp;March 10, 2010:\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>11:15am - 4:15pm</li>\r\n");
      out.write("\t\t\t\t\t<li>10:45pm - 12:00pm</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div class=\"cleaner\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t    \t$(\"select\").change(function () {\r\n");
      out.write("\t\t\t\t        \tvar update = \"BookingManager?f=\";\r\n");
      out.write("\t\t\t\t          \t$(\"select[name='facility'] option:selected\").each(function () {\r\n");
      out.write("\t\t\t\t          \t\tupdate += $(this).val() + \"&date=\" + $(\"input[name='date']\").val() + \"&view=\";\r\n");
      out.write("\t\t\t\t            });\r\n");
      out.write("\t\t\t\t          \t$(\"select[name='view'] option:selected\").each(function () {\r\n");
      out.write("\t\t\t\t          \t\tupdate += $(this).val();\r\n");
      out.write("\t\t\t\t            });\r\n");
      out.write("\t\t\t\t            \r\n");
      out.write("\t\t\t\t          \t$('#schedule').load(update, function() {\r\n");
      out.write("\t\t\t\t          \t\t$(\"td\").tooltip({\r\n");
      out.write("\t\t\t\t\t\t      \t\tshowBody: \" -- \"\r\n");
      out.write("\t\t\t\t\t\t      \t});\r\n");
      out.write("\t\t\t\t          \t});\r\n");
      out.write("\t\t\t\t        }).change();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t        $(\"input[name='date']\").change(function () {\r\n");
      out.write("\t\t\t\t        \tvar update = \"BookingManager?f=\";\r\n");
      out.write("\t\t\t\t          \t$(\"select[name='facility'] option:selected\").each(function () {\r\n");
      out.write("\t\t\t\t          \t\tupdate += $(this).val() + \"&date=\" + $(\"input[name='date']\").val() + \"&view=\";\r\n");
      out.write("\t\t\t\t            });\r\n");
      out.write("\t\t\t\t          \t$(\"select[name='view'] option:selected\").each(function () {\r\n");
      out.write("\t\t\t\t          \t\tupdate += $(this).val();\r\n");
      out.write("\t\t\t\t            });\r\n");
      out.write("\t\t\t\t            \r\n");
      out.write("\t\t\t\t          \t$('#schedule').load(update, function() {\r\n");
      out.write("\t\t\t\t          \t\t$(\"td\").tooltip({\r\n");
      out.write("\t\t\t\t\t\t      \t\tshowBody: \" -- \"\r\n");
      out.write("\t\t\t\t\t\t      \t});\r\n");
      out.write("\t\t\t\t          \t});\r\n");
      out.write("\t\t\t\t        });\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
 bm.close(); 
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
