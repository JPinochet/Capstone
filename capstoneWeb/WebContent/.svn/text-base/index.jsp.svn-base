<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	boolean error = false;
	String errorMessage = "";
	if(request.getParameter("error") != null && (request.getParameter("error").equals("main") || request.getParameter("error").equals("mainMessage"))) {
		error=true;
		errorMessage = request.getParameter("message");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />	
		
		<!-- JQuery Main -->
		<script src="js/jquery-latest.js"></script>
	  	
	  	<!-- Lightbox -->
		<link href="css/facebox.css" rel="stylesheet" type="text/css" media="screen" />
		<script src="js/facebox.js" type="text/javascript"></script> 
		
		<% if(error==true) { %>
	  	<script type="text/javascript">
			jQuery(document).ready(function($) {
				jQuery.facebox({ ajax: 'error.jsp?message=<%= errorMessage %>'});
			});
		</script>
		<% } %>
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
				<% 	if(session.getAttribute("user") == null)
					{
				%>
					<div id="login">
						<strong>Login:</strong>
						<form action="LoginManager" method="post">
							Username: <input type="text" name="username" />
							Password: <input type="password" name="password" />
							<input type="submit" value="Login" />
						</form>
					</div>
				<%	}
					else
					{
				%>
					<div id="logout">
						<a href="LoginManager?logout=true">Logout</a>
					</div>
				<%
					}
				%>
			</div>

			<ul id="menu">
				<li><a class="sel" href="index.jsp"><span></span>Home</a></li>
				<li><a href="BookingWindow.jsp"><span></span>Schedule</a></li>
				<li><a href="InvoiceWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagementWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<center>
					<h1>Indus Recreational Facility Management System</h1>
					<img src="img/main.gif" />
				</center>
				
				<div class="cleaner"></div>
				<div id="footer">
					&nbsp;
				</div>
			</div>
		</div>		
	</body>
</html>