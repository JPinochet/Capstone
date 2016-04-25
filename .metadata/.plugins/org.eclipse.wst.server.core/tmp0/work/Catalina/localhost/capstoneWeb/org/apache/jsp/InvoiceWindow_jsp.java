package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.*;
import java.util.ArrayList;
import logic.ClientManager;
import logic.EmployeeManager;
import exceptions.DatabaseConnectionException;
import logic.InvoiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class InvoiceWindow_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	ArrayList<Client> clients = new ArrayList<Client>();
	boolean search = false;
	if(request.getParameter("client") != null) {
		ClientManager cm = new ClientManager();
		clients.add(cm.getClientInfo(Integer.parseInt(request.getParameter("client"))));
	}else if(session.getAttribute("searchResults") != null) {
		clients = (ArrayList<Client>) session.getAttribute("searchResults");
		session.setAttribute("searchResults", null);
		search = true;
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t\t<title>Indus Recreational Facility | Accounting</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Main page styling -->\r\n");
      out.write("\t\t<link href=\"css/style.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Main page styling -->\r\n");
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
      out.write("\t\t      \t$(\"#searchAC\").autocomplete(\"ClientManager\");\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t  \t</script>\r\n");
      out.write("\t\t\r\n");
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
      out.write("\t\t\t\t<li><a class=\"sel\" href=\"InvoiceWindow.jsp\"><span></span>Accounting</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"ClientWindow.jsp\"><span></span>Clients</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"FacilityWindow.jsp\"><span></span>Facilities</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"EmployeeWindow.jsp\"><span></span>Employees</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"OrganizationWindow.jsp\"><span></span>Organizations</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"ManagementWindow.jsp\"><span></span>Management</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t<div class=\"search\">\r\n");
      out.write("\t\t\t\t\t<form action=\"InvoiceManager?do=search\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\tClient: <br />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"searchAC\" name=\"searchText\" /> <input type=\"submit\" name=\"search\" value=\"Search\" /> <input type=\"submit\" name=\"reset\" value=\"Clear Results\" />\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
 
				InvoiceManager im = new InvoiceManager();
				if (search || request.getParameter("client") != null) { 
					if(clients.size() == 1) {
						Client c = clients.get(0);
						ArrayList<Invoice> invoices = (ArrayList<Invoice>) im.getInvoicesForClient(c.getId());
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"listInfo\">\r\n");
      out.write("\t\t\t\t\t<span style=\"float:left\">Showing Invoices ");
      out.print( (invoices.isEmpty())?"0":"1" );
      out.write('-');
      out.print( invoices.size() );
      out.write(" for client: ");
      out.print( c.getGivenName() + " " + c.getSurname() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t<span style=\"float:right\"><a href=\"InvoiceInfo.jsp?client=");
      out.print( c.getId() );
      out.write("\" rel=\"facebox\">New Invoice</a></span><br />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<table class=\"list\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"head\">\r\n");
      out.write("\t\t\t\t\t\t<th>Invoice #</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"padding:0 10px\">Date</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Paid</th>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"3\">Reporting</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
      out.print( (invoices.isEmpty())?"<tr><td colspan=\"6\">No Invoices Found</td></tr>":"" );
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 
						for(Invoice i : invoices) { 
							String onclick = i.getPaid()?"jQuery.facebox({ ajax: 'InvoiceInfo.jsp?invoice=" + i.getId() + "' });":"jQuery.facebox({ ajax: 'PayInvoice.jsp?invoice=" + i.getId() + "' });";
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td onclick=\"jQuery.facebox({ ajax: 'InvoiceInfo.jsp?invoice=");
      out.print( i.getId() );
      out.write("' });\">");
      out.print( i.getId() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td onclick=\"jQuery.facebox({ ajax: 'InvoiceInfo.jsp?invoice=");
      out.print( i.getId() );
      out.write("' });\">");
      out.print( new SimpleDateFormat("MM/dd/yyyy").format(i.getDate()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td onclick=\"");
      out.print( onclick );
      out.write('"');
      out.write('>');
      out.print( i.getPaid()?"Paid":"<u>Due On:" + new SimpleDateFormat("MM/dd/yyyy").format(i.getDueDate()) + "</u>" );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"#\" onclick=\"$.ajax({url: 'InvoiceManager?email=");
      out.print( i.getId() );
      out.write("', success: function(data) { alert('Invoice emailed to ");
      out.print( c.getGivenName() + " " + c.getSurname() );
      out.write("'); } });\"><img src=\"img/icons/email_go.png\" alt=\"Email\" title=\"Email\" border=\"0\" /></a></td>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"invoice.jsp?invoice=");
      out.print( i.getId() );
      out.write("\" target=\"_blank\"><img src=\"img/icons/printer.png\" alt=\"Print\" title=\"Print\" border=\"0\" /></a></td>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"csvInvoice.jsp?invoice=");
      out.print( i.getId() );
      out.write("\"><img src=\"img/icons/page_excel.png\" alt=\"Excel\" title=\"Excel\" border=\"0\" /></a></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
 
						} 
					
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t");
 
					} else if(clients.size() > 1) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div align=\"center\">Multiple clients found. Please choose one:</div>\r\n");
      out.write("\t\t\t\t<table class=\"list\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>Client Name</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

					for(Client c : clients) { 
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr onclick=\"location='InvoiceWindow.jsp?client=");
      out.print(c.getId() );
      out.write("'\"><td>");
      out.print( c.getGivenName() + " " + c.getSurname() );
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\t");

					} 
					
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div align=\"center\">No clients found.</div>\r\n");
      out.write("\t\t\t\t");

					}
				} else { 
				
      out.write("\r\n");
      out.write("\t\t\t\t<div align=\"center\">Search for a client to display invoices for.</div>\r\n");
      out.write("\t\t\t\t");
 
				} 
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"cleaner\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
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
