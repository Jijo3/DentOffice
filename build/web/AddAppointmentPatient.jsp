<%-- 
    Document   : AddAppointmentPatient
    Java 3 Project
    Dentist OFfice
    Author     : jose9
--%>
<%@page import="Office.Appointment"%>
<%@page import="Office.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Appointment</title>
    </head>
    <body>
        <%
            Patient p2;           
            p2 = (Patient)session.getAttribute("p1");
            
            Appointment a2;
            a2 = (Appointment)session.getAttribute("a2");
        %>
       
        <h2>Patient: <%= p2.getFirstName()%> <%= p2.getLastName()%> You have no Appointment. Add one below.</h2>
        
        <form id="patAppoint" name = "form4" action="AddAppointmentPatient.jsp">
            <label for="acctNo">Appointment Date</label>
            <input type="text" id="apptd" name="apptDate" placeholder="No Appointment Date Scheduled"/>
            <br><br/>
            <label for="custID">Your Patient ID</label>
            <input type="text" id="pid" name="patId" value="<%=p2.getID()%>" readonly placeholder="Patient Id"/>
             <br><br/>
            <label for="acctType">Dentist ID</label>
            <input type="text" id="patFn" name="dentId" value="D202" readonly placeholder="Dentist Id"/>
             <br><br/>
            <label for="acctBalance">Procedure Code</label>
            <input type="text" id="procCode" name="procCode" placeholder="Procedure Code"/>
            
            <input type="submit" value="Add Appointment" onclick="edit()"/>
        </form>
        <script type="text/javascript">
                 
            function edit() {
                document.form4.action = "AddAppointmentPatServ";
                form4.submit();
            }
            document.getElementById("submit").addEventListener("click", submit, false)
       </script>
    
        
        
        <h3><a href="PatientInfo.jsp">Patient Information</a></h3>
        
    </body>
</html>
