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
		<fieldset> 
			<legend><strong>Employee Details</strong></legend>
			<div class="leftDiv"><label for="givenName">Given Name:</label></div><div class="rightDiv"><input type="text" name="givenName" size="15" value="" />*</div>
			<div class="leftDiv"><label for="surname">Surname:</label></div><div class="rightDiv"><input type="text" name="surname" size="15" value="" />*</div>
			<div class="leftDiv"><label for="username">Username:</label></div><div class="rightDiv"><input type="text" name="username" size="15" value="" />*</div>
			<div class="leftDiv"><label for="password">Password:</label></div><div class="rightDiv"><input type="password" name="password" size="15" value="" />*</div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="0" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>