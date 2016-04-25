<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:47%;
	}
	-->
</style>
<form action="FacilityManager?do=manage" method="post" class="cssForm">
	<div style="width: 600px">
		<div style="width:49%;float:left;padding-right:1%">
			<fieldset> 
				<legend><strong>Facility Details</strong></legend>
				<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="" />*</div>
				<div class="leftDiv"><label for="open">Opening Time:</label></div><div class="rightDiv"><input type="text" name="open" size="4" value="HH:MM" />*</div>
				<div class="leftDiv"><label for="close">Closing Time:</label></div><div class="rightDiv"><input type="text" name="close" size="4" value="HH:MM" />*</div>
				<div class="leftDiv"><label for="setup">Min. Setup Time:</label></div><div class="rightDiv"><input type="text" name="setup" size="4" value="HH:MM" /></div>
				<div class="leftDiv"><label for="teardown">Min. Tear-down Time:</label></div><div class="rightDiv"><input type="text" name="teardown" size="4" value="HH:MM" /></div>
				<div class="leftDiv"><label for="capacity">Max Capacity:</label></div><div class="rightDiv"><input type="text" name="capacity" size="3" maxlength="4" value="" /></div>
				<div class="leftDiv"><label for="length">Min. Booking Length:</label></div><div class="rightDiv"><input type="text" name="length" size="4" value="HH:MM" /></div>
			</fieldset>
		</div>
		
		<div style="float:right;width:50%">
			<fieldset> 
				<legend><strong>Rates</strong></legend>
				<select name="rates" size="5" style="width:100%" multiple="multiple">
					<option value="0">Weekend Rate</option>
				</select></fieldset>
			<fieldset> 
				<legend><strong>Additional Charges</strong></legend>
				<select name="addCharges" size="5" style="width:100%" multiple="multiple">
					<option value="0">Water Cooler</option>
				</select>
			</fieldset>
		</div>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="0" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>