
package Office;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*****************************
 *Jose Chavez
 * Java 3 Project
 * Dentist Office
 *
 *************************/
@WebServlet(name = "PatientLoginServ", urlPatterns = {"/PatientLoginServ"})
public class PatientLoginServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        
            HttpSession ses1;
            ses1 = request.getSession(true);   
            
        try {
            // id and password is used
            String id = request.getParameter("PatientID");
            String password = request.getParameter("password");
            
            System.out.println("ID : " + id);
            System.out.println("Password: " + password);
            
            Patient p1 = new Patient();
            p1.selectDB(id);
           
            
            //setting the object in session           
            System.out.println("First Name = " + p1.getFirstName());
            
            if (password.equals(p1.getPassword())) {
                
                ses1.setAttribute("p1", p1);
                System.out.println("Patient p1 object has been added");
                RequestDispatcher rd = request.getRequestDispatcher("/PatientInfo.jsp");
                rd.forward(request, response);
                
          } else {
                
                RequestDispatcher rd = request.getRequestDispatcher("/PatientError.jsp");
                 rd.forward(request, response);
                 
                }
        } catch (NullPointerException e) {
            System.out.println(e);
        
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
