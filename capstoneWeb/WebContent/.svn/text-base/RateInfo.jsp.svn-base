<%@page import="problemDomain.Rate, java.util.ArrayList, logic.EmployeeManager, java.util.Date, java.text.SimpleDateFormat, logic.RateManager, exceptions.*" %>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%
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
    NumberFormat nf = new DecimalFormat("#.00");
%>
<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:115px;
	}
	-->
</style>
<form action="RateManager?do=manage" method="post" class="cssForm">
	<div style="width: 500px">
		<% if(request.getParameter("error") != null) { %>
			<div id="errorDesc">
				<%= session.getAttribute("errorMessage") %>
			</div>
		<% } %>
			<div style="width:59%;float:left;padding-right:1%">
				<fieldset> 
					<legend><strong>Rate Details</strong></legend>
					<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="<%= name %>" /> *</div>
					<div class="leftDiv"><label for="rate">Rate: $</label></div><div class="rightDiv"><input type="text" name="rate" size="3" value="<%= nf.format(rate) %>" /> /hr or /day *</div>
					<div class="leftDiv"><label for="bookDep">Booking Deposit: $</label></div><div class="rightDiv"><input type="text" name="bookDep" size="3" value="<%= nf.format(bookingDeposit) %>" /></div>
					<div class="leftDiv"><label for="damDep">Damage Deposit: $</label></div><div class="rightDiv"><input type="text" name="damDep" size="3" value="<%= nf.format(damageDeposit) %>" /></div>
					<div class="leftDiv"><label for="desc">Description:</label></div><div class="rightDiv"><textarea name="desc" rows="3" cols="15"><%= description %></textarea></div>
				</fieldset>
			</div>
			<div style="width:40%;float:right">
				<fieldset>
					<legend><strong>Rate Validation:</strong></legend>
					<fieldset>
						<legend><strong>Rate By:</strong></legend>
							<input type="radio" name="isHourlyValue" value="hourly" id="hourly" <%= hSelected %>><label for="isHourly">Hour</label>
							<input type="radio" name="isHourlyValue" value="daily" id="daily" <%= dSelected %>><label for="isHourly">Day</label><br />
					</fieldset>
					<fieldset>
						<legend><strong>Valid for Days:</strong></legend>
							<input type="checkbox" name="daysValid" value="sunday" <%= Sunday %>><label for="sunday">Sunday</label><br />
							<input type="checkbox" name="daysValid" value="monday" <%= Monday %>><label for="monday">Monday</label><br />
							<input type="checkbox" name="daysValid" value="tuesday" <%= Tuesday %>><label for="tuesday">Tuesday</label><br />
							<input type="checkbox" name="daysValid" value="wednesday" <%= Wednesday %>><label for="wednesday">Wednesday</label><br />
							<input type="checkbox" name="daysValid" value="thursday" <%= Thursday %>></input><label for="thursday">Thursday</label><br />
							<input type="checkbox" name="daysValid" value="friday" <%= Friday %>><label for="friday">Friday</label><br />
							<input type="checkbox" name="daysValid" value="saturday" <%= Saturday %>><label for="saturday">Saturday</label><br />
					</fieldset>
					<fieldset>
						<legend><strong>Valid Time Frame:</strong></legend>
							<input type="text" name="validStartTime" size="3" value="<%= validStartTime %>" />
							<strong> - </strong>
							<input type="text" name="validEndTime" size="3" value="<%= validEndTime %>" />
					</fieldset>
				</fieldset>
			</div>
			<div style="clear:both;text-align:right;padding-top:10px">
				<input type="hidden" name="id" value="<%= id %>" />
				<!-- <input type="reset" value="Reset" /> -->
				<input type="submit" name="save" value="Save" />
				<input type="submit" name="delete" value="Delete" />
			</div>
	</div>
</form>