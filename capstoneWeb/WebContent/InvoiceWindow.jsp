<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="problemDomain.*,java.util.ArrayList,logic.ClientManager,logic.EmployeeManager,exceptions.DatabaseConnectionException" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();

	ArrayList<Client> clients = new ArrayList<Client>();
	boolean search = false;
	if(request.getParameter("client") != null) {
		ClientManager cm = new ClientManager();
		clients.add(cm.getClientInfo(Integer.parseInt(request.getParameter("client"))));
	}else if(session.getAttribute("searchResults") != null) {
		clients = (ArrayList<Client>) session.getAttribute("searchResults");
		session.setAttribute("searchResults", null);
		search = true;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="logic.InvoiceManager"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%><html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility | Accounting</title>
		
		<!-- Main page styling -->
		<link href="css/style.css" rel="stylesheet"  type="text/css" media="screen" />
		
		<!-- Main page styling -->
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
		      	$("#searchAC").autocomplete("ClientManager");
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
				<li><a class="sel" href="InvoiceWindow.jsp"><span></span>Accounting</a></li>
				<li><a href="ClientWindow.jsp"><span></span>Clients</a></li>
				<li><a href="FacilityWindow.jsp"><span></span>Facilities</a></li>
				<li><a href="EmployeeWindow.jsp"><span></span>Employees</a></li>
				<li><a href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagementWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<div class="search">
					<form action="InvoiceManager?do=search" method="post">
						Client: <br />
						<input type="text" id="searchAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
					</form>
				</div>
				<% 
				InvoiceManager im = new InvoiceManager();
				if (search || request.getParameter("client") != null) { 
					if(clients.size() == 1) {
						Client c = clients.get(0);
						ArrayList<Invoice> invoices = (ArrayList<Invoice>) im.getInvoicesForClient(c.getId());
				%>
				<div class="listInfo">
					<span style="float:left">Showing Invoices <%= (invoices.isEmpty())?"0":"1" %>-<%= invoices.size() %> for client: <%= c.getGivenName() + " " + c.getSurname() %></span>
					<span style="float:right"><%= !invoices.isEmpty()?"<a href=\"reportClientInvoices.jsp?client=" + c.getId() + "\" target=\"_blank\">Report all Client Invoices</a> | ":"" %><a href="InvoiceInfo.jsp?client=<%= c.getId() %>" rel="facebox">New Invoice</a></span><br />
				</div>
				<table class="list">
					<tr class="head">
						<th>Invoice #</th>
						<th style="padding:0 10px">Date</th>
						<th>Paid</th>
						<th colspan="3">Reporting</th>
					</tr>
					<%= (invoices.isEmpty())?"<tr><td colspan=\"6\">No Invoices Found</td></tr>":"" %>
					<% 
						for(Invoice i : invoices) { 
							String onclick = i.getPaid()?"jQuery.facebox({ ajax: 'InvoiceInfo.jsp?invoice=" + i.getId() + "' });":"jQuery.facebox({ ajax: 'PayInvoice.jsp?invoice=" + i.getId() + "' });";
					%>
					<tr>
						<td onclick="jQuery.facebox({ ajax: 'InvoiceInfo.jsp?invoice=<%= i.getId() %>' });"><%= i.getId() %></td>
						<td onclick="jQuery.facebox({ ajax: 'InvoiceInfo.jsp?invoice=<%= i.getId() %>' });"><%= new SimpleDateFormat("MM/dd/yyyy").format(i.getDate()) %></td>
						<td onclick="<%= onclick %>"><%= i.getPaid()?"Paid":"<u>Due On:" + new SimpleDateFormat("MM/dd/yyyy").format(i.getDueDate()) + "</u>" %></td>
						<td><a href="#" onclick="$.ajax({url: 'InvoiceManager?email=<%= i.getId() %>', success: function(data) { alert('Invoice emailed to <%= c.getGivenName() + " " + c.getSurname() %>'); } });"><img src="img/icons/email_go.png" alt="Email" title="Email" border="0" /></a></td>
						<td><a href="invoice.jsp?invoice=<%= i.getId() %>" target="_blank"><img src="img/icons/printer.png" alt="Print" title="Print" border="0" /></a></td>
						<td><a href="csvInvoice.jsp?invoice=<%= i.getId() %>"><img src="img/icons/page_excel.png" alt="Excel" title="Excel" border="0" /></a></td>
					</tr>
					<% 
						} 
					%>
				</table>
				<% 
					} else if(clients.size() > 1) {
				%>
				<div align="center"><br />Multiple clients found. Please choose one:</div>
				<table class="list">
					<tr>
						<th>Client Name</th>
					</tr>
					<%
					for(Client c : clients) { 
					%>
					<tr onclick="location='InvoiceWindow.jsp?client=<%=c.getId() %>'"><td><%= c.getGivenName() + " " + c.getSurname() %></td></tr>
					<%
					} 
					%>
				</table>
				<%
					} else {
				%>
				<div class="listInfo">
					<span style="float:right"><a href="reportUnpaidInvoices.jsp" target="_blank">Report all Unpaid Invoices</a></span><br />
				</div>
				<div align="center">No clients found.</div>
				<%
					}
				} else { 
				%>
				<div class="listInfo">
					<span style="float:right"><a href="reportUnpaidInvoices.jsp" target="_blank">Report all Unpaid Invoices</a></span><br />
				</div>
				<div align="center">Search for a client to display invoices for.</div>
				<% 
				} 
				%>
				<div class="cleaner"></div>
				<div id="footer">
					&nbsp;
				</div>
			</div>
		</div>
		
	</body>
</html>