
package Office;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*****************
 *Jose Chavez
 *Java 3 Project
 * Dentist Office
 * 
 * 
 **************************/
@WebServlet(name = "UpdateDentistInfoServ", urlPatterns = {"/UpdateDentistInfoServ"})
public class UpdateDentistInfoServ extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
            HttpSession session;            //Session is created
            session = request.getSession(true);
            Dentist d1 = (Dentist) session.getAttribute("d1");

            String id = d1.getID();       
            d1.selectDB(id);

            String fn = request.getParameter("dentFn");
            String ln = request.getParameter("dentLn");
            String email = request.getParameter("dentEmail");

            d1.setEmail(email);
            d1.setFirstName(fn);
            d1.setLastName(ln);
            d1.updateDB();

            RequestDispatcher rd = request.getRequestDispatcher("ChangeDentistInfo.jsp");
            rd.forward(request, response);

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
