package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Part;
import java.sql.Connection;

/**
 * Maps between objects and tables
 *
 * @author tm
 */

//make package visible when DBFacade is created
 class PartMapper {

    private Connection con = null;
    
    public PartMapper(Connection con) {
        this.con = con;
    }

    //NEW due to front controller
    public PartMapper() {
        this.con = DBConnection.getConnection();
    }
    
    public Part getPart(int pno) {
        Part p = null;
        String SQLString
                = "select * "
                + "from parts "
                + "where pno = ?";

        try (PreparedStatement statement = con.prepareStatement(SQLString)) {
            statement.setInt(1, pno);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                p = new Part(pno,
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("Fail in PartsMapper - getPart " + e.getMessage());
        }

        return p;
    }

    public boolean updatePart(int pno, int QOH) {
        int rowsAffected = 0;
        String SQLString
                = "update parts "
                + "set QOH = ? "
                + "where pno = ?";

        try (PreparedStatement statement = con.prepareStatement(SQLString)) {
            statement.setInt(1, QOH);
            statement.setInt(2, pno);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fail in PartsMapper - updatePart " + e.getMessage());
        }

        return rowsAffected == 1;
    } 
}
