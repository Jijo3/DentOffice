<%-- 
    Document   : DentistLog
    Java 3 Project
    Dentist Office
    Author     : Jose CHavez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Please Login with Dentist Info</title>        
    </head>
    <body>
        <form action="DentistLoginServ" method="post" 
          name="DataForm" onSubmit="validate()">
        <h1>Please Login Dentist Info!</h1>
        
          <p>Dentist ID:
              <input type="Text" name="DentistID"/> <br/>          
          </p>
          <p>Password:
             <input type="Text" name="password"/> <br/>
          </p>
             <input type="submit" value="Login"/>
             <input type="reset" value="Clear"/>
    </form>
    </body>
</html>
