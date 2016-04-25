package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.Rate;
import java.util.ArrayList;
import logic.EmployeeManager;
import java.util.Date;
import java.text.SimpleDateFormat;
import logic.RateManager;
import exceptions.*;

public final class RateInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	RateManager rm = new RateManager();
	Rate rates = new Rate();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	int id = 0;
	String name = "";
	String description = "";
	double rate = 0;
	double damageDeposit = 0;
	double bookingDeposit = 0;
	boolean isHourly = false;
	String hSelected = "checked=\"checked\"";
	String dSelected = "";
	String validStartTime = "08:00";
	String validEndTime = "22:00";
	boolean sunday = false;
	String Sunday = "";
	boolean monday = false;
	String Monday = "";
	boolean tuesday = false;
	String Tuesday = "";
	boolean wednesday = false;
	String Wednesday = "";
	boolean thursday = false;
	String Thursday = "";
	boolean friday = false;
	String Friday = "";
	boolean saturday = false;
	String Saturday = "";
	
	if (request.getParameter("rate") !=null)
	{
		rates = rm.getRateInfo(Integer.parseInt(request.getParameter("rate")));
		rm.close();
		
		id = rates.getId();
		name = (rates.getName()==null)?"":rates.getName();
		description = (rates.getDescription()==null)?"":rates.getDescription();
		rate = rates.getRate();
		damageDeposit = rates.getDamageDeposit();
		bookingDeposit = rates.getBookingDeposit();
		
		isHourly = rates.isHourly();
		if(!isHourly)
		{	
			dSelected = "checked=\"checked\"";
			hSelected = "";
		}
		
		validStartTime = sdf.format(rates.getValidStartTime());
		validEndTime = sdf.format(rates.getValidEndTime());
		
		sunday = rates.isSunday();
		if(sunday)
			Sunday = "checked=\"checked\"";
		
		monday = rates.isMonday();
		if(monday)
			Monday = "checked=\"checked\"";
		
		tuesday = rates.isTuesday();
		if(tuesday)
			Tuesday = "checked=\"checked\"";
		
		wednesday = rates.isWednesday();
		if(wednesday)
			Wednesday = "checked=\"checked\"";
		
		thursday = rates.isThursday();
		if(thursday)
			Thursday = "checked=\"checked\"";
		
		friday = rates.isFriday();
		if(friday)
			Friday = "checked=\"checked\"";
		
		saturday = rates.isSaturday();
		if(saturday)
			Saturday = "checked=\"checked\"";
		
	}

      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:115px;\r\n");
      out.write("\t}\n");
      out.write("\t-->\n");
      out.write("</style>\r\n");
      out.write("<form action=\"RateManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 500px\">\r\n");
      out.write("\t\t");
 if(request.getParameter("error") != null) { 
      out.write("\r\n");
      out.write("\t\t\t<div id=\"errorDesc\">\r\n");
      out.write("\t\t\t\t");
      out.print( session.getAttribute("errorMessage") );
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<div style=\"width:59%;float:left;padding-right:1%\">\r\n");
      out.write("\t\t\t\t<fieldset> \r\n");
      out.write("\t\t\t\t\t<legend><strong>Rate Details</strong></legend>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftDiv\"><label for=\"name\">Name:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"name\" size=\"15\" value=\"");
      out.print( name );
      out.write("\" /> *</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftDiv\"><label for=\"rate\">Rate: $</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"rate\" size=\"3\" value=\"");
      out.print( rate );
      out.write("\" /> /hr or /day *</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftDiv\"><label for=\"bookDep\">Booking Deposit: $</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"bookDep\" size=\"3\" value=\"");
      out.print( bookingDeposit );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftDiv\"><label for=\"damDep\">Damage Deposit: $</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"damDep\" size=\"3\" value=\"");
      out.print( damageDeposit );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftDiv\"><label for=\"desc\">Description:</label></div><div class=\"rightDiv\"><textarea name=\"desc\" rows=\"3\" cols=\"15\">");
      out.print( description );
      out.write("</textarea></div>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"width:40%;float:right\">\r\n");
      out.write("\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t<legend><strong>Rate Validation:</strong></legend>\r\n");
      out.write("\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t<legend><strong>Rate By:</strong></legend>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"isHourlyValue\" value=\"hourly\" id=\"hourly\" ");
      out.print( hSelected );
      out.write("><label for=\"isHourly\">Hour</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"isHourlyValue\" value=\"daily\" id=\"daily\" ");
      out.print( dSelected );
      out.write("><label for=\"isHourly\">Day</label><br />\r\n");
      out.write("\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t<legend><strong>Valid for Days:</strong></legend>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"sunday\" ");
      out.print( Sunday );
      out.write("><label for=\"sunday\">Sunday</label><br />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"monday\" ");
      out.print( Monday );
      out.write("><label for=\"monday\">Monday</label><br />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"tuesday\" ");
      out.print( Tuesday );
      out.write("><label for=\"tuesday\">Tuesday</label><br />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"wednesday\" ");
      out.print( Wednesday );
      out.write("><label for=\"wednesday\">Wednesday</label><br />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"thursday\" ");
      out.print( Thursday );
      out.write("></input><label for=\"thursday\">Thursday</label><br />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"friday\" ");
      out.print( Friday );
      out.write("><label for=\"friday\">Friday</label><br />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"daysValid\" value=\"saturday\" ");
      out.print( Saturday );
      out.write("><label for=\"saturday\">Saturday</label><br />\r\n");
      out.write("\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t<legend><strong>Valid Time Frame:</strong></legend>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"validStartTime\" size=\"3\" value=\"");
      out.print( validStartTime );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<strong> - </strong>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"validEndTime\" size=\"3\" value=\"");
      out.print( validEndTime );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\" />\r\n");
      out.write("\t\t\t\t<!-- <input type=\"reset\" value=\"Reset\" /> -->\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"save\" value=\"Save\" />\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"delete\" value=\"Delete\" />\r\n");
      out.write("\t\t\t</div>\r\n");
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
