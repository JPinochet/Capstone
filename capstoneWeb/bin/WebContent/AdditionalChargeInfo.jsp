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
			<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="" />*</div>
			<div class="leftDiv"><label for="cost">Cost: $</label></div><div class="rightDiv"><input type="text" name="cost" size="3" value="" />*</div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="0" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>