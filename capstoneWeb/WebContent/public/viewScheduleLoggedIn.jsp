<%@page import="logic.BookingManager"%>
<%@page import="problemDomain.Facility"%>
<%@page import="logic.FacilityManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="problemDomain.Booking,java.util.ArrayList,logic.BookingManager,logic.EmployeeManager,exceptions.*,java.util.Date" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html><!-- InstanceBegin template="/Templates/indus.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="doctitle" -->
<title>Indus Recreation Centre - Indus, Alberta, Canada</title>
<!-- InstanceEndEditable --><meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="http://www.indusrec.ca/master.css" rel="stylesheet" type="text/css"><!-- Schedule specific styling -->
<link href="../css/schedule.css" rel="stylesheet"  type="text/css" media="screen" />
<style type="text/css">
<!--
.
#schedule .open, .unpaidBooking, .paidBooking {
    cursor: default !important;
}
-->
</style>
<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
        <!-- JQuery Main -->
        <script type="text/javascript" src="../js/jquery-latest.js"></script>
        <!-- JQuery Datepicker -->
        <link type="text/css" href="../css/jquery.ui.all.css" rel="stylesheet" />
        <script type="text/javascript" src="../js/jquery-1.4.1.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.js"></script>
        
        <script type="text/javascript">
            //Run on page load
            jQuery(document).ready(function($) {
                //setup for datepicker
                $("#datepicker").datepicker();

                //Tooltips for schedule
                $("#schedule *").removeAttr('title')
                .removeAttr('onclick'); 
            });
        </script>
</head>

<body>
  <table align="left" style=width:100% border="3" bordercolor="#6699CC">
  <tr><td><font color="#5191CD"><h1>Current Schedule</h1></font></td><td align="center"><a href="requestbooking.jsp">Booking Request</a></td><td align="center"><a href="clientinvoice.jsp">Back</a></td><td align="center"><a href="login.jsp?logout=true">Logout</a></td></tr></table><br><br><br><br></br><br></br><br></br>
       
        <div class="search" style="width:400px">
            <table align="center" style="width: 100%">
                <tr>
                    <td align="left">Facility: 
                        <select name="facility">
                            <%
                                FacilityManager fm = new FacilityManager();
                                ArrayList<Facility> facilites = (ArrayList<Facility>) fm.getFacilityList();
                                
                                for (Facility f : facilites) {
                            %>
                            <option value="<%= f.getId() %>"><%= f.getName() %></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <% SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); %>
                    <td align="center">Date: <input type="text" id="datepicker" name="date" value="<%= formatter.format(new Date()) %>" /></td>
                    <td align="right">View: 
                        <select name="view">
                            <option value="1">Single Day</option>
                            <option value="2">Single Week</option>
                            <option value="3">Single Month</option>
                        </select>
                    </td>
                </tr>
            </table>
    </div>
    <br /><br />
    <div id="schedule"></div>
  
<script>
    $("select").change(function () {
        var update = "../BookingManager?f=";
            $("select[name='facility'] option:selected").each(function () {
                update += $(this).val() + "&date=" + $("input[name='date']").val() + "&view=";
           });
            $("select[name='view'] option:selected").each(function () {
                update += $(this).val();
           });

           $('#schedule').html('<left><strong>Loading Schedule</strong><br /><img src="../img/facebox/loading.gif" alt="loading" /></center>');
           
           $('#schedule').load(update, function() {
                $("td").removeAttr('title')
                .removeAttr('onclick'); 
            });
       }).change();

       $("input[name='date']").change(function () {
        var update = "../BookingManager?f=";
            $("select[name='facility'] option:selected").each(function () {
                update += $(this).val() + "&date=" + $("input[name='date']").val() + "&view=";
           });
            $("select[name='view'] option:selected").each(function () {
                update += $(this).val();
           });

           $('#schedule').html('<left><strong>Loading Schedule</strong><br /><img src="../img/facebox/loading.gif" alt="loading" /></center>');
           
           $('#schedule').load(update, function() {
                $("td").removeAttr('title')
                .removeAttr('onclick'); 
            });
       });
</script> 
</body>
</html>
