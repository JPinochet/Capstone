<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:40%;
	}
	-->
</style>
<form action="ClientManager?do=manage" method="post" class="cssForm">
	<div style="width: 750px">
		<div style="width:32%;float:left;padding-right:1%">
			<fieldset>
				<legend><strong>Event Details</strong></legend>
				<div class="leftDiv">
					<label for="eventName">Event Name:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="eventName" size="15" value="" />*
				</div>
				
				<div class="leftDiv">
					<label for="eventName">Client:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="client" size="15" value="" />*
				</div>
				
				<div class="leftDiv">
					<label for="bookingType">Booking Type:</label>
				</div>
				<div class="rightDiv">
					<select>
						<option value="">Hockey Game</option>
					</select>
				</div>
				
				<div class="leftDiv">
					<label for="rate">Rate:</label>
				</div>
				<div class="rightDiv">
					<select>
						<option value="">Primetime Ice 1</option>
					</select>
				</div>
				
				<div class="leftDiv">
					<label for="people">Guest Count:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="people" size="3" value="" disabled="disabled" />
				</div>
					
				<div class="leftDiv"></div>
				<div class="rightDiv">
					<input type="button" value="Catering" />
				</div>
			</fieldset>
		</div>
		
		<div style="float:left;width:32%;padding-right:1%">
			<fieldset>
				<legend><strong>Time</strong></legend>
				<div class="leftDiv">
					<label for="start">Start Time:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="start" size="3" value="10:00" />
				</div>
					
				<div class="leftDiv">
					<label for="length">Length:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="length" size="3" value="01:00" />
				</div>
					
				<div class="leftDiv">
					<label for="setup">Setup Time:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="setup" size="3" value="00:00" />
				</div>
					
				<div class="leftDiv">
					<label for="teardown">Teardown Time:</label>
				</div>
				<div class="rightDiv">
					<input type="text" name="teardown" size="3" value="00:15" />
				</div>
			</fieldset>
		</div>
		
		<div style="float:right;width:33%">
			<fieldset>
				<legend><strong>Additional Charges</strong></legend>
				<select name="additionalCharges" size="8" style="width:100%" multiple="multiple">
					<option value="">Bar Service</option>
					<option value="">Steam Table</option>
					<option value="">Pop Fountain</option>
					<option value="">Servery</option>
					<option value="">Ice Machine</option>
					<option value="">Dish Rental</option>
					<option value="">Bar BQ</option>
					<option value="">Coffee Pot</option>
				</select>
			</fieldset>
		</div>
		
		<div style="clear:both;text-align:right;padding-top:10px">
			<!-- <input type="reset" value="Reset" /> -->
			<input type="submit" name="delete" value="Delete" />
			<input type="submit" name="save" value="Save" />
		</div>
	</div>
</form>