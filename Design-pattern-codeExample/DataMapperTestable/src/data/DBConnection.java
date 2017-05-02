package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Holds connection to database 
 *
 * @author tm
 */
public final class DBConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/test2";
    private static String id = "root";
    private static String pw = "root";

    /**
     *
     * @return a connection or null
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(URL, id, pw);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error in opening database constructor " + e.getMessage());
        }

        return null;
    }

}
