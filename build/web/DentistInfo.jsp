<%-- 
    Document   : DentistInfo
    Java 3 Project
    Dentist Office
    Author     : Jose Chavez
--%>

<%@page import="Office.Dentist" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Info</title>
    </head>
    <body>
        
        <% Dentist d1;
            
            d1 = (Dentist) session.getAttribute("d1");

            d1.display();

        %>
        
        <h2> Hello <%= d1.getFirstName() + " " + d1.getLastName()%> </h2>
        
        <form id="searchForm" name = "form1" action="DentistInfo.jsp">
            <label for="acctNo">Dentist ID</label>
            <input type="text" id="dentId" name="dentId" value="<%=d1.getID()%>" readonly/>
             <br><br>
            <label for="custID">Dentist Password</label>
            <input type="text" id="dpw" name="dentPw" value="<%=d1.getPassword()%>" readonly/>
             <br><br>
            <label for="acctType">First Name (can edit)</label>
            <input type="text" id="dfn" name="dentFn" value="<%=d1.getFirstName()%>" placeholder="Enter First Name"/>
             <br><br>
            <label for="acctBalance">Last Name (can edit)</label>
            <input type="text" id="dln" name="dentLn" value="<%=d1.getLastName()%>" placeholder="Enter Last Name"/>
             <br><br>
            <label for="acctBalance">Email (can edit)</label>
            <input type="text" id="dEmail" name="dentEmail" value="<%=d1.getEmail()%>" placeholder="Enter Email"/>
             <br><br>
            <label for="acctBalance">Office</label>
            <input type="text" id="office" name="Office" value="<%=d1.getOffice()%>" readonly placeholder="Enter Office Number"/>
             <br><br>
             
            <input type="submit" value ="Edit" onclick="edit()"/>
        </form>
            <script type="text/javascript">                              
                 function edit() {
                     document.form1.action = "UpdateDentistInfoServ";
                     form1.submit();
                 }
                
                document.getElementById("submit").addEventListener("click", submit, false);
        </script>       
        
        <h3> <a href="Index.jsp">    Log out</a></h3>
    </body>
</html>
