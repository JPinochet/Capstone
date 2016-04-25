<form action="ClientManager?do=manage" method="post" class="cssForm">
	<div style="width: 100%">			
		<div class="leftDiv">
			<label for="setup">Amount Due:</label>
		</div>
		<div class="rightDiv">
			$<input type="text" name="setup" size="3" value="200.00" />
		</div>	
		<div class="leftDiv">
			<label for="setup">Payment:</label>
		</div>
		<div class="rightDiv">
			$<input type="text" name="setup" size="3" value="200.00" />
		</div>
	</div>
	<div style="clear:both;text-align:right;padding-top:10px">
		<!-- <input type="reset" value="Reset" /> -->
		<input type="submit" name="delete" value="Pay" />
	</div>
</form>