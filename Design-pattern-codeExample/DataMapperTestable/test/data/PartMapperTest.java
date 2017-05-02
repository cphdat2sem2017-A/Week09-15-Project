package data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.Part;

/**
 *
 * @author tm
 */
public class PartMapperTest {

    PartMapper pm;
    Connection con;
    private static String DBNAME = "test2";
    private static String HOST = "localhost";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String ID = "root";
    private static String PWD = "root";

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, ID, PWD);

            try (Statement stmt = con.createStatement()) {             
                stmt.execute("drop table if exists parts");
                stmt.execute("create table parts as (select * from testparts)");
            }           
            pm = new PartMapper(con);            
            
        } catch (ClassNotFoundException | SQLException ex) {
            con = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());;
        }
    }

    @Test
    public void testSetUpOK() {
        assertNotNull("Setup failed", con);
    }

    @Test
    public void testGetPart() {
        Part p = pm.getPart(10506);
        assertTrue("Get Part failed", p.getPno() == 10506);
    }
    
    @Test
    public void testUpdatePart() {
        pm.updatePart(10506, 400);
        Part p = pm.getPart(10506);
        assertTrue("Update part failed", p.getQOH() == 400);
    }         
}
