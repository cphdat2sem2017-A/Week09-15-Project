package ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontControllerNewer", urlPatterns = {"/FrontControllerNewer"})
public class FrontControllerNewer extends HttpServlet {

    private HashMap commands;   
    private String error = "error.jsp";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initCommands();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String next;
        try {
            Command cmd = lookupCommand(request.getParameter("cmd"));
            next = cmd.execute(request);
        } catch (CommandException ex) {
            Logger.getLogger(FrontControllerNewer.class.getName()).log(Level.SEVERE, null, ex);
            next = error;
        }

        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + next);
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

    private void initCommands() {        
        commands = new HashMap();
        commands.put("main-menu", new NullCommand("menu.jsp"));
        commands.put("update-part", new UpdateCommand("updatePart.jsp"));
        commands.put("get-part", new GetCommand("status.jsp"));
    }

    private Command lookupCommand(String cmd) throws CommandException {
        if (cmd == null) {
            cmd = "main-menu";
        }
        if (commands.containsKey(cmd.toLowerCase())) {
            return (Command) commands.get(cmd.toLowerCase());
        } else {
            throw new CommandException("Invalid Command Identifier");
        }
    }

}
