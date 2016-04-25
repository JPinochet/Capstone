<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="problemDomain.Organization,java.util.ArrayList,logic.OrganizationManager,logic.EmployeeManager,exceptions.DatabaseConnectionException" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();

	boolean error = false;
	String errorMessage = "";
	OrganizationManager om = new OrganizationManager();
	ArrayList<Organization> orgs = new ArrayList<Organization>();
	try {
		if(session.getAttribute("searchResults") == null)
			orgs = (ArrayList<Organization>) om.getOrgList();
		else
		{
			orgs = (ArrayList<Organization>) session.getAttribute("searchResults");
			session.setAttribute("searchResults", null);
		}
	} catch(DatabaseConnectionException e) {
		error = true;
		errorMessage = e.getMessage();
	}
	
	if(request.getParameter("error") != null && request.getParameter("error").equals("main")) {
		error=true;
		errorMessage = request.getParameter("message");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>Indus Recreational Facility | Organization Management</title>
		
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
		      	$("#searchAC").autocomplete("OrganizationManager");
		    });
	  	</script>
	  	
	  	<% if(error==true) { %>
	  	<script type="text/javascript">
			jQuery(document).ready(function($) {
				jQuery.facebox({ ajax: 'error.jsp?message=<%= errorMessage %>'});
			});
		</script>
		<% } %>
		
		<% if(request.getParameter("error") != null && request.getParameter("error").equals("info")) { %>
	  	<script type="text/javascript">
			jQuery(document).ready(function($) {
				jQuery.facebox({ ajax: 'OrganizationInfo.jsp?error=true'});
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
				<li><a class="sel" href="OrganizationWindow.jsp"><span></span>Organizations</a></li>
				<li><a href="ManagementWindow.jsp"><span></span>Management</a></li>
			</ul>

			<div id="content">
				<div class="search">
					<form action="OrganizationManager?do=search" method="post">
						Search Organizations: <br />
						<input type="text" id="searchAC" name="searchText" /> <input type="submit" name="search" value="Search" /> <input type="submit" name="reset" value="Clear Results" />
					</form>
				</div>
				<div class="listInfo">
					<span style="float:left">Showing Results 1-<%= orgs.size() %> of <%= orgs.size() %></span>
					<span style="float:right"><a href="OrganizationInfo.jsp" rel="facebox">New Organization</a></span><br />
				</div>
				<table class="list">
					<tr class="head">
						<th>Name</th>
						<th>Description</th>
					</tr>
					<%
						if (orgs.size()==0)
						    out.println("<tr><td colspan=\"2\">No organizations found</td></tr>");
						else
						{
						    for (int i = 0; i < orgs.size(); i++)
						    {
				    %>
					<tr onclick="jQuery.facebox({ ajax: 'OrganizationInfo.jsp?organization=<%= orgs.get(i).getId() %>' });">
						<td><%= orgs.get(i).getName() %></td>
						<td><%= orgs.get(i).getDescription() %></td>
					</tr>
					
					<%
						    }
						}
						om.close();
				    %>
				</table>
				<div class="cleaner"></div>
				<div id="footer">
					&nbsp;
				</div>
			</div>
		</div>		
	</body>
</html>