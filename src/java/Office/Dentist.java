
package Office;

import java.sql.*;

/***************************
 *Jose Chavez
 *Java 3 Project
 * Dentist Office
 * 
 ************************/



/****************
 *  This class holds the dentist information
 ***************/
public class Dentist {
    
        public String ID;
        public String Password;
        public String FirstName;
        public String LastName;
        public String Email;
        public String Office; 
        
        
        public AppointmentList aList = new AppointmentList();
       
    
        public Dentist() {
            
            ID = "";
            Password = "";
            FirstName = "";
            LastName = "";
            Email = "";
            Office = "";
            
        }
        
        public Dentist(String id, String pw, String FName, String LName, String email, String office)  {
            
            ID = id;
            Password = pw;
            FirstName = FName;
            LastName = LName;
            Email = email;
            Office = office;
            
        }
        
        public void setID(String id) {ID = id;}
        public String getID() {return ID;}
        
        public void setPassword(String pw) {Password = pw;}
        public String getPassword() {return Password;}
        
        public void setFirstName(String FName) {FirstName = FName;}
        public String getFirstName() {return FirstName;}
        
        public void setLastName(String LName) {LastName = LName;}
        public String getLastName() {return LastName;}
        
        public void setEmail(String email) {Email = email;}
        public String getEmail() {return Email;}
        
        public void setOffice(String office) {Office = office;}
        public String getOffice() {return Office;}
                
        
        
        public void display() {
            
            System.out.println("Dentist ID = " + ID );
            System.out.println("Password = " + Password);
            System.out.println("First Name = " + FirstName);
            System.out.println("Last Name = " + LastName);
            System.out.println("Email = " + Email);
            System.out.println("Office = " + Office);
            aList.display();
          
        }
        
        /************
         * SelectDB method selects from the database
         ********************/
        
        public void selectDB(String id) {
             ID = "";
             
             try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "select * from Dentists WHERE id = " + "'" + id + "'";
                ResultSet rs = stat.executeQuery(sql);
                    
                rs.next(); 

                ID = rs.getString(1);
                Password = rs.getString(2);
                FirstName = rs.getString(3);
                LastName = rs.getString(4);
                Email = rs.getString(5);
                Office = rs.getString(6);

            
                c1.close();
            }       
            catch(Exception se) {
		System.out.println(se);
			}
             
        }
        
       /****************
         * insertDB adds to the database
         ******************/
        
        public void insertDB(String id, String pw, String FName, String LName, String email, String office)  {
            
            ID = id;
            Password = pw;
            FirstName = FName;
            LastName = LName;
            Email = email;
            Office = office;
            
               
            try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "Insert into Dentists (id, passwd, firstName, lastName, email, office) "
                     + "values ('" +getID()+"'," + "'"+getPassword()+"'," + "'"+getFirstName()+"'," + "'"+getLastName()+"',"
                        +getEmail()+"'," + "'"+getOffice();
                
                
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
        getAppointments();
      
    }
         /****************
         * updateDB changes the data in the database
         *********************/
        public void updateDB(){
        
       
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1; 
            c1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");                    
            
            String sql =  "UPDATE Dentists SET id = '"+ getID() +"', passwd = '"+ getPassword() +"', firstName = '"+ getFirstName() +"', lastName = '"+ getLastName()+"', email = '"+ getEmail() +"', office = '"+  getOffice() +"' WHERE id = '"+ getID() +"'";
            PreparedStatement pstat = c1.prepareStatement(sql);
            
            System.out.println(sql);
            int n = pstat.executeUpdate();
            if (n==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            c1.close();
        }
        catch(Exception e1){
            System.out.println(e1);
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
                String sql = "Delete from Dentists where apptDateTime = '" +getID()+"'";
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
        
        public void getAppointments() {
            
            try  {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
           
                Statement stat = c1.createStatement();
                String sql = "Select patid  from Appointments WHERE dentId = " + "'" + getID() + "'";
                
                ResultSet rs = stat.executeQuery(sql);
                
                String appt; 
                Appointment a1;
             
                while (rs.next()) {
                    appt = rs.getString(2);
                    a1 = new Appointment();
                    a1.selectDBD(appt);
                    aList.addAppoint(a1);
                    
                  //list.displayList();
                }
     
           }catch(Exception e1){
                System.out.println(e1);
                }
        }
        public static void main(String args[]) {
            
           Dentist d1 = new Dentist();
            d1.selectDB("D201");            
            d1.display();
            
           // Dentist d2 = new Dentist();
            //d2.selectDB("D204");
             //d2.setPassword("Hello");
             //d2.updateDB();
           // d2.display();
        }
    
}
