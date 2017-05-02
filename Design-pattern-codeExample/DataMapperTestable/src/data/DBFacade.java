package data;

import model.Part;

/**
 *  Encapsulates the data access layer
 * @author tm
 */
public class DBFacade {
    private PartMapper pm;
    
    public DBFacade(PartMapper pm) {
        this.pm = pm;
    }
    
    public DBFacade() {
        this.pm = new PartMapper();
    }
    
    public Part getPart(int pno) {
        return pm.getPart(pno);
     }
     
     public boolean updatePart(int pno, int QOH) {
         return pm.updatePart(pno, QOH);
     }
}
