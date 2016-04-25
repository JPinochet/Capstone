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
		<fieldset> 
			<legend><strong>Organization Details</strong></legend>
			<div class="leftDiv"><label for="name">Name:</label></div><div class="rightDiv"><input type="text" name="name" size="15" value="" />*</div>
			<div class="leftDiv"><label for="contact">Contact:</label></div><div class="rightDiv"><input type="text" name="contact" size="15" value="" id="contactAC" />*</div>
			<div class="leftDiv"><label for="discount">Discount:</label></div><div class="rightDiv"><input type="text" name="discount" size="2" value="0" />%</div>
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