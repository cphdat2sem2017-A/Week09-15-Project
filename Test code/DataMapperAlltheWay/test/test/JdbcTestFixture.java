package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTestFixture {

    private Connection connection;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String ID = "root";
    private static String PWD = "root";    
    private static String DBNAME = "test2";
    private static String HOST = "localhost";

    public void setUp()  {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, ID, PWD);
            
            try (Statement st = connection.createStatement()) {
                // start transaction
                connection.setAutoCommit(false);

                // drop table
                st.addBatch("drop table parts");

                // create table
                st.addBatch("create table parts("
                        + "      pno      int not null,"
                        + "      pname    varchar(30),"
                        + "      qoh      int,"
                        + "      price    float,"
                        + "      olevel   int,   "
                        + "      primary key(pno))  ");

                // insert
                st.addBatch("insert into parts values (10506,'Land Before Time I',200,19.99,20)");
                st.addBatch("insert into parts values (10507,'Land Before Time II',156,19.99,20)");
                st.addBatch("insert into parts values (10508,'Land Before Time III',190,19.99,20)");
                st.addBatch("insert into parts values (10509,'Land Before Time IV',60,19.99,20)");
                st.addBatch("insert into parts values (10601,'Sleeping Beauty',300,24.99,20)");
                st.addBatch("insert into parts values (10701,'When Harry Met Sally',120,19.99,30)");
                st.addBatch("insert into parts values (10800,'Dirty Harry',140,14.99,30)");
                st.addBatch("insert into parts values (10900,'Dr. Zhivago',100,24.99,30) ");

                int[] updateCounts = st.executeBatch();

                // end transaction
                connection.commit();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Fail in JdbcTestFixture - setup + " + e.getMessage());       
        } 
    }
}
