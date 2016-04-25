
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="problemDomain.BookingType, java.util.ArrayList, logic.BookingTypeManager, exceptions.DatabaseConnectionException" %>
<%@ page import="problemDomain.AdditionalCharge, logic.AdditionalChargeManager" %>
<%@ page import="problemDomain.Rate, logic.RateManager, logic.EmployeeManager" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
%>
<%	
		BookingTypeManager btm = new BookingTypeManager();
		ArrayList<BookingType> bookings = new ArrayList<BookingType>();
		try {
				if(session.getAttribute("searchResultsBT") == null)
					bookings = (ArrayList<BookingType>) btm.getBookingTypeList();
				else
				{
					bookings = (ArrayList<BookingType>) session.getAttribute("searchResultsBT");
					session.setAttribute("searchResultsBT", null);
				}
				btm.close();
			} 
		catch(DatabaseConnectionException e) 
			{
				e.printStackTrace();
			}
%>

<%	
		AdditionalChargeManager acm = new AdditionalChargeManager();
		ArrayList<AdditionalCharge> additions = new ArrayList<AdditionalCharge>();
		try {
				if(session.getAttribute("searchResultsAC") == null)
					additions = (ArrayList<AdditionalCharge>) acm.getAdditionalChargeList();
				else
				{
					additions = (ArrayList<AdditionalCharge>) session.getAttribute("searchResultsAC");
					session.setAttribute("searchResultsAC", null);
				}
				acm.close();
			} 
		catch(DatabaseConnectionException e) 
			{
				e.printStackTrace();
			}
%>

<%	
		RateManager rm = new RateManager();
		ArrayList<Rate> rates = new ArrayList<Rate>();
		try {
				if(session.getAttribute("searchResultsRate") == null)
					rates = (ArrayList<Rate>) rm.getRateList();
				else
				{
					rates = (ArrayList<Rate>) session.getAttribute("searchResultsRate");
					session.setAttribute("searchResultsRate", null);
				}
				rm.close();
			} 
		catch(DatabaseConnectionException e) 
			{
				e.printStackTrace();
			}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.text.NumberFormat"%><html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility | Management</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- List styling -->
		<link href="css/list.css" rel="stylesheet"  type="text/css" media="screen" />
		
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
				<div id="logout">
					<a href="LoginManager?logout=true">Logout</a>
				</div>
			</div>

			<ul id="menu">
				<li><a href="index.jsp"><span></span>Home</a></li>
				<li><a href="BookingWindow.jsp"><span></span>Schedule</a></li>
				<li><a href="InvoiceWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a class="sel" href="ManagementWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<!-- Rates -->
				<div style="float:left;width:31%;padding-right: 1%;padding-left: 1%;border-right: black solid thin; height:100%">
					<div class="search">
						<form action="RateManager?do=searchRate" method="post">
							Search Rates: <br />
							<input type="text" id="rateAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
						</form>
					</div>
					<div class="listInfo" style="width: 100%">
						<span style="float:left">Showing Results 1-<%= rates.size() %> of <%= rates.size() %></span>
						<span style="float:right"><a href="RateInfo.jsp" rel="facebox">New Rate</a></span><br />
					</div>
					<table class="list">
						<tr class="head">
							<th>Name</th>
							<th>Description</th>
							<th>Rate</th>
						</tr>
						<%
							if(rates.size()==0)
								out.println("<tr><td colspan=\"5\">No rates found</td></tr>");
							else
							{
								for (int i = 0; i < rates.size(); i++)
								{
						%>
						<tr onclick="jQuery.facebox({ ajax: 'RateInfo.jsp?rate=<%= rates.get(i).getId() %>' });">
							<td><%= rates.get(i).getName() %></td>
							<td><%= rates.get(i).getDescription() %></td>
							<td style="text-align: right;"><%= NumberFormat.getCurrencyInstance().format(rates.get(i).getRate()) %></td>
						</tr>
						<%
						    }
						}
				    %>
					</table>
				</div>
				<!-- AdditionalCharges -->
				<div style="float:left;width:31%;padding-right: 1%;padding-left: 1%;border-right: black solid thin">
					<div class="search">
						<form action="AdditionalChargeManager?do=searchAC" method="post">
							Search Additional Charges: <br />
							<input type="text" id="chargeAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
						</form>
					</div>
					<div class="listInfo" style="width: 100%">
						<span style="float:left">Showing Results 1-<%= additions.size() %> of <%= additions.size() %></span>
						<span style="float:right"><a href="AdditionalChargeInfo.jsp" rel="facebox">New Additional Charge</a></span><br />
					</div>
					<table class="list">
						<tr class="head">
							<th>Name</th>
							<th>Cost</th>
						</tr>
						
						<%
							if(additions.size()==0)
								out.println("<tr><td colspan=\"5\">No clients found</td></tr>");
							else
							{
								for (int i=0; i < additions.size(); i++)
								{
						%>
						<tr onclick="jQuery.facebox({ ajax: 'AdditionalChargeInfo.jsp?addition=<%= additions.get(i).getId() %>' });">
							<td><%= additions.get(i).getName() %></td>
							<td style="text-align: right;"><%= NumberFormat.getCurrencyInstance().format(additions.get(i).getCost()) %></td>
						</tr>
						<%
						    }
						}
				    %>
					</table>
				</div>
				<!-- Booking Types -->
				<div style="float:left;width:31%;padding-right: 1%;padding-left: 1%">
					<div class="search">
						<form action="BookingTypeManager?do=searchBT" method="post">
							Search Booking Types: <br />
							<input type="text" id="bookingAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
						</form>
					</div>
					<div class="listInfo" style="width: 100%">
						<span style="float:left">Showing Results 1-<%= bookings.size() %> of <%= bookings.size() %></span>
						<span style="float:right"><a href="BookingTypeInfo.jsp" rel="facebox">New Booking Type</a></span><br />
					</div>
					<table class="list">
						<tr class="head">
							<th>Name</th>
							<th>Setup Time</th>
							<th>Teardown Time</th>
						</tr>
						
						<%
							if(bookings.size()==0)
							{
								out.println("<tr><td colspan=\"5\">No booking types found</td></tr>");
							}
							else
							{	
								for (int i=0; i < bookings.size(); i++)
								{
						%>
						<tr onclick="jQuery.facebox({ ajax: 'BookingTypeInfo.jsp?btype=<%= bookings.get(i).getId() %>' });">
							<td><%= bookings.get(i).getName() %></td>
							<td><%= bookings.get(i).getSetupTime() %></td>
							<td><%= bookings.get(i).getTearDownTime() %></td>
						</tr>
						
						<%
							}
						}	
						%>
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