<%@page import="persistence.*, logic.*, problemDomain.*, java.util.ArrayList, exceptions.*,java.util.Date,logic.EmployeeManager,logic.FacilityManager,problemDomain.Facility, problemDomain.Employee,java.text.SimpleDateFormat"%>
<%
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
%>

<%@page import="logic.BookingManager, problemDomain.Booking"%>
<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:40%;
	}
	-->
</style>
	<!-- JQuery Main -->
		<script type="text/javascript" src="js/jquery-latest.js"></script>
		
		<!-- JQuery AutoComplete -->
		<link rel="stylesheet" href="css/jquery.autocomplete.css" type="text/css" />
		<script type="text/javascript" src="js/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="js/jquery.dimensions.js"></script>
  		<script type="text/javascript" src="js/jquery.autocomplete.js"></script>	
        
        <!-- Lightbox -->
        <link href="css/facebox.css" rel="stylesheet" type="text/css" media="screen" />
        <script src="js/facebox.js" type="text/javascript"></script> 
<script type="text/javascript">
	//Run on page load
    jQuery(document).ready(function($) {
		//setup for autocomplete
      	$("#clientAC").autocomplete("ClientManager");
    });
</script>

<form action="BookingManager?do=manage" method="post" class="cssForm">
	<div style="width: 950px">
		<div style="width:39%;float:left;padding-right:1%">
			<fieldset>
				<legend><strong>Event Details</strong></legend>
				<div class="field"><div class="leftDiv">
					<label for="eventName">Event Name:</label>
				</div>
				<div class="rightDiv">
					<input id="eventName" type="text" name="eventName" size="20" value="<%= eventName %>" />*
				</div></div>
				
				<div class="field"><div class="leftDiv">
					<label for="client">Client:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="client" size="20" value="<%= client %>" id="clientAC" />*
				</div></div>
				
				<div class="field"><div class="leftDiv">
					<label for="bookingType">Booking Type:</label>
				</div>
				<div class="rightDiv">
					<select name="bookingType" id="bookingType">
					<%
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
					%>
						<option value="<%= bt.getId() %>"<%=selected %>><%= bt.getName() %></option>
					<% 
						} 
					%>
					</select>
				</div></div>
				
				<div class="field"><div class="leftDiv">
					<label for="rate">Rate:</label>
				</div>
				<div class="rightDiv">
					<select name="rate" id="rate">
					<%
						ArrayList<Rate> rates = facility.getRates();

					    for (Rate r : rates) {
					    	String selected="";
					    	if(request.getParameter("booking") != null || request.getParameter("error") != null) {
						    	if( rate == r.getId() ){
					    			selected=" selected=\"selected\"";
					    		}
					    	}
					%>
						<option value="<%= r.getId() %>"<%=selected %>><%= r.getName() %></option>
					<% 
						} 
					%>
					</select>
				</div></div>
				
				<div class="field"><div class="leftDiv">
					<label for="people">Guest Count:</label>
				</div>
				<div class="rightDiv">
					<input type="text" id="people" name="people" size="3" value="<%= guestCount %>"<%= disabled %> />
				</div></div>
					
				<div class="field"><div class="leftDiv"></div>
				<div class="rightDiv">
					<input type="button" value="Catering" />
				</div></div>
			</fieldset>
		</div>
		
		<div style="float:left;width:29%;padding-right:1%">
			<fieldset>
				<legend><strong>Time</strong></legend>
				<div class="field"><div class="leftDiv">
					<label for="start">Start Time:</label>
				</div>
				<div class="rightDiv">
					<input type="text" id="start" name="start" size="3" value="<%= df.format(startTime) %>" /> HH:mm
				</div></div>
					
				<div class="field"><div class="leftDiv">
					<label for="length">Length:</label>
				</div>
				<div class="rightDiv">
					<input type="text" id="length" name="length" size="3" value="<%= length %>" /> min *
				</div></div>
					
				<div class="field"><div class="leftDiv">
					<label for="setup">Setup Time:</label>
				</div>
				<div class="rightDiv">
					<input type="text" id="setup" name="setup" size="3" value="<%= setup %>" /> min
				</div></div>
					
				<div class="field"><div class="leftDiv">
					<label for="teardown">Teardown Time:</label>
				</div>
				<div class="rightDiv">
					<input type="text" id="teardown" name="teardown" size="3" value="<%= teardown %>" /> min
				</div></div>
			</fieldset>
		</div>
		
		<div style="float:right;width:30%">
			<fieldset>
				<legend><strong>Additional Charges</strong></legend>
				<select name="additionalCharges" size="8" style="width:100%" multiple="multiple">
					<%
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
					%>
						<option value="<%= ac.getId() %>"<%=selected %>><%= ac.getName() %></option>
					<% 
						} 
					%>
				</select>
			</fieldset>
		</div>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="<%= id %>" />
			<input type="hidden" name="date" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(startTime) %>" />
			<input type="hidden" name="creator" value="<%= creator %>" />
			<input type="hidden" name="facility" value="<%= facility.getId() %>" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="save" value="Save" />
			<input type="submit" name="delete" value="Delete" />
		</div>
	</div>
</form>