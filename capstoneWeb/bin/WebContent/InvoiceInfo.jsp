<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:47%;
	}
	-->
</style>
<form action="ClientManager?do=manage" method="post" class="cssForm">
	<div style="width: 825px">
		<div style="width:35%;float:left">
			<fieldset>
				<legend>Bookings</legend>
				<div style="padding:0px 10px">
					Search Bookings: <br />
					<input type="text" /><input type="button" value="search" />
				</div>
				<select name="additionalCharges" size="10" style="width:100%" multiple="multiple">
					
				</select>
			</fieldset>
		</div>
		<div style="width:10%;float:left;padding: 70px 7%;">
			<span style="padding-left:20px"><input type="button" value="Add to Invoice" /></span>
			<input type="button" value="Remove from Invoice" />
		</div>
		<div style="float:right;width:35%">
			<fieldset>
				<legend>Invoice</legend>
				<select name="additionalCharges" size="13" style="width:100%" multiple="multiple">
				<option>Hockey - 03/10/2010</option>
				</select>
			</fieldset>
		</div>
		<div style="clear:both;padding-top:10px">
		<span style="text-align: left">Additional Information:</span>
		<textarea rows="3" cols="100"></textarea>
		</div>
		<div style="clear:both;text-align:right;padding-top:10px">
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>