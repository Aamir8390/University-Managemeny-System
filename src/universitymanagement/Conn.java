package universitymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    public Statement statement;

    public Conn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/universitymanagement", "root", "123456");
            statement = connection.createStatement();


        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}
