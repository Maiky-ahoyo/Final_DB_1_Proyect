package Utileries;

import java.sql.*;

public class Connect {
    public static java.sql.Connection connection;
    private static String URL = "jdbc:postgresql://localhost:5432/Pawesome_Friends";
    private static String user, password;

    public static void setUser(String user) {
        Connect.user = user;
    }

    public static void setPassword(String password) {
        Connect.password = password;
    }

    public static void ConnectDB() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
