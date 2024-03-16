
package Office;

import java.sql.*;


/**************
 * Jose Chavez
 * Java 3 Project
 *  Dentist Office
 * 
 *******************/


/******************
 * Patient class holds the patients information
 *
 ****************/
public class Patient {
    
        public String ID;
        public String Password;
        public String FirstName;
        public String LastName;
        public String Address;
        public String Email;
        public String InsuranceCo;  
        public boolean available = false;
        
       
        public AppointmentList aList = new AppointmentList();
    
        public Patient() {
            
            ID = "";
            Password = "";
            FirstName = "";
            LastName = "";
            Address = "";
            Email = "";
            InsuranceCo = "";
            
        }
        
        public Patient(String id, String pw, String FName, String LName, String address, String email, String InsCo)  {
            
            ID = id;
            Password = pw;
            FirstName = FName;
            LastName = LName;
            Address = address;
            Email = email;
            InsuranceCo = InsCo;
            
        }
        
        public void setID(String id) {ID = id;}
        public String getID() {return ID;}
        
        public void setPassword(String pw) {Password = pw;}
        public String getPassword() {return Password;}
        
        public void setFirstName(String FName) {FirstName = FName;}
        public String getFirstName() {return FirstName;}
        
        public void setLastName(String LName) {LastName = LName;}
        public String getLastName() {return LastName;}
        
        public void setAddress(String address) {Address = address;}
        public String getAddress() {return Address;}
        
        public void setEmail(String email) {Email = email;}
        public String getEmail() {return Email;}
        
        public void setInsuranceCo(String InsCo) {InsuranceCo = InsCo;}
        public String getInsuranceCo() {return InsuranceCo;}
        
        public boolean getAvailable() {
        return available;
        }
    
         public void setAvailable(boolean available) {
        this.available = available;
        }
                
        
        /************
         * SelectDB method selects from the database
         ********************/
        public void selectDB(String id) {
             
             try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "Select * from Patients WHERE patId = "+"'"+ id +"'";
                ResultSet rs = stat.executeQuery(sql);
                
                rs.next(); 
                    
                ID = rs.getString(1);
                Password = rs.getString(2);
                FirstName = rs.getString(3);
                LastName = rs.getString(4);
                Address = rs.getString(5);
                Email = rs.getString(6);
                InsuranceCo = rs.getString(7);
	
                
                c1.close();
            }       
            catch(Exception se) {
		System.out.println(se);
			}
             getAppointment();
        
        }
        /****************
         * insertDB adds to the database
         ******************/
        public void insertDB(String id, String pw, String FName, String LName, String address, String email, String InsCo)  {
            
            ID = id;
            Password = pw;
            FirstName = FName;
            LastName = LName;
            Address = address;
            Email = email;
            InsuranceCo = InsCo;
               
            try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "Insert into Patients values"
                     + "('" +getID()+"'," + "'"+getPassword()+"'," + "'"+getFirstName()+"'," + "'"+getLastName()+"',"
                       + "'"+getAddress()+"'," +getEmail()+"'," + "'"+getInsuranceCo();
                
                
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
         public void updateDB(){
         
       
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c1; 
            c1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");          
                      
            String sql = "UPDATE Patients SET patId = '"+ getID() +"', passwd = '"+ getPassword() +"', firstName = '"+ getFirstName() +"', lastName = '"+ getLastName() +"', addr = '"+ getAddress() +"', email = '"+ getEmail() +"', insCo = '"+ getInsuranceCo() +"' WHERE patId = '"+ getID() +"'";
            PreparedStatement pstat = c1.prepareStatement(sql);    
            
            System.out.println(sql);                               
            int n = pstat.executeUpdate(sql);
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
                String sql = "Delete from Patients where patId = '" +getID()+"'";
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
        
        
        
        /*********************
         * this function calls the appointment lists
         **********************/
        public void getAppointment() {
            
            try  {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
           
                Statement stat = c1.createStatement();
                String sql = "Select patId  from Appointments WHERE dentId = " + "'" + getID() + "'";
                
                ResultSet rs = stat.executeQuery(sql);
                
                String appt; 
                Appointment a1;
                a1 = new Appointment();
                if (!rs.next()) {
                    available = true;
                } else {
                    do {
                        appt = rs.getString(3);
                        a1.selectDBP(appt);
                    } while (rs.next());
                }
            }
                       
                catch(Exception e1){
                System.out.println(e1);
                }
   
        }
        
        public void display() {
            
            System.out.println("Patient ID = " + ID );
            System.out.println("Password = " + Password);
            System.out.println("First Name = " + FirstName);
            System.out.println("Last Name = " + LastName);
            System.out.println("Address = " + Address);
            System.out.println("Email = " + Email);
            System.out.println("Insurance Company = " + InsuranceCo);
          
        }
       
        public static void main(String args[]) {
            
            Patient p1 = new Patient();
            p1.selectDB("A900");            
            p1.display();
        }
    
    
}