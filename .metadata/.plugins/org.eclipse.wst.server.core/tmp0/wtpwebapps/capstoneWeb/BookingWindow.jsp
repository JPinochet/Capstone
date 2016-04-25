<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="problemDomain.Booking,java.util.ArrayList,logic.BookingManager,logic.EmployeeManager,exceptions.*,java.util.Date" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	BookingManager bm = new BookingManager();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="logic.BookingManager"%>
<%@page import="problemDomain.Facility"%>

<%@page import="logic.FacilityManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%><html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility | Scheduling</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
		<!-- Schedule specific styling -->
		<link href="css/schedule.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- JQuery Main -->
		<script type="text/javascript" src="js/jquery-latest.js"></script>
		
		<!-- JQuery AutoComplete -->
		<link rel="stylesheet" href="css/jquery.autocomplete.css" type="text/css" />
		<script type="text/javascript" src="js/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="js/jquery.dimensions.js"></script>
  		<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
  		
  		<!-- JQuery Datepicker -->
  		<link type="text/css" href="css/jquery.ui.all.css" rel="stylesheet" />
  		<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
  		
  		<!-- JQuery Tooltip -->
  		<link type="text/css" href="css/jquery.tooltip.css" rel="stylesheet" />
  		<script type="text/javascript" src="js/jquery.bgiframe.js"></script>
		<script type="text/javascript" src="js/jquery.tooltip.js"></script>
		
		<!-- Lightbox -->
		<link href="css/facebox.css" rel="stylesheet" type="text/css" media="screen" />
		<script src="js/facebox.js" type="text/javascript"></script> 
		
		<script type="text/javascript">
			//Run on page load
		    jQuery(document).ready(function($) {
				//Make all a tags with a rel="facebox" open a facebox
		      	$('a[rel*=facebox]').facebox({
		        	loading_image : '/facebox/loading.gif',
		        	close_image   : '/facebox/closelabel.gif'
		      	}); 

				//setup for autocomplete
		      	//$("#searchAC").autocomplete("BookingManager");

		      	//setup for datepicker
		      	$("#datepicker").datepicker();

		      	//Tooltips for schedule
		      	$("#schedule *").tooltip({
		      		showBody: " -- "
		      	});
		    });
	  	</script>		
	</head>
	
	<body>
		<div id="topbg"></div>

		<div id="main">
			<div id="header">
				<div id="hdr-overlay"></div>
				<div id="hdr-box1" class="box"></div>
				<div id="hdr-box2" class="box"></div>
				<div id="hdr-box3" class="box"></div>
				<div id="hdr-box4" class="box"></div>
				<h1>Indus Recreational Facility</h1>
				<div id="logout">
					<a href="LoginManager?logout=true">Logout</a>
				</div>
			</div>

			<ul id="menu">
				<li><a href="index.jsp"><span></span>Home</a></li>
				<li><a class="sel" href="BookingWindow.jsp"><span></span>Schedule</a></li>
				<li><a href="InvoiceWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagementWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<div class="search" style="width:400px">
					<form action="BookingManager?do=search" method="post">
						<table style="width: 100%">
							<tr>
								<td align="left">Facility: 
									<select name="facility">
										<%
											FacilityManager fm = new FacilityManager();
											ArrayList<Facility> facilites = (ArrayList<Facility>) fm.getFacilityList();
											
											for (Facility f : facilites) {
										%>
										<option value="<%= f.getId() %>"><%= f.getName() %></option>
										<%
											}
										%>
									</select>
								</td>
								<% SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); %>
								<td align="center">Date: <input type="text" id="datepicker" name="date" value="<%= formatter.format(new Date()) %>" /></td>
								<td align="right">View: 
									<select name="view">
										<option value="1">Single Day</option>
										<option value="2">Single Week</option>
										<option value="3">Single Month</option>
									</select>
								</td>
							</tr>
						</table>
					
						Search Bookings: <br />
						<input type="text" id="searchAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
					</form>
				</div>
				<br /><br />
				<div id="schedule"></div>
				<br /><br />
				&nbsp;<u>Available Time</u><br />
				&nbsp;March 10, 2010:
				<ul>
					<li>11:15am - 4:15pm</li>
					<li>10:45pm - 12:00pm</li>
				</ul>
				<div class="cleaner"></div>
				<div id="footer">
					&nbsp;
				</div>
			</div>
		</div>
		
					<script>
				    	$("select").change(function () {
				        	var update = "BookingManager?f=";
				          	$("select[name='facility'] option:selected").each(function () {
				          		update += $(this).val() + "&date=" + $("input[name='date']").val() + "&view=";
				            });
				          	$("select[name='view'] option:selected").each(function () {
				          		update += $(this).val();
				            });

				            $('#schedule').html('<center><strong>Loading Schedule</strong><br /><img src="img/facebox/loading.gif" alt="loading" /></center>');
				            
				          	$('#schedule').load(update, function() {
				          		$("td").tooltip({
						      		showBody: " -- "
						      	});
				          	});
				        }).change();

				        $("input[name='date']").change(function () {
				        	var update = "BookingManager?f=";
				          	$("select[name='facility'] option:selected").each(function () {
				          		update += $(this).val() + "&date=" + $("input[name='date']").val() + "&view=";
				            });
				          	$("select[name='view'] option:selected").each(function () {
				          		update += $(this).val();
				            });

				            $('#schedule').html('<center><strong>Loading Schedule</strong><br /><img src="img/facebox/loading.gif" alt="loading" /></center>');
				            
				          	$('#schedule').load(update, function() {
				          		$("td").tooltip({
						      		showBody: " -- "
						      	});
				          	});
				        });
					</script>
	</body>
</html>
<% bm.close(); %>