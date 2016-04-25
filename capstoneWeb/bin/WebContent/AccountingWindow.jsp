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
		<title>Indus Recreational Facility | Accounting</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- Main page styling -->
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
		      	$("#searchAC").autocomplete("getClientAutoComplete.jsp");
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
				<li><a class="sel" href="AccountingWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagmentWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<div class="search">
					<form action="ScheduleManager?do=search" method="post">
						Client: <br />
						<input type="text" id="searchAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
					</form>
				</div>
				<div class="listInfo">
					<span style="float:left">Showing Results 1-<%= clients.size() %> of <%= clients.size() %></span>
					<span style="float:right"><a href="ClientInfo.jsp" rel="facebox">New Invoice</a></span><br />
				</div>
				<table class="list">
					<tr class="head">
						<th>Invoice #</th>
						<th style="padding:0 10px">Date</th>
						<th>Paid</th>
						<th colspan="3">Reporting</th>
					</tr>
					<tr onclick="jQuery.facebox({ ajax: 'InvoiceInfo.jsp' });">
						<td>7432890</td>
						<td>03/10/2010</td>
						<td>Paid</td>
						<td><a href="#"><img src="img/icons/email_go.png" alt="Email" title="Email" border="0" /></a></td>
						<td><a href="#"><img src="img/icons/printer.png" alt="Print" title="Print" border="0" /></a></td>
						<td><a href="#"><img src="img/icons/page_excel.png" alt="Excel" title="Excel" border="0" /></a></td>
					</tr>
				</table>
				<div class="cleaner"></div>
				<div id="footer">
					&nbsp;
				</div>
			</div>
		</div>
		
	</body>
</html>