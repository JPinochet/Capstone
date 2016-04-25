<%@page import="problemDomain.Client,java.util.ArrayList,logic.ClientManager,logic.OrganizationManager,exceptions.*,problemDomain.Organization" %>
<% 
ClientManager cm = new ClientManager();

Client client= new Client();

int id=0;
String givenName = "";
String surname = "";
String email = "";
String street = "";
String city = "";
String prov = "";
String postalCode = "";
String country = "";
int discount = 0;
String homePhone = "";
String cellPhone = "";
String workPhone = "";

if(request.getParameter("client") != null) {
	client = cm.getClientInfo(Integer.parseInt(request.getParameter("client")));
	cm.close();

	id = client.getId();
	givenName = client.getGivenName();
	surname = client.getSurname();
	email = client.getEmail();
	street = (client.getAddress()==null)?"":client.getAddress();
	city = (client.getCity()==null)?"":client.getCity();
	prov = (client.getProvince()==null)?"":client.getProvince();
	postalCode = (client.getPostalCode()==null)?"":client.getPostalCode();
	country = (client.getCountry()==null)?"":client.getCountry();
	discount = client.getDiscount();
	homePhone = (client.getHomePhone()==null)?"":client.getHomePhone();
	workPhone = (client.getWorkPhone()==null)?"":client.getWorkPhone();
	cellPhone = (client.getCellPhone()==null)?"":client.getCellPhone();
}
%>
<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:30%;
	}
	-->
</style>
<form action="ClientManager?do=manage" method="post" class="cssForm">
	<div style="width: 600px">
		<div style="width:49%;float:left;padding-right:1%">
			<div class="leftDiv"><label for="givenName">Given Name:</label></div><div class="rightDiv"><input type="text" name="givenName" size="15" value="<%= givenName %>" />*</div>
			<div class="leftDiv"><label for="surname">Surname:</label></div><div class="rightDiv"><input type="text" name="surname" size="20" value="<%= surname %>" />*</div>
			<div class="leftDiv"><label for="email">Email:</label></div><div class="rightDiv"><input type="text" name="email" size="23" value="<%= email %>" />*</div>
			<div class="leftDiv"><label for="street">Street:</label></div><div class="rightDiv"><input type="text" name="street" size="20" value="<%= street %>" /></div>
			<div class="leftDiv"><label for="city">City:</label></div><div class="rightDiv"><input type="text" name="city" size="10" value="<%= city %>" /></div>
			<div class="leftDiv"><label for="prov">Province:</label></div><div class="rightDiv"><input type="text" name="prov" size="1" maxlength="2" value="<%= prov %>" /></div>
			<div class="leftDiv"><label for="postalCode">Postal Code:</label></div><div class="rightDiv"><input type="text" name="postalCode" size="5" maxlength="7" value="<%= postalCode %>" /></div>
			<div class="leftDiv"><label for="country">Country:</label></div><div class="rightDiv"><input type="text" name="country" size="10" value="<%= country %>" /></div>
			<div class="leftDiv"><label for="discount">Discount:</label></div><div class="rightDiv"><input type="text" name="discount" size="1" maxlength="3" value="<%= discount %>" /> %</div>
		</div>
		
		<div style="float:right;width:50%">
			<fieldset> 
				<legend><strong>Phone Numbers</strong></legend>
				<div class="leftDiv"><label for="homePhone">Home Phone:</label></div><div class="rightDiv"><input type="text" name="homePhone" size="10" maxlength="10" value="<%= homePhone %>" /></div>
				<div class="leftDiv"><label for="workPhone">Work Phone:</label></div><div class="rightDiv"><input type="text" name="workPhone" size="10" maxlength="10" value="<%= workPhone %>" /></div>
				<div class="leftDiv"><label for="cellPhone">Cell Phone:</label></div><div class="rightDiv"><input type="text" name="cellPhone" size="10" maxlength="10" value="<%= cellPhone %>" /></div>
			</fieldset>
			<fieldset> 
				<legend><strong>Organizations</strong></legend>
				<select name="orgs" size="5" style="width:100%" multiple="multiple">
					<%
						OrganizationManager om = new OrganizationManager();
						ArrayList<Organization> orgs = new ArrayList<Organization>();
						try {
							orgs = (ArrayList<Organization>) om.getOrgList();
						} catch(DatabaseConnectionException e) {
							e.printStackTrace();
						}
					    for (int i=0; i<orgs.size(); i++) {
					    	String selected="";
					    	if(request.getParameter("client") != null) {
						    	for(int j=0; j<client.getOrganizations().size(); j++) {
						    		if( client.getOrganizations().get(j).getId() == orgs.get(i).getId() ){
						    			selected=" selected=\"selected\"";
						    		}
						    	}
					    	}
					%>
					<option value="<%= orgs.get(i).getId() %>"<%= selected %>><%= orgs.get(i).getName() %></option>
					<% 	
						} 
					    om.close();
					%>
				</select>			
			</fieldset>
		</div>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="<%= id %>" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>