package ui;

import data.DBFacade;
import model.Part;
import javax.servlet.http.HttpServletRequest;

class GetCommand implements Command {

   private String next;
    
    public GetCommand(String jsp) {
        next  = jsp;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DBFacade facade = new DBFacade();
        int pno = 0;       
        String p = (String) request.getParameter("pno");       
        pno = Integer.parseInt(p);
        Part part = facade.getPart(pno);
        request.setAttribute("part", part);
        
        return next;
    }

}
