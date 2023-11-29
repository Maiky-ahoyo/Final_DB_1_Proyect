package CRUD;

import Utileries.Connect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private static String URL = "jdbc:postgresql://localhost:5432/Pawesome_Friends";
    private static String user = Connect.getUser(), password = Connect.getPassword();
    private static Connection connection;
    private static PreparedStatement statement;

    public static boolean deleteInfo(String table, String column, int ID_Code) {
        boolean deleted = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "DELETE FROM " + table +" WHERE " + column + " = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, ID_Code);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to delete this information?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Delete complete");
                deleted = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Delete canceled");
                deleted = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error deleting the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return deleted;
    }

    public static boolean deleteInfo(String table, String column1, int code, String column2, int ID) {
        boolean deleted = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "DELETE FROM " + table + " WHERE " + column1 + " = ? AND " + column2 + " = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, code);
            statement.setInt(2, ID);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to delete this information?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Delete complete");
                deleted = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Delete canceled");
                deleted = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error deleting the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return deleted;
    }
}
