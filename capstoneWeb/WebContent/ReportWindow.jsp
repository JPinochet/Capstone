<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="logic.EmployeeManager, logic.ClientManager" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Indus Recreational Facility | Report</title>
		<!-- Main page styling -->
			<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
	</head>
	<body>
		<div id="topbg"></div>
			<ul id="menu">
				<li><a href="index.jsp"><span></span>Home</a></li>
				<li><a href="BookingWindow.jsp"><span></span>Schedule</a></li>
				<li><a href="InvoiceWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagementWindow.jsp"><span></span>Management</a></li>
				<li><a class="sel" href="ReportWindow.jsp"><span></span>Report</a></li>
			</ul>
		<div id="content">
				<center>
					<h1>Reporting Area:</h1>
					<br /><br />
					<h2>All Outstanding Invoices</h2>
					<form action="ClientManager?report=unPaidBookings" method="post">
						<input title="submit" name="report" value="Report" />
					</form>
					<br /><br />
					<h2>All Invoices for a Client:</h2>
					<form action="ClientManager?report=clientInvoices" method="post">
						Search Clients: <br />
						<input type="text" id="searchAC" name="searchText" /> <input type="submit" name="report" value="Report" /> <input type="submit" name="reset" value="Clear Results" />
					</form>
				</center>
		</div>
	</body>
</html>