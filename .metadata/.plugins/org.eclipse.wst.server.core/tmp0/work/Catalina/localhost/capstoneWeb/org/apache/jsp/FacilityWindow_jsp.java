package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.Facility;
import java.util.ArrayList;
import logic.FacilityManager;
import logic.EmployeeManager;
import exceptions.DatabaseConnectionException;

public final class FacilityWindow_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	boolean error = false;
	String errorMessage = "";
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	
	FacilityManager fm = new FacilityManager();
	ArrayList<Facility> facilities = new ArrayList<Facility>();
	try {
		if(session.getAttribute("searchResults") == null)
			facilities = (ArrayList<Facility>) fm.getFacilityList();
		else
		{
			facilities = (ArrayList<Facility>) session.getAttribute("searchResults");
			session.setAttribute("searchResults", null);
		}
	} catch(DatabaseConnectionException e) {
		error = true;
		errorMessage = e.getMessage();
	}
	
	if(request.getParameter("error") != null && request.getParameter("error").equals("main")) {
		error=true;
		errorMessage = request.getParameter("message");
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t\t<title>Indus Recreational Facility | Facility Management</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Main page styling -->\r\n");
      out.write("\t\t<link href=\"css/style.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- List styling -->\r\n");
      out.write("\t\t<link href=\"css/list.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
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
      out.write("  \t\t<!-- Lightbox -->\r\n");
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
      out.write("\t\t      \t$(\"#searchAC\").autocomplete(\"FacilityManager\");\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t  \t</script>\t\t\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  \t");
 if(error==true) { 
      out.write("\r\n");
      out.write("\t  \t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjQuery(document).ready(function($) {\r\n");
      out.write("\t\t\t\tjQuery.facebox({ ajax: 'error.jsp?message=");
      out.print( errorMessage );
      out.write("'})\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 if(request.getParameter("error") != null && request.getParameter("error").equals("info")) { 
      out.write("\r\n");
      out.write("\t  \t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjQuery(document).ready(function($) {\r\n");
      out.write("\t\t\t\tjQuery.facebox({ ajax: 'FacilityInfo.jsp?error=true'})\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
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
      out.write("\t\t\t\t<li><a href=\"BookingWindow.jsp\"><span></span>Schedule</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"InvoiceWindow.jsp\"><span></span>Accounting</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"ClientWindow.jsp\"><span></span>Clients</a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"sel\" href=\"FacilityWindow.jsp\"><span></span>Facilities</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"EmployeeWindow.jsp\"><span></span>Employees</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"OrganizationWindow.jsp\"><span></span>Organizations</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"ManagementWindow.jsp\"><span></span>Management</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t<div class=\"search\">\r\n");
      out.write("\t\t\t\t\t<form action=\"FacilityManager?do=search\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\tSearch Facilities: <br />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"searchAC\" name=\"searchText\" /> <input type=\"submit\" name=\"search\" value=\"Search\" /> <input type=\"submit\" name=\"reset\" value=\"Clear Results\" />\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"listInfo\">\r\n");
      out.write("\t\t\t\t\t<span style=\"float:left\">Showing Results 1-");
      out.print( facilities.size() );
      out.write(" of ");
      out.print( facilities.size() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t<span style=\"float:right\"><a href=\"FacilityInfo.jsp\" rel=\"facebox\">New Facility</a></span><br />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<table class=\"list\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"head\">\r\n");
      out.write("\t\t\t\t\t\t<th>Facility Name</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Open Time</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Close Time</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Max Capacity</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

						if (facilities.size()==0)
						    out.println("<tr><td>No facilites found</td></tr>");
						else
						{
						    for (int i=0; i<facilities.size(); i++)
						    {
				    
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr onclick=\"jQuery.facebox({ ajax: 'FacilityInfo.jsp?facility=");
      out.print( facilities.get(i).getId() );
      out.write("' });\">\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( facilities.get(i).getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( facilities.get(i).getOpenTime() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( facilities.get(i).getCloseTime() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( facilities.get(i).getMaxCapacity() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");

						    }
						}
						fm.close();
				    
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<div class=\"cleaner\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\t\r\n");
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
