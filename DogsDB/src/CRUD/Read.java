package CRUD;

import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {

    private static Statement stmnt;
    private static ResultSet rs;
    public static TableModel readTable(String table) {
        TableModel tableModel = null;
        try {
            stmnt = Utileries.Connect.connection.createStatement();
            rs = stmnt.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            String[] columnNames = new String[columns];
            for (int i = 1; i <= columns; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            rs = stmnt.executeQuery("SELECT * FROM " + table);
            String[][] data = new String[rows][columns];
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    data[j][i - 1] = rs.getString(i);
                }
                j++;
            }
            tableModel = new javax.swing.table.DefaultTableModel(data, columnNames);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tableModel;
    }
}
