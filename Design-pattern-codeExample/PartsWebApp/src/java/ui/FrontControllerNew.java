package ui;

import data.DBFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TM
 */
@WebServlet(name = "FrontControllerNew", urlPatterns = {"/FrontControllerNew"})
public class FrontControllerNew extends HttpServlet {

    DBFacade facade = new DBFacade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cmd = request.getParameter("cmd");
        boolean status = false;
        
        if (cmd.equals("update-part")) {
            int pno = 0;
            int qoh = 0;
            String p = (String) request.getParameter("pno");
            String q = (String) request.getParameter("qoh");
            pno = Integer.parseInt(p);
            qoh = Integer.parseInt(q);
           
            facade.updatePart(pno, qoh);           
        } 
        else if (cmd.equals("create-part")) {
            //TO DO
        }
        else if (cmd.equals("delete-part")) {
            //TO DO
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>DB result " + status + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
