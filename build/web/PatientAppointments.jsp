<%-- 
    Document   : PatientAppointments
    Java 3 Project
    Dentist Office
    Author     : Jose Chavez
--%>
<%@page import="Office.Patient"%>
<%@page import="Office.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Appointments</title>
    </head>
    <body>
         <%
            Patient p2;           
            p2 = (Patient)session.getAttribute("p1");
            
            Appointment a2;
            a2= (Appointment)session.getAttribute("a2");
        %>
        
      
        <h2>Patient <%= p2.getFirstName()%> <%= p2.getLastName()%> Appointment Schedule Display</h2>
        <br/>
        <br/>
        <form id="patAppoint" name = "form3" action="PatientAppointments.jsp">
            <label for="acctNo">Appointment Date</label>
            <input type="text" id="apptd" name="apptDate" value="<%=a2.getDateTime()%>" placeholder="No Appointment Date Scheduled"/>
             <br/>
            <label for="custID">Your Patient ID</label>
            <input type="text" id="pid" name="patId" value="<%=p2.getID()%>" readonly placeholder="Patient Id"/>
             <br/>
            <label for="acctType">Dentist ID</label>
            <input type="text" id="patFn" name="dentId" value="<%=a2.getDentID()%>" readonly placeholder="Dentist Id"/>
             <br/>
            <label for="acctBalance">Procedure Code</label>   
            <input type="text" id="procCode" name="procCode" value="<%=a2.getProcCode()%>" readonly placeholder="Procedure Code"/>
             <br/>
            <input type="submit" value="Change Date" onclick="edit()"/>
            
        </form>
        <script type="text/javascript">
                
            function edit() {
                document.form3.action = "UpdatePatientAppointServ";
                form3.submit();
            }
            document.getElementById("submit").addEventListener("click", submit, false);    
        </script>
       
        <h2><a href="PatientInfo.jsp">Patient Information</a></h2>
        
    </body>
</html>
