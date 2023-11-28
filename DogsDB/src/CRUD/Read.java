package CRUD;

import Utileries.Connect;

import java.sql.*;
import java.util.ArrayList;

public class Read {
    private static String URL = "jdbc:postgresql://localhost:5432/Pawesome_Friends",
            user = Connect.getUser(), password = Connect.getPassword(), query;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;

    public static ArrayList<String> getVetID() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT vet_id FROM vets";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("vet_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static ArrayList<String> getDogID() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT dog_id FROM dogs";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("dog_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static ArrayList<String> getLitterID() throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT litter_id FROM litters";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("litter_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static ArrayList<String> getRelationshipID() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT relationhip_id FROM relationships";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("relationhip_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static ArrayList<String> getRelationshipCode() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT relationship_code FROM relationship_types";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("relationship_code"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static ArrayList<String> getHealthRecordID() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT health_record_id FROM health_records";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("health_record_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static ArrayList<String> getProblemCode() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT problem_code FROM common_problems";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("problem_code"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxVetID() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (vet_id) FROM vets";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxDogID() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (dog_id) FROM dogs";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxLitterID() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (litter_id) FROM litters";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxRelationshipID() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (relationship_id) FROM relationships";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxRelationshipCode() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (relationship_code) FROM relationship_types";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxHealthRecordID() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (health_record_id) FROM health_records";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static int getMaxProblemCode() {
        int data = 0;
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT MAX (problem_code) FROM common_problems";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt("max") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }
}
