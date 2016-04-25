package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.EmployeeManager;
import problemDomain.Facility;
import java.util.ArrayList;
import java.util.List;
import logic.FacilityManager;
import logic.RateManager;
import logic.AdditionalChargeManager;
import exceptions.*;
import problemDomain.Rate;
import problemDomain.AdditionalCharge;

public final class FacilityInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
FacilityManager fm = new FacilityManager();

Facility facility= new Facility();

int facility_id = 0;
String name = "";
int openingTime = 0;
int closingTime = 0;
int setupTime = 0;
int teardownTime = 0;
int capacity = 0;
int length = 0;
int minInterval = 0;

if(request.getParameter("facility") != null) {
	facility = fm.getFacilityInfo(Integer.parseInt(request.getParameter("facility")));
	fm.close();
	
	facility_id = facility.getId();
	name = (facility.getName()==null)?"":facility.getName();
	openingTime = facility.getOpenTime();
	closingTime = facility.getCloseTime();
	setupTime = facility.getSetupTime();
	teardownTime = facility.getTearDownTime();
	capacity = facility.getMaxCapacity();
	length = facility.getMinBookingTime();
	minInterval = facility.getMinBookingInterval();
}

if(request.getParameter("error") != null) {
	//0-id, 1-openTime, 2-closeTime, 3-setupTime, 4-tearDownTime, 5-name, 6-maxCapacity, 7-minInterval, 8-minBookingTime
	ArrayList<String> errorText = (ArrayList<String>) session.getAttribute("errorText");
	
	facility_id = Integer.parseInt(errorText.get(0));
	name = (errorText.get(5)==null)?"":errorText.get(5);
	openingTime = (errorText.get(1)=="")?0:Integer.parseInt(errorText.get(1));
	closingTime = (errorText.get(2)=="")?0:Integer.parseInt(errorText.get(2));
	setupTime = (errorText.get(3)=="")?0:Integer.parseInt(errorText.get(3));
	teardownTime = (errorText.get(4)=="")?0:Integer.parseInt(errorText.get(4));
	capacity = (errorText.get(6)=="")?0:Integer.parseInt(errorText.get(6));
	length = (errorText.get(8)=="")?0:Integer.parseInt(errorText.get(8));
	minInterval = (errorText.get(7)=="")?0:Integer.parseInt(errorText.get(7));

      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" >\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$('label[for=");
      out.print( session.getAttribute("errorField") );
      out.write("]').parent().parent().addClass(\"error\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");

}

      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:47%;\r\n");
      out.write("\t}\n");
      out.write("\t-->\n");
      out.write("</style>\r\n");
      out.write("<form action=\"FacilityManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 600px\">\r\n");
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
      out.write("\t\t<div style=\"width:54%;float:left;padding-right:1%\">\r\n");
      out.write("\t\t\t<fieldset> \r\n");
      out.write("\t\t\t\t<legend><strong>Facility Details</strong></legend>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"name\">Name:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"name\" size=\"15\" value=\"");
      out.print( name );
      out.write("\" /> *</div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"open\">Opening Time:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"open\" size=\"4\" value=\"");
      out.print( openingTime );
      out.write("\" /> HH (24h) *</div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"close\">Closing Time:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"close\" size=\"4\" value=\"");
      out.print( closingTime );
      out.write("\" /> HH (24h) *</div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"setup\">Min. Setup Time:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"setup\" size=\"4\" value=\"");
      out.print( setupTime );
      out.write("\" /> min</div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"teardown\">Min. Tear-down Time:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"teardown\" size=\"4\" value=\"");
      out.print( teardownTime );
      out.write("\" /> min</div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"capacity\">Max Capacity:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"capacity\" size=\"3\" maxlength=\"4\" value=\"");
      out.print( capacity );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"length\">Min. Booking Length:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"length\" size=\"4\" value=\"");
      out.print( length );
      out.write("\" /> min</div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"minInterval\">Min. Booking Intervals:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"minInterval\" size=\"4\" value=\"");
      out.print( minInterval );
      out.write("\" /> min</div></div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"float:right;width:45%\">\r\n");
      out.write("\t\t\t<fieldset> \r\n");
      out.write("\t\t\t\t<legend><strong>Rates</strong></legend>\r\n");
      out.write("\t\t\t\t<select name=\"rates\" size=\"5\" style=\"width:100%\" multiple=\"multiple\">\r\n");
      out.write("\t\t\t\t");

						RateManager rm = new RateManager();
						ArrayList<Rate> rates = new ArrayList<Rate>();
						ArrayList<Rate> selectedRates = (request.getParameter("facility") != null)?(ArrayList) facility.getRates():(ArrayList) session.getAttribute("rates");
						try {
							rates = (ArrayList<Rate>) rm.getRateList();
						} catch(DatabaseConnectionException e) {
							e.printStackTrace();
						}
					    for (int i = 0; i < rates.size(); i++) {
					    	String selected="";
					    	if(request.getParameter("facility") != null || request.getParameter("error") != null) {
						    	for(int j = 0; j < selectedRates.size(); j++) {
						    		if( selectedRates.get(j).getId() == rates.get(i).getId() ){
						    			selected=" selected=\"selected\"";
						    		}
						    	}
					    	}
					    
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print( rates.get(i).getId() );
      out.write('"');
      out.print( selected );
      out.write('>');
      out.print( rates.get(i).getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 	
						} 
					    rm.close();
					
      out.write("\r\n");
      out.write("\t\t\t\t</select></fieldset>\r\n");
      out.write("\t\t\t<fieldset> \r\n");
      out.write("\t\t\t\t<legend><strong>Additional Charges</strong></legend>\r\n");
      out.write("\t\t\t\t<select name=\"addCharges\" size=\"5\" style=\"width:100%\" multiple=\"multiple\">\r\n");
      out.write("\t\t\t\t\t");

						AdditionalChargeManager acm = new AdditionalChargeManager();
						ArrayList<AdditionalCharge> acs = new ArrayList<AdditionalCharge>();
						ArrayList<AdditionalCharge> selectedAcs = (request.getParameter("facility") != null)?(ArrayList) facility.getAdditionalCharges():(ArrayList) session.getAttribute("acs");
						try {
							acs = (ArrayList<AdditionalCharge>) acm.getAdditionalChargeList();
						} catch(DatabaseConnectionException e) {
							e.printStackTrace();
						}
					    for (int i = 0; i < acs.size(); i++) {
					    	String selected="";
					    	if(request.getParameter("facility") != null || request.getParameter("error") != null) {
						    	for(int j = 0; j < selectedAcs.size(); j++) {
						    		if( selectedAcs.get(j).getId() == acs.get(i).getId() ){
						    			selected=" selected=\"selected\"";
						    		}
						    	}
					    	}
					    
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print( acs.get(i).getId() );
      out.write('"');
      out.print( selected );
      out.write('>');
      out.print( acs.get(i).getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 	
						} 
					    acm.close();
					
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print( facility_id );
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
