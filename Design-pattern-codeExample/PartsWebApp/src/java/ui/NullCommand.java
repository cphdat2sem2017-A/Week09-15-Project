package ui;

import javax.servlet.http.HttpServletRequest;


class NullCommand implements Command {

   private String next;
    
    public NullCommand(String jsp) {
        next  = jsp;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return next;
    }
    
}
