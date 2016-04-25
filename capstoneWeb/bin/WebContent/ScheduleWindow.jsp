<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="problemDomain.Client,java.util.ArrayList,logic.ClientManager,exceptions.DatabaseConnectionException" %>
<%
	ClientManager cm = new ClientManager();
	ArrayList<Client> clients = new ArrayList<Client>();
	try {
		if(session.getAttribute("searchResults") == null)
			clients = (ArrayList<Client>) cm.getClientList();
		else
			clients = (ArrayList<Client>) session.getAttribute("searchResults");
	} catch(DatabaseConnectionException e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility | Scheduling</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
		<!-- Schedule specific styling -->
		<link href="css/schedule.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- JQuery Main -->
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		
		<!-- JQuery AutoComplete -->
		<link rel="stylesheet" href="http://dev.jquery.com/view/trunk/plugins/autocomplete/jquery.autocomplete.css" type="text/css" />
		<script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/autocomplete/lib/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/autocomplete/lib/jquery.dimensions.js"></script>
  		<script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/autocomplete/jquery.autocomplete.js"></script>
  		
  		<!-- JQuery Datepicker -->
  		<link type="text/css" href="http://jqueryui.com/latest/themes/base/jquery.ui.all.css" rel="stylesheet" />
  		<script type="text/javascript" src="http://jquery-ui.googlecode.com/svn/tags/1.8rc1/jquery-1.4.1.js"></script>
		<script type="text/javascript" src="http://jquery-ui.googlecode.com/svn/tags/1.8rc1/ui/jquery-ui.js"></script>
		
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
		      	$("#searchAC").autocomplete("getClientAutoComplete.jsp");

		      	//setup for datepicker
		      	$("#datepicker").datepicker();
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
			</div>

			<ul id="menu">
				<li><a href="index.jsp"><span></span>Home</a></li>
				<li><a class="sel" href="ScheduleWindow.jsp"><span></span>Schedule</a></li>
				<li><a href="AccountingWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagmentWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<div class="search" style="width:400px">
					<table style="width: 100%">
						<tr>
							<td align="left">Facility: <select><option value="0">Ice Rink</option><option value="1">banquet hall</option></select></td>
							<td align="center">Date: <input type="text" id="datepicker" /></td>
							<td align="right">View: <select><option value="1">Single Day</option><option value="2">Single Week</option><option value="3">Single Month</option></select></td>
						</tr>
					</table>
					<form action="ScheduleManager?do=search" method="post">
						Search Bookings: <br />
						<input type="text" id="searchAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
					</form>
				</div>
				<br /><br />
				<div id="schedule">
					<table>
						<tr>
							<th colspan="12" class="am">AM</th><th colspan="48" class="pm">PM</th>
						</tr>
						<tr class="time">
							<%-- Check how it looks and if you like it. --%>
							<td class="hourBorder" onclick="jQuery.facebox({ ajax: 'BookingInfo.jsp'});">9</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">10</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">11</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">12</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">1</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">2</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">3</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">4</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">5</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">6</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">7</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">8</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">9</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">10</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
							<td class="hourBorder">11</td><td>&nbsp;</td><td class="halfHourBorder">&nbsp;</td><td>&nbsp;</td>
						</tr>
						<tr>
							<td class="closed">&nbsp;</td><td class="closed">&nbsp;</td><td class="closed">&nbsp;</td><td class="closed">&nbsp;</td>
							<td class="unpaidBooking" colspan="5">Hockey</td>
							<td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td>
							<td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td>
							<td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td>
							<td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td>
							<td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td>
							<td class="open">&nbsp;</td><td colspan="5" class="unpaidBooking">Figure Skating</td>
							<td class="open">&nbsp;</td><td colspan="8" class="unpaidBooking">Figure Skating</td>
							<td class="open">&nbsp;</td><td colspan="5" class="paidBooking">Ringette</td>
							<td class="open">&nbsp;</td><td colspan="5" class="paidBooking">Hockey</td>
							<td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td><td class="open">&nbsp;</td>
							<td class="open">&nbsp;</td>
						</tr>
					</table>
				</div>
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
		
	</body>
</html>