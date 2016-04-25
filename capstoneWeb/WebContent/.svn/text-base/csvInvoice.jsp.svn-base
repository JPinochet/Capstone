<%InvoiceManager im = new InvoiceManager();
Invoice i = im.getInvoiceInfo(Integer.parseInt(request.getParameter("invoice")));
im.close();
out.println("Invoice_Number,Client,Subtotal");
out.println(i.getId() + "," + i.getClient().getGivenName() + " " + i.getClient().getSurname() + "," + i.getSubtotal());%>
<%@ page language="java" contentType="text/csv" %>
<%@page import="logic.InvoiceManager, problemDomain.Invoice"%>
<% response.setHeader("Content-Disposition", "attachment; filename=\"invoice-" + i.getId() + ".csv\""); %>
