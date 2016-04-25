<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility | Management</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- List styling -->
		<link href="css/list.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- JQuery Main -->
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		
		<!-- JQuery AutoComplete -->
		<link rel="stylesheet" href="http://dev.jquery.com/view/trunk/plugins/autocomplete/jquery.autocomplete.css" type="text/css" />
		<script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/autocomplete/lib/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/autocomplete/lib/jquery.dimensions.js"></script>
  		<script type="text/javascript" src="http://dev.jquery.com/view/trunk/plugins/autocomplete/jquery.autocomplete.js"></script>
		
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
		      	$("#rateAC").autocomplete("RateManager");
		      	$("#chargeAC").autocomplete("AdditionalChargeManager");
		      	$("#bookingAC").autocomplete("BookingTypeManager");
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
				<li><a href="ScheduleWindow.jsp"><span></span>Schedule</a></li>
				<li><a href="AccountingWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a class="sel" href="ManagmentWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<!-- Rates -->
				<div style="float:left;width:31%;padding-right: 1%;padding-left: 1%;border-right: black solid thin">
					<div class="search">
						<form action="RateManager?do=search" method="post">
							Search Rates: <br />
							<input type="text" id="rateAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
						</form>
					</div>
					<div class="listInfo" style="width: 100%">
						<span style="float:left">Showing Results 1-0 of 0</span>
						<span style="float:right"><a href="RateInfo.jsp" rel="facebox">New Rate</a></span><br />
					</div>
					<table class="list">
						<tr class="head">
							<th>Name</th>
							<th>Rate</th>
						</tr>
						<tr onclick="jQuery.facebox({ ajax: 'RateInfo.jsp?rate=0' });">
							<td>Weekday</td>
							<td>$500/hr</td>
						</tr>
					</table>
				</div>
				<!-- AdditionalCharges -->
				<div style="float:left;width:31%;padding-right: 1%;padding-left: 1%;border-right: black solid thin">
					<div class="search">
						<form action="OrganizationManager?do=search" method="post">
							Search Additional Charges: <br />
							<input type="text" id="chargeAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
						</form>
					</div>
					<div class="listInfo" style="width: 100%">
						<span style="float:left">Showing Results 1-0 of 0</span>
						<span style="float:right"><a href="AdditionalChargeInfo.jsp" rel="facebox">New Additional Charge</a></span><br />
					</div>
					<table class="list">
						<tr class="head">
							<th>Name</th>
							<th>Cost</th>
						</tr>
						<tr onclick="jQuery.facebox({ ajax: 'AdditionalChargeInfo.jsp?ac=0' });">
							<td>Water Cooler</td>
							<td>$50</td>
						</tr>
					</table>
				</div>
				<!-- Booking Types -->
				<div style="float:left;width:31%;padding-right: 1%;padding-left: 1%">
					<div class="search">
						<form action="BookingTypeManager?do=search" method="post">
							Search Booking Types: <br />
							<input type="text" id="bookingAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
						</form>
					</div>
					<div class="listInfo" style="width: 100%">
						<span style="float:left">Showing Results 1-0 of 0</span>
						<span style="float:right"><a href="BookingTypeInfo.jsp" rel="facebox">New Booking Type</a></span><br />
					</div>
					<table class="list">
						<tr class="head">
							<th>Name</th>
						</tr>
						<tr onclick="jQuery.facebox({ ajax: 'BookingTypeInfo.jsp?bt=0' });">
							<td>Hockey Game</td>
						</tr>
					</table>
				</div>
				
				<div class="cleaner"></div>
				<div id="footer">
					&nbsp;
				</div>
			</div>
		</div>		
	</body>
</html>