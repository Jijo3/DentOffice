<%-- 
    Document   : PatientInfo
    Java 3 Project 
    Dentist Office
    Author     : Jose Chavez
--%>
<%@page import="Office.Patient" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Patient!</title>
    </head>
    <body>
        <% Patient p1;
            
        p1 = (Patient) session.getAttribute("p1");

           
        %>
        <h2> Hello <%= p1.getFirstName() + " " + p1.getLastName()%> </h2>

         <form id="patForm" name = "form2" action="PatientInfo.jsp">
            <label for="acctNo">Patient ID</label>
            <input type="text" id="ppid" name="patId" value="<%=p1.getID()%>" readonly placeholder="Patient ID"/>
             <br><br>
            <label for="custID">Password</label>
            <input type="text" id="ppw" name="patPw" value="<%=p1.getPassword()%>" readonly placeholder="Password"/>
             <br><br>
            <label for="acctType">First Name (edit)</label>
            <input type="text" id="pfn" name="patFn" value="<%=p1.getFirstName()%>" placeholder="First Name"/>
             <br><br>
            <label for="acctBalance">Last Name (edit)</label>
            <input type="text" id="pln" name="patLn" value="<%=p1.getLastName()%>" placeholder="Last Name"/>
             <br><br>
            <label for="acctBalance">Address (edit)</label>
            <input type="text" id="addr" name="patAddress" value="<%=p1.getAddress()%>" placeholder="Address"/>
             <br><br>
            <label for="acctBalance">Email (edit)</label>
            <input type="text" id="patEmail" name="patEmail" value="<%=p1.getEmail()%>" placeholder="Email"/>
             <br><br>
            <label for="acctBalance">Insurance (edit)</label>
            <input type="text" id="insCo" name="patInsurance" value="<%=p1.getInsuranceCo()%>" placeholder="Insurance"/>
             <br><br>
            
             <input type="submit" value="Appointment View" onclick="view()"/>
            <input type="submit" value ="Edit Info" onclick="edit()"/>
        </form>
        <script type="text/javascript">
            function view() {
                document.form2.action = "PatientAppointmentsServ";
                form2.submit();
                    
            }
                 
            function edit() {
                document.form2.action = "UpdatePatientInfoServ";
                form2.submit();
            }
            document.getElementById("submit").addEventListener("click", submit, false);    
        </script> 
        
        <h6> <a href="Index.jsp">    Log out</a></h6>
    
    </body>
</html>
