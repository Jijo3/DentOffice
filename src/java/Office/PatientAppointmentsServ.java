
package Office;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/******************************
 * Jose Chavez
 * Java 3 Project
 * Dentist Office
 * 
 ************************/
@WebServlet(name = "PatientAppointmentsServ", urlPatterns = {"/PatientAppointmentsServ"})
public class PatientAppointmentsServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             
             HttpSession ses1;      //Session is made
             ses1 = request.getSession(true);
             Patient p2 = (Patient) ses1.getAttribute("p1");
        
             String id = p2.getID();
             System.out.println(id);
             boolean ava = p2.getAvailable();
             if(ava == false) {
                
                Appointment a2 = new Appointment(); 
                a2.selectDBP(id);
                ses1.setAttribute("a2", a2);
                System.out.println("Appointment a1 object has been added for Patient");
               
                RequestDispatcher rd = request.getRequestDispatcher("PatientAppointments.jsp");
                rd.forward(request, response);      //this goes to the patient appointments
                
        }    else{
                RequestDispatcher rd = request.getRequestDispatcher("AddAppointmentPatient.jsp");
                rd.forward(request, response);      // if Patient does not have an appointment, one will be created
        }
        } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
