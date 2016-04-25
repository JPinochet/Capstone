<%@page import="problemDomain.AdditionalCharge, java.util.ArrayList, logic.AdditionalChargeManager, exceptions.*, logic.EmployeeManager" %>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
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
	AdditionalChargeManager acm = new AdditionalChargeManager();

	AdditionalCharge addition = new AdditionalCharge();
	
	int id = 0;
	String name = "";
	double cost = 0;
	
	if(request.getParameter("addition") != null)
	{
		addition = acm.getAdditionalChargeInfo(Integer.parseInt(request.getParameter("addition")));
		acm.close();
		
		id = addition.getId();
		name = (addition.getName()==null)?"":addition.getName();
		cost = addition.getCost();
	}
    NumberFormat nf = new DecimalFormat("#.00");
%>

<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:75px;
	}
	-->
</style>
<form action="AdditionalChargeManager?do=manage" method="post" class="cssForm">
	<div style="width: 260px">
		<fieldset> 
			<legend><strong>Additional Charge Details</strong></legend>
			<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="<%= name %>" />* </div>
			<div class="leftDiv"><label for="cost">Cost: $</label></div><div class="rightDiv"><input type="text" name="cost" size="3" value="<%= nf.format(cost) %>" /> *</div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="<%= id %>" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="save" value="Save" />
			<input type="submit" name="delete" value="Delete" />
		</div>
	</div>
</form>