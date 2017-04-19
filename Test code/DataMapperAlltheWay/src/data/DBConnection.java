package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Holds connection to database 
 *
 * @author Tine
 */
public class DBConnection {

    private Connection con;
    private static DBConnection instance;
    private static PreparedStatement stmt;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/test2";
    private static String ID = "root";			
    private static String PWD = "root";
    
    private DBConnection() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, ID, PWD);  
                                                      
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error in DB constructor");
            System.out.println(e);
        }
    }

    private static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public static PreparedStatement prepare(String SQLString) {
        try {
            stmt = getInstance().con.prepareStatement(SQLString);
        } catch (SQLException e) {
            System.out.println("Error in DB.prepare()" + e);
        }
        return stmt;
    }

    public static void cleanUp(PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("Error in DB.cleanUp() closing resultSet" + e);
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            System.out.println("Error in DB.cleanUp() closing preparedStatement" + e);
        }        
    }
    
}
