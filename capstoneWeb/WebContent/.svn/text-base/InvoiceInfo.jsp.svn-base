<%@page import="logic.EmployeeManager,java.util.ArrayList, problemDomain.*" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	
	
	int client_id = 0;
	int invoice_no = 0;
	Invoice invoice = null;
	if(request.getParameter("client") != null) {
		client_id = Integer.parseInt(request.getParameter("client"));
	}else if(request.getParameter("invoice") != null) {
		InvoiceManager im = new InvoiceManager();
		invoice_no = Integer.parseInt(request.getParameter("invoice"));
		invoice = im.getInvoiceInfo(invoice_no);
		client_id = invoice.getClient().getId();
		im.close();
	}
%>

<%@page import="logic.BookingManager"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="logic.InvoiceManager"%>
<link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/jquery.comboselect.css" />
<script type="text/javascript" src="js/jquery.selso.js"></script>
<script type="text/javascript" src="js/jquery.comboselect.js"></script>

<style>
	<!--
	.cssForm .leftDiv{
		width:47%;
	}
	-->
</style>
<form action="InvoiceManager?do=manage" method="post" class="cssForm">
	<div style="width: 400px">
		<div style="width:100%;float:left">
			<fieldset>
				<legend>Bookings</legend>
				<div style="padding:0px 10px">
					Search Bookings: <br />
					<input type="text" /><input type="button" value="Search" />
				</div>
				<select name="bookings" id="bookings" size="10" style="width:100%" multiple="multiple">
					<%
					BookingManager bm = new BookingManager();
					ArrayList<Booking> bookings = (ArrayList<Booking>) bm.getAllBookingsForClient(client_id);
					for(Booking b : bookings) {
						String selected = "";
						if(request.getParameter("invoice") != null && b.getInvoice_no() == invoice_no)
							selected = "selected=\"selected\"";
					%>
					<option value="<%= b.getId() %>"<%= selected %>><%= b.getEventTitle() %>- <%= new SimpleDateFormat("MM/dd/yyyy h:mm a").format(b.getStartTime()) %></option>
					<%
					}
					
					bm.close();
					%>
				</select>
			</fieldset>
		</div>
		<div style="clear:both;padding-top:10px">
			<span style="text-align: left">Additional Information:</span>
			<textarea rows="3" cols="47" name="desc"><%= invoice!=null?invoice.getDescription():"" %></textarea>
		</div>
		<div style="clear:both;text-align:right;padding-top:10px">
			<!-- <input type="reset" value="Reset" /> -->
			<input type="hidden" name="client" value="<%= client_id %>" />
			<input type="hidden" name="invoice" value="<%= invoice_no %>" />
			<input type="submit" name="save" value="Save" />
			<input type="submit" name="delete" value="Delete" />
		</div>
	</div>
</form>