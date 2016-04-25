<%@page import="logic.EmployeeManager,problemDomain.Client,java.util.ArrayList,logic.ClientManager,logic.OrganizationManager,exceptions.*,problemDomain.Organization" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	
	OrganizationManager om = new OrganizationManager();
	ClientManager cm = new ClientManager();
	
	Organization organization= new Organization();
	
	int id = 0;
	String name = "";
	String discount = "0";
	String description = "";
	Client client_contact = new Client();
	String contact = "";
	
	if(request.getParameter("organization") != null) {
		organization = om.getOrgInfo(Integer.parseInt(request.getParameter("organization")));
		om.close();
		
		id = organization.getId();
		name = (organization.getName()==null)?"":organization.getName();
		discount = (int)organization.getDiscount()+"";
		description = (organization.getDescription()==null)?"":organization.getDescription();
		client_contact = organization.getContact();
		contact = organization.getContact().getGivenName() + " " +  organization.getContact().getSurname();
	}
	
	if(request.getParameter("error") != null) {
		//0-id, 1-name, 2-discount, 3-contact, 4-description
		ArrayList<String> errorText = (ArrayList<String>) session.getAttribute("errorText");
		
		id = Integer.parseInt(errorText.get(0));
		name = errorText.get(1);
		discount = errorText.get(2);
		contact = errorText.get(3);
		description = (errorText.get(4)==null)?"":errorText.get(4);
%>
<script type="text/javascript" >
	$(document).ready(function() {
		$('label[for=<%= session.getAttribute("errorField") %>]').parent().parent().addClass("error");
	});
</script>
<%
	}
%>
<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:75px;
	}
	-->
</style>
		
<script type="text/javascript">
	//Run on page load
    jQuery(document).ready(function($) {
		//setup for autocomplete
      	$("#contactAC").autocomplete("ClientManager");
    });
</script>
<form action="OrganizationManager?do=manage" method="post" class="cssForm">
	<div style="width: 260px">
	<% if(request.getParameter("error") != null) { %>
		<div id="errorDesc">
			<%= session.getAttribute("errorMessage") %>
		</div>
	<% } %>
		<fieldset> 
			<legend><strong>Organization Details</strong></legend>
			<div class="field"><div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="20" value="<%= name %>" />*</div></div>
			<div class="field"><div class="leftDiv"><label for="contact">Contact:</label></div><div class="rightDiv"><input type="text" name="contact" size="20" value="<%= contact %>" id="contactAC" />*</div></div>
			<div class="field"><div class="leftDiv"><label for="discount">Discount:</label></div><div class="rightDiv"><input type="text" name="discount" size="2" value="<%= discount %>" />%</div></div>
			<div class="field"><div class="leftDiv"><label for="desc">Description:</label></div><div class="rightDiv"><textarea name="desc" rows="3" cols="15"><%= description %></textarea></div></div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="<%= id %>" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="save" value="Save" />
			<input type="submit" name="delete" value="Delete" />
		</div>
	</div>
</form>