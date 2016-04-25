<%@page import="problemDomain.Employee,java.util.ArrayList,logic.EmployeeManager,exceptions.*" %>
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
Employee employee = new Employee();

int id=0;
String username = "";
String givenName = "";
String surname = "";
String password = "";
String employeeLevel = "0";

if(request.getParameter("employee") != null) {
	employee = em.getEmployeeInfo(Integer.parseInt(request.getParameter("employee")));
	em.close();

	id = employee.getId();
	givenName = (employee.getGivenName()==null)?"":employee.getGivenName();
	surname = (employee.getSurname()==null)?"":employee.getSurname();
	username = (employee.getUsername()==null)?"":employee.getUsername();
	password = (employee.getPassword()==null)?"":employee.getPassword();
	employeeLevel = employee.getEmployeeLevel()+"";
}

if(request.getParameter("error") != null) {
	//0-id, 1-username, 2-password, 3-givenName, 4-surname
	ArrayList<String> errorText = (ArrayList<String>) session.getAttribute("errorText");
	
	id = Integer.parseInt(errorText.get(0));
	givenName = errorText.get(3);
	surname = errorText.get(4);
	username = errorText.get(1);
	password = errorText.get(2);
%>
<script type="text/javascript" >
		$(document).ready(function() {
			$('label[for=<%= session.getAttribute("errorField") %>]').parent().parent().addClass("error");
		});
</script>
<%} %>
<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:75px;
	}
	-->
</style>
<form action="EmployeeManager?do=manage" method="post" class="cssForm">
	<div style="width: 235px">
	<% if(request.getParameter("error") != null) { %>
		<div id="errorDesc">
			<%= session.getAttribute("errorMessage") %>
		</div>
	<% } %>
		<fieldset> 
			<legend><strong>Employee Details</strong></legend>
			<div class="field"><div class="leftDiv"><label for="givenName">Given Name:</label></div><div class="rightDiv"><input type="text" name="givenName" size="15" value="<%= givenName %>" /> *</div></div>
			<div class="field"><div class="leftDiv"><label for="surname">Surname:</label></div><div class="rightDiv"><input type="text" name="surname" size="15" value="<%= surname %>" /> *</div></div>
			<div class="field"><div class="leftDiv"><label for="username">Username:</label></div><div class="rightDiv"><input type="text" name="username" size="15" value="<%= username %>" /> *</div></div>
			<div class="field"><div class="leftDiv"><label for="password">Password:</label></div><div class="rightDiv"><input type="password" name="password" size="15" value="<%= password %>" /> *</div></div>
			<div class="field"><div class="leftDiv"><label for="employeeLevel">Role:</label></div><div class="rightDiv"><input type="text" name="employeeLevel" size="1" value="<%= employeeLevel %>" /> *</div></div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="<%= id %>" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="save" value="Save" />
			<input type="submit" name="delete" value="Delete" />
		</div>
	</div>
</form>