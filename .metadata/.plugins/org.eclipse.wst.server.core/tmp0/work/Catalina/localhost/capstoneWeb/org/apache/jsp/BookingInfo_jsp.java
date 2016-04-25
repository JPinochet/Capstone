package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import persistence.*;
import logic.*;
import problemDomain.*;
import java.util.ArrayList;
import exceptions.*;
import java.util.Date;
import logic.EmployeeManager;
import logic.FacilityManager;
import problemDomain.Facility;
import problemDomain.Employee;
import java.text.SimpleDateFormat;
import logic.BookingManager;
import problemDomain.Booking;

public final class BookingInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	int id=0;
	Facility facility = new Facility();
	int creator = (Integer)session.getAttribute("user");
	String eventName = "";
	String client = "";
	int bookingType = 0;
	int rate = 0;
	String guestCount = "";
	Date startTime = new Date();
	String length = "0";
	String setup = "0";
	String teardown = "0";
	String disabled = "";
	
	ArrayList<AdditionalCharge> selectedAcs = new ArrayList<AdditionalCharge>();
	
	SimpleDateFormat df = new SimpleDateFormat("HH:mm");
	
	if(request.getParameter("facility") != null && request.getParameter("time") != null) {
		FacilityManager fm = new FacilityManager();
		facility = fm.getFacilityInfo(Integer.parseInt(request.getParameter("facility")));
		fm.close();
		
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startTime = df2.parse(request.getParameter("time"));
		
		setup = facility.getSetupTime()+"";
		teardown = facility.getTearDownTime()+"";
		length = facility.getMinBookingTime()+"";
		if(facility.getMaxCapacity()==0)
			disabled = "disabled=\"disabled\"";
		else
			guestCount = "0";
	} else if(request.getParameter("booking") != null) {
		BookingManager bm = new BookingManager();
		Booking booking = bm.getBookingInformation(Integer.parseInt(request.getParameter("booking")));
		
		id = booking.getId();
		
		FacilityManager fm = new FacilityManager();
		facility = fm.getFacilityInfo(booking.getFacility().getId());
		fm.close();
		
		eventName = booking.getEventTitle();
		
		ClientManager cm = new ClientManager();
		booking.setClient(cm.getClientInfo(booking.getClient().getId()));
		client = booking.getClient().getGivenName() + " " + booking.getClient().getSurname();
		cm.close();
		
		bookingType = booking.getEventType().getId();
		rate = booking.getRate().getId();
		startTime = booking.getStartTime();
		length = booking.getLength()+"";
		setup = booking.getSetupTime()+"";
		teardown = booking.getTearDownTime()+"";
		selectedAcs = booking.getAdditionalCharges();
		if(facility.getMaxCapacity()==0)
			disabled = "disabled=\"disabled\"";
		else
			guestCount = booking.getNumberOfPeople()+"";
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\r\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:40%;\r\n");
      out.write("\t}\r\n");
      out.write("\t-->\r\n");
      out.write("</style>\r\n");
      out.write("\t<!-- JQuery Main -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery-latest.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- JQuery AutoComplete -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/jquery.autocomplete.css\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery.bgiframe.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/jquery.dimensions.js\"></script>\r\n");
      out.write("  \t\t<script type=\"text/javascript\" src=\"js/jquery.autocomplete.js\"></script>\t\r\n");
      out.write("        \r\n");
      out.write("        <!-- Lightbox -->\r\n");
      out.write("        <link href=\"css/facebox.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("        <script src=\"js/facebox.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//Run on page load\r\n");
      out.write("    jQuery(document).ready(function($) {\r\n");
      out.write("\t\t//setup for autocomplete\r\n");
      out.write("      \t$(\"#clientAC\").autocomplete(\"ClientManager\");\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<form action=\"BookingManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 950px\">\r\n");
      out.write("\t\t<div style=\"width:39%;float:left;padding-right:1%\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<legend><strong>Event Details</strong></legend>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"eventName\">Event Name:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input id=\"eventName\" type=\"text\" name=\"eventName\" size=\"20\" value=\"");
      out.print( eventName );
      out.write("\" />*\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"client\">Client:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"client\" size=\"20\" value=\"");
      out.print( client );
      out.write("\" id=\"clientAC\" />*\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"bookingType\">Booking Type:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<select name=\"bookingType\" id=\"bookingType\">\r\n");
      out.write("\t\t\t\t\t");

						BookingTypeManager btm = new BookingTypeManager();
						ArrayList<BookingType> bts = new ArrayList<BookingType>();
						try {
							bts = (ArrayList<BookingType>) btm.getBookingTypeList();
						} catch(DatabaseConnectionException e) {
							e.printStackTrace();
						}

					    for (BookingType bt : bts) {
					    	String selected="";
					    	if(request.getParameter("booking") != null || request.getParameter("error") != null) {
						    	if( bookingType == bt.getId() ){
					    			selected=" selected=\"selected\"";
					    		}
					    	}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print( bt.getId() );
      out.write('"');
      out.print(selected );
      out.write('>');
      out.print( bt.getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 
						} 
					
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"rate\">Rate:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<select name=\"rate\" id=\"rate\">\r\n");
      out.write("\t\t\t\t\t");

						ArrayList<Rate> rates = facility.getRates();

					    for (Rate r : rates) {
					    	String selected="";
					    	if(request.getParameter("booking") != null || request.getParameter("error") != null) {
						    	if( rate == r.getId() ){
					    			selected=" selected=\"selected\"";
					    		}
					    	}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print( r.getId() );
      out.write('"');
      out.print(selected );
      out.write('>');
      out.print( r.getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 
						} 
					
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"people\">Guest Count:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"people\" name=\"people\" size=\"3\" value=\"");
      out.print( guestCount );
      out.write('"');
      out.print( disabled );
      out.write(" />\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"Catering\" />\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"float:left;width:29%;padding-right:1%\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<legend><strong>Time</strong></legend>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"start\">Start Time:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"start\" name=\"start\" size=\"3\" value=\"");
      out.print( df.format(startTime) );
      out.write("\" /> HH:mm\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"length\">Length:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"length\" name=\"length\" size=\"3\" value=\"");
      out.print( length );
      out.write("\" /> min *\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"setup\">Setup Time:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"setup\" name=\"setup\" size=\"3\" value=\"");
      out.print( setup );
      out.write("\" /> min\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\">\r\n");
      out.write("\t\t\t\t\t<label for=\"teardown\">Teardown Time:</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"rightDiv\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"teardown\" name=\"teardown\" size=\"3\" value=\"");
      out.print( teardown );
      out.write("\" /> min\r\n");
      out.write("\t\t\t\t</div></div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"float:right;width:30%\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<legend><strong>Additional Charges</strong></legend>\r\n");
      out.write("\t\t\t\t<select name=\"additionalCharges\" size=\"8\" style=\"width:100%\" multiple=\"multiple\">\r\n");
      out.write("\t\t\t\t\t");

						ArrayList<AdditionalCharge> adc = facility.getAdditionalCharges();
					    
						for (AdditionalCharge ac : adc) {
					    	String selected="";					    	
					    	if(request.getParameter("booking") != null || request.getParameter("error") != null) {
					    		for(int j=0; j<selectedAcs.size(); j++) {
							    	if( selectedAcs.get(j).getId() == ac.getId() ){
						    			selected=" selected=\"selected\"";
						    		}
					    		}
					    	}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print( ac.getId() );
      out.write('"');
      out.print(selected );
      out.write('>');
      out.print( ac.getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 
						} 
					
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"date\" value=\"");
      out.print( new SimpleDateFormat("yyyy-MM-dd").format(startTime) );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"creator\" value=\"");
      out.print( creator );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"facility\" value=\"");
      out.print( facility.getId() );
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
