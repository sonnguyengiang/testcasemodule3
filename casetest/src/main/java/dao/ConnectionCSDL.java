package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCSDL {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/casetest";
            String user = "root";
            String password = "son@22122002";

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
