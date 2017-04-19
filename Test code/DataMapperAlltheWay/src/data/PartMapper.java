package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Part;

/**
 * Maps between objects and tables
 *
 * @author Tine
 */
public class PartMapper {

    public Part getPart(int pno) {
        ResultSet rs = null;
        Part p = null;
        String SQLString
                = "select * "
                + "from parts "
                + "where pno = ?";

        try (PreparedStatement statement = DBConnection.prepare(SQLString)) {
            statement.setInt(1, pno);

            rs = statement.executeQuery();
            if (rs.next()) {
                p = new Part(pno,
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
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

        try (PreparedStatement statement = DBConnection.prepare(SQLString)) {
            statement.setInt(1, QOH);
            statement.setInt(2, pno);
            rowsAffected = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in PartsMapper - updatePart " + e.getMessage());
        }

        return rowsAffected == 1;
    }
}
