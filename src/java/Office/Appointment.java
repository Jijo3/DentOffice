
package Office;

import java.sql.*;

/*****************************
 * Jose Chavez
 * Java 3 Projects
 * Dentist Office
 *
 ****************/

/****************
 *  This class holds the patients appointments
 ***************/
public class Appointment {
    
        public String DateTime;
        public String PatID;
        public String DentID;
        public String ProcCode;
    
        public Appointment() {
            
            DateTime = "";
            PatID = "";
            DentID = "";
            ProcCode = "";
        }
        
        public Appointment(String DTime, String PID, String DID, String PCode)  {
            
            DateTime = DTime;
            PatID = PID;
            DentID = DID;
            ProcCode = PCode;
            
        }
        
        public void setDateTime(String DTime) {DateTime = DTime;}
        public String getDateTime() {return DateTime;}
        
        public void setPatID(String PID) {PatID = PID;}
        public String getPatID() {return PatID;}
        
        public void setDentID(String DID) {DentID = DID;}
        public String getDentID() {return DentID;}
        
        public void setProcCode (String PCode) {ProcCode = PCode;}
        public String getProcCode() {return ProcCode;}
        
        
        public void display() {
            
            System.out.println("Date Time = " + DateTime );
            System.out.println("Patient ID = " + PatID);
            System.out.println("Dentist ID = " + DentID);
            System.out.println("Procedure Code= " + ProcCode);
          
        }
        
        /************
         * SelectDB method selects from the database for Patient ID
         * 
         ********************/
        public void selectDBP(String id) {
             
             
             try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "Select apptDateTime, patId, dentId, procCode from Appointments WHERE patId = "+"'"+id+"'";
                ResultSet rs = stat.executeQuery(sql);
                
                rs.next();
                
                DateTime = rs.getString(1);
                PatID = rs.getString(2);
                DentID = rs.getString(3);
                ProcCode = rs.getString(4);
                
            
                c1.close();
            }       
            catch(Exception se) {
		System.out.println(se);
			}
        
        }
        
        /**************************
         * The Other selectDB to select from the database for Dentist ID
         *
         *****************************/
        public void selectDBD(String id){
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1;
            c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                           
            Statement stmt = c1.createStatement();
            String sql = "select apptDateTime, patId, dentId, procCode from Appointments WHERE dentId = "+"'"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
                
            DateTime = rs.getString(1);
            PatID = rs.getString(2);
            DentID = rs.getString(3);
            ProcCode = rs.getString(4);
                
            
            c1.close();
            
        }
        catch(Exception ae){
            System.out.println(ae);
            
        }
    }
        
           
        /****************
         * insertDB adds to the database
         ******************/
        public void insertDB(String DTime, String PID, String DID, String PCode)  {
            
           
            try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "Insert into Appointments (apptDateTime, patId, dentId, procCode) "
                     + "values ('" +getDateTime()+"'," + "'"+getPatID()+"'," + "'"+getDentID()+"'," + "'"+getProcCode();
                
                System.out.println(sql);
                int n1 = stat.executeUpdate(sql);
                if(n1==1)
                    System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            c1.close();
            }
            
        catch(Exception e1){
            System.out.println(e1);
            }
        }
        /****************
         * updateDB changes the data in the database
         *********************/
        public void updateDB() {

        try {
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           Connection c1;
           c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
           
            Statement stmt = c1.createStatement();
            String sql = "Update Appointments Set apptDateTime ='" + getDateTime() + "', patId ='" + getPatID()
                    + "', dentId ='" + getDentID() + "', procCode ='" + getProcCode();
            int n;
            n = stmt.executeUpdate(sql);
            if (n == 1) {
                System.out.println("Update Successful!!");
            }
            c1.close();

        } catch (Exception ae) {
                System.out.println(ae);
        }
    }
               
        /*************
         * deleteDB removes data from the database
         ***************************/
        
        public void deleteDB()  {
            
            try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement(); 
                String sql = "Delete from Appointments where patId = '" +getPatID()+"'";
                int n = stat.executeUpdate(sql);
                
                if (n==1)
                    System.out.println("Delete Successful!");
                else
                    System.out.println("Delete Failed!");
                
              c1.close();
                
        }
            catch(Exception e1){
            System.out.println(e1);
        }
      }
         
       
        public static void main(String args[]) {
            
            Appointment a1 = new Appointment();
            a1.selectDBP("A910");            
            a1.display();
            
            Appointment a2 = new Appointment();
            a2.selectDBD("D201");
            a2.display();
        }

}
