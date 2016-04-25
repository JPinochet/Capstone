<%@page import="logic.EmployeeManager" %>
<%
	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	String due = "";
	if(request.getParameter("invoice") != null) {
		InvoiceManager im = new InvoiceManager();
		NumberFormat nf = new DecimalFormat("#.00"); 
		due = nf.format(im.getInvoiceInfo(Integer.parseInt(request.getParameter("invoice"))).getPaymentDue()) + "";
		im.close();
	}
%>

<%@page import="logic.InvoiceManager"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%><link href="css/form.css" rel="stylesheet"  type="text/css" media="screen" />
<style>
	<!--
	.cssForm .leftDiv{
		width:47%;
	}
	-->
</style>
<form action="InvoiceManager?do=pay" method="post" class="cssForm">
	<div style="width: 200px">
		<div class="field">
			<div class="leftDiv">
				<label for="setup">Amount Due:</label>
			</div>
			<div class="rightDiv">
				$<input type="text" size="5" value="<%= due %>" disabled="disabled" />
			</div>
		</div>	
		<div class="field">
			<div class="leftDiv">
				<label for="setup">Payment:</label>
			</div>
			<div class="rightDiv">
				$<input type="text" name="amount" size="5" value="0.00" />
			</div>
		</div>
		<div class="field">
			<div class="leftDiv">
				<label for="setup">Payment Type:</label>
			</div>
			<div class="rightDiv">
				<select name="type">
					<option value="check">Check</option>
					<option value="credit">Credit</option>
					<option value="cash">Cash</option>
					<option value="debit">Debit</option>
				</select>
			</div>
		</div>
	</div>
	<div style="clear:both;text-align:right;padding-top:10px">
		<!-- <input type="reset" value="Reset" /> -->
		<input type="hidden" name="invoice" value="<%= request.getParameter("invoice") %>" />
		<input type="submit" name="pay" value="Pay" />
	</div>
</form>