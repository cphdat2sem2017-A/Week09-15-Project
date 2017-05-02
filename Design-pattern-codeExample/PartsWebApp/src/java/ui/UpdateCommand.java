package ui;

import data.DBFacade;
import javax.servlet.http.HttpServletRequest;

class UpdateCommand implements Command{

    private String next;
    
    public UpdateCommand(String jsp) {
        next  = jsp;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DBFacade facade = new DBFacade();
        int pno = 0;
        int qoh = 0;
        String p = (String) request.getParameter("pno");
        String q = (String) request.getParameter("qoh");
        pno = Integer.parseInt(p);
        qoh = Integer.parseInt(q);
        
        boolean status = facade.updatePart(pno, qoh);
        
        
        return next;
    }
    
}
