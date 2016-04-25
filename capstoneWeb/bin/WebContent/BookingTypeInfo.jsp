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
			<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="" />*</div>
			<div class="leftDiv"><label for="setup">Setup Time:</label></div><div class="rightDiv"><input type="text" name="setup" size="3" value="hh:mm" /></div>
			<div class="leftDiv"><label for="teardown">Teardown Time:</label></div><div class="rightDiv"><input type="text" name="cost" size="3" value="hh:mm" /></div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="0" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>