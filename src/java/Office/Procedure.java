
package Office;

import java.sql.*;

/*******************
 * Jose Chavez
 * Java 3 Project
 * Dentist Office
 ************************/



/****************
 * Procedure class holds all the procedure information
 *
 ****************/
public class Procedure {
    
    
        public String ProcCode;
        public String ProcName;
        public String ProcDescription;
        public Double Cost;
    
        public Procedure() {
            
            ProcCode = "";
            ProcName = "";
            ProcDescription = "";
            Cost = 0.0;
        }
        
        public Procedure(String Pcode, String Pname, String Pdescription, Double cost)  {
            
            ProcCode = Pcode;
            ProcName = Pname;
            ProcDescription= Pdescription;
            Cost = cost;
            
        }
        
        public void setProcCode(String Pcode) {ProcCode = Pcode;}
        public String getProcCode() {return ProcCode;}
        
        public void setProcName(String Pname) {ProcName = Pname;}
        public String getProcName() {return ProcName;}
        
        public void setProcDescription(String Pdescription) {ProcDescription = Pdescription;}
        public String getProcDescription() {return ProcDescription;}
        
        public void setCost (Double cost) {Cost = cost;}
        public Double getCost() {return Cost;}
        
        
        public void display() {
            
            System.out.println("Procedure Code = " + ProcCode );
            System.out.println("Procedure Name = " + ProcName);
            System.out.println("Procedure Description = " + ProcDescription);
            System.out.println("Cost= " + Cost);
          
        }
        
         /************
         * SelectDB method selects from the database
         ********************/
        public void selectDB(String Pcode) {
             
             
             try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stmt = c1.createStatement();
                String sql = "select * from Procedures WHERE procCode = "+"'"+ Pcode+"'";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                
                ProcCode = rs.getString(1);
                ProcName = rs.getString(2);
                ProcDescription = rs.getString(3);
                Cost = rs.getDouble(4);
                
            
                c1.close();
            }       
            catch(Exception se) {
		System.out.println(se);
			}
        
        }
        
        /****************
         * insertDB adds to the database
         ******************/
        public void insertDB(String Pcode, String Pname, String Pdescription, Double cost)   {
            
            ProcCode = Pcode;
            ProcName = Pname;
            ProcDescription= Pdescription;
            Cost = cost;
            
               
            try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement();
                String sql = "Insert Procedures values"
                     + "('" +getProcCode()+"'," + "'"+getProcName()+"'," + "'"+getProcDescription()+"'," + "'"+getCost();
                
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

                Statement stat = c1.createStatement();
                String sql = "update Procedures set procCode = '"+getProcCode() + "',"+ 
                                                " procName ='"+getProcName()+"',"+
                                                " procDesc = '"+getProcDescription() +"',"+
                                                " cost ='"+getCost()+"'";

                int n = stat.executeUpdate(sql);
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
        
        
        public void deleteDB()  {
            
            try {   
                
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection c1;
                c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/jose9/OneDrive/Documents/SCHOOLSTUFF!!!!/CIST 2373 JAVA III/Java Database File/DentistOfficeACCDB.accdb");
                
                Statement stat = c1.createStatement(); 
                String sql = "Delete from Procedures where procCode = '" +getProcCode()+"'";
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
            
            Procedure p1 = new Procedure();
            p1.selectDB("P114");            
            p1.display();
        }
}
