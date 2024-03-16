
package Office;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/******************************
 * Jose Chavez
 * JAva 3 Project
 * Dentist Office
 ******************************/
@WebServlet(name = "DentistLoginServ", urlPatterns = {"/DentistLoginServ"})
public class DentistLoginServ extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            //gets id and password
            String id = request.getParameter("DentistID");
            String password = request.getParameter("password");
            
            System.out.println("ID : " + id);
            System.out.println("Password: " + password);
            
            HttpSession session;
            session = request.getSession(true);
                          
            System.out.println("DentistId retrieved = " + id);
            Dentist d1 = new Dentist();
            d1.selectDB(id);
            System.out.println("First Name = " + d1.getFirstName());
                    
            if(password.equals(d1.getPassword())) {             //Check to see if Passwords match with database
                   
                    session.setAttribute("d1", d1);
                    System.out.println("Dentist d1 object has been added");
                    RequestDispatcher rd = request.getRequestDispatcher("DentistInfo.jsp");
                    rd.forward(request, response);      //Goes to dentist info page if all is good
                    
            }else {
                    RequestDispatcher rd = request.getRequestDispatcher("DentistError.jsp");
                    rd.forward(request, response);          //Error page if it does not match
                    }
        }
        catch (NullPointerException e) {
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
