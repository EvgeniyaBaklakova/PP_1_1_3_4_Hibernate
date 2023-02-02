package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String userName = "root";
    private static String password = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("We connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("We didn't connect");
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
                System.out.println("Connection CLOSE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection was NOT created");
        }

    }

}


