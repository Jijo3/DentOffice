<%-- 
    Document   : PatientLog
    Java 3 Project
    Dentist OFfice
    Author     : Jose Chavez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Please Login with Patient Info</title>        
    </head> 
    <body>
    <form action="PatientLoginServ" method="post" 
          name="DataForm" onSubmit="validate()">
        <h1>Please Login Patient!</h1>
        
          <p>Patient ID:
              <input type="Text" name="PatientID"/> <br/>          
          </p>
          <p>Password:
             <input type="Text" name="password"/> <br/>
          </p>
             <input type="submit" value="Login"/>
             <input type="reset" value="Clear"/>
    </form>          
    </body>
</html>
