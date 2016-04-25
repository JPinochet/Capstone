<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:115px;
	}
	-->
</style>
<form action="RateManager?do=manage" method="post" class="cssForm">
	<div style="width: 300px">
		<fieldset> 
			<legend><strong>Rate Details</strong></legend>
			<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="" />*</div>
			<div class="leftDiv"><label for="rate">Rate: $</label></div><div class="rightDiv"><input type="text" name="rate" size="3" value="" /> /hr *</div>
			<div class="leftDiv"><label for="bookDep">Booking Deposit: $</label></div><div class="rightDiv"><input type="text" name="bookDep" size="3" value="0" /></div>
			<div class="leftDiv"><label for="damDep">Damage Deposit: $</label></div><div class="rightDiv"><input type="text" name="damDep" size="3" value="0" /></div>
			<div class="leftDiv"><label for="desc">Description:</label></div><div class="rightDiv"><textarea name="desc" rows="3" cols="15"></textarea></div>
		</fieldset>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<input type="hidden" name="id" value="0" />
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>