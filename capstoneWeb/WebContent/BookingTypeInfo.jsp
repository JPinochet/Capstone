<%@page import="problemDomain.BookingType, java.util.ArrayList, logic.BookingTypeManager, exceptions.*,logic.EmployeeManager" %>
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

	BookingType btype = new BookingType();
	
	int id = 0;
	String name = "";
	int setupTime  = 0;
	int tearDownTime  = 0;
	
	
	if(request.getParameter("btype") != null)
	{
		btype = btm.getBookingTypeInfo(Integer.parseInt(request.getParameter("btype")));
		btm.close();
		
		id = btype.getId();
		name = (btype.getName()==null)?"":btype.getName();
		setupTime = btype.getSetupTime();
		tearDownTime = btype.getTearDownTime();
	}
%>
	<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
	<style>
		<!--
		.cssForm .leftDiv{
			width:100px;
		}
		-->
	</style>
	<form action="BookingTypeManager?do=manage" method="post" class="cssForm">
		<div style="width: 270px">
			<fieldset> 
				<legend><strong>Booking Type Details</strong></legend>
				<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="<%= name %>" /> *</div>
				<div class="leftDiv"><label for="setup">Setup Time:</label></div><div class="rightDiv"><input type="text" name="setupTime" size="3" value="<%= setupTime  %>" /> min</div>
				<div class="leftDiv"><label for="teardown">Tear down Time:</label></div><div class="rightDiv"><input type="text" name="tearDownTime" size="3" value="<%= tearDownTime %>" /> min</div>
			</fieldset>
			
			<div style="clear:both;text-align:right;padding-top:10px">
				<input type="hidden" name="id" value="<%= id %>" />
				<!-- <input type="reset" value="Reset" /> -->
				<input type="submit" name="save" value="Save" />
				<input type="submit" name="delete" value="Delete" />
			</div>
		</div>
	</form> 
