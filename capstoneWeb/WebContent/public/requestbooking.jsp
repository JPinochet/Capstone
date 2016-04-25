<%-- 
    Document   : requestbooking
    Created on : Mar 14, 2010, 1:23:00 PM
    Author     : 504303
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Request Booking</title>
		<%--Datepicker --%>
		<link type="text/css" href="../css/jquery.ui.all.css" rel="stylesheet" />
  		<script type="text/javascript" src="../js/jquery-1.4.1.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>

		<script type="text/javascript">
			//Run on page load
		    jQuery(document).ready(function($) {
			    
		      	//setup for datepicker
		      	$("#datepicker").datepicker();
		    });


		    function sendEmail()
		    {
			    var message="";
			    message = message + document.emailForm.givename.value + "\n";
			    message = message + "Email=" + document.emailForm.email.value + "\n";
			    message = message + "Event date=" + document.emailForm.eventDate.value + "\n";
			    message = message + "Start time=" + document.emailForm.starttime.value + "\n";
			    message = message + "End time=" + document.emailForm.endtime.value + "\n";
			    document.sendForm.From.value = message;
			    document.sendForm.submit();
		    }
	  	</script>		
</head>

<%
	String fullname="";

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/indusdb", "root","password");
	Statement s = conn.createStatement();
	String sql="select givenName,surname from client where email='" + (String)session.getAttribute("email") + "';";
	
	s.executeQuery(sql);
	
	ResultSet rs = s.getResultSet();
	
	while (rs.next())
	{
		fullname=rs.getString(1) + " " + rs.getString(2);
	}
	
	rs.close();
	conn.close();
	
%>

<body bgcolor="#FFFFFF">
<table style=width:100% border="3" bordercolor="#6699CC">
        <tr><td><font color="#5191CD"> <h1>Booking Request Form</h1></font></td><td align="center"><a href="viewScheduleLoggedIn.jsp">Back</a></td><td align="center"><a href="login.jsp?logout=true">Logout</a></td></tr></table>
 <table style=width:100% border="3" bordercolor="#6699CC" ><tr><td>
 <form name="emailForm" method="post" action="mailto:kmoloughlin@gmail.com?subject=Request Booking" enctype="application/x-www-form-urlencoded">
	<font color="#5191CD"></font>	
	<table align="center" style="width:30%; border="2" bordercolor="#6699CC">
	<tr><td>Name:</td>
	 <td>
	   <input type="text" name="givename" value="<%= fullname %>"/>
	 </td>
	</tr>
	<tr><td>Email:</td>
	 <td><input type="text" name="email" value="<%= (String)session.getAttribute("email") %>"/>
	 </td>
	</tr>
    <tr><td>Event Date:</td>
     <td><input name="eventDate" type="text" id="datepicker" />
     </td>
     </tr>
    <tr><td>Start Time:</td>
      <td><input type="text" name="starttime" />
      </td>
     </tr>
    <tr><td>End Time:</td>
     <td><input type="text" name="endtime" />
     </td>
    </tr>
    <tr><td align="center" colspan="3"><input type="button" value="Submit" onClick="sendEmail();"></input><input type="reset" value="Clear"></input></td></tr>
	</table>
 </form></td></tr></table>
 
 <form name="sendForm" action="mailto:kmoloughlin@gmail.com?subject=Request Booking" method="post" enctype="text/plain">
    <input type="hidden" name="From" value=""></input>
 </form>
 </body>
</html>