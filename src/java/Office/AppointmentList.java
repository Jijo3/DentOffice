
package Office;
import java.util.ArrayList;
/***************************
 * Jose Chavez
 * Java 3 Project
 * Dentist Office
 * 
 ***************************/
public class AppointmentList {
    
    // array is made
    public int count = 0;
    public ArrayList<Appointment> aList = new ArrayList<Appointment>();
    
    
    //addappoint method
    public void addAppoint(Appointment a1) {
        aList.add(count, a1);
        count++;
    }
    //Display method
    public void display() {
        for (int x = 0; x < aList.size(); x++) {
            aList.get(x).display();
        }
    }
    
    public static void main(String args[]) {
        AppointmentList list = new AppointmentList();
        Appointment a1 = new Appointment("April 16, 1991, 1am", "A901", "D203","P910");
        Appointment a2 = new Appointment("November 15, 1984, 9am", "A904", "D201", "P650");
        list.addAppoint(a1);
        list.addAppoint(a2);
        list.display();
    }
  }
    

