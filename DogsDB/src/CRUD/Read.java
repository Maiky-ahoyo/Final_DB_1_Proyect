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
            query = "SELECT vet_id FROM vets ORDER BY vet_id ASC";
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
            query = "SELECT dog_id FROM dogs ORDER BY dog_id ASC";
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
            query = "SELECT litter_id FROM litters ORDER BY litter_id ASC";
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
            query = "SELECT relationship_id FROM relationships ORDER BY relationship_id ASC";
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("relationship_id"));
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
            query = "SELECT relationship_code FROM relationship_types ORDER BY relationship_code ASC";
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
            query = "SELECT health_record_id FROM health_records ORDER BY health_record_id ASC";
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
            query = "SELECT problem_code FROM common_problems ORDER BY problem_code ASC";
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

    public static ArrayList<String> getAdoptedID() {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT dog_id FROM dogs WHERE adopted = false ORDER BY dog_id ASC";
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

    public static ArrayList<String> getVetInfo(int vet_id) {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM vets WHERE vet_id = " + vet_id;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("vet_name"));
                data.add(rs.getString("other_details"));
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

    public static ArrayList<String> getDogInfo(int dog_id) {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM dogs WHERE dog_id = " + dog_id;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("dogs_name"));
                data.add(rs.getString("place_of_birth"));
                data.add(String.valueOf(rs.getDate("date_of_birth")));
                data.add(String.valueOf(rs.getInt("born_in_litter_id")));
                data.add(rs.getString("gender_mf"));
                data.add(rs.getString("other_details"));
                data.add(String.valueOf(rs.getBoolean("adopted")));
                data.add(rs.getString("owner"));
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

    public static ArrayList<String> getLitterInfo(int litter_id) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM litters WHERE litter_id = " + litter_id;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(String.valueOf(rs.getInt("litter_sire_dog_id")));
                data.add(String.valueOf(rs.getInt("litter_dam_dog_id")));
                data.add(rs.getString("place_of_birth_of_litter"));
                data.add(String.valueOf(rs.getDate("date_of_birth_of_litter")));
                data.add(rs.getString("other_details"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }

    public static ArrayList<String> getRelationshipInfo(int relationship_id) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM relationships WHERE relationship_id = " + relationship_id;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(String.valueOf(rs.getInt("relationship_code")));
                data.add(String.valueOf(rs.getInt("dog_1_id")));
                data.add(String.valueOf(rs.getInt("dog_2_id")));
                data.add(rs.getString("other_details"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }

    public static ArrayList<String> getRelationshipTypeInfo(int relationship_code) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM relationship_types WHERE relationship_code = " + relationship_code;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("relationship_description"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }

    public static ArrayList<String> getHealthRecordInfo(int health_record_id) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM health_records WHERE health_record_id = " + health_record_id;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(String.valueOf(rs.getInt("vet_id")));
                data.add(String.valueOf(rs.getInt("dog_id")));
                data.add(rs.getString("summary"));
                data.add(rs.getString("details"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }

    public static ArrayList<String> getCommonProblemInfo(int problem_code) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT problem_description FROM common_problems WHERE problem_code = " + problem_code;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("problem_description"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }

    public static ArrayList<String> getDogProblems_HealthRecordsID(int problem_code) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT health_record_id FROM dog_problems WHERE problem_code = " + problem_code;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("health_record_id"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }

    public static ArrayList<String> getDogProblems_HealthRecordsIDInfo(int problem_code, int health_record_id) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
            query = "SELECT * FROM dog_problems WHERE problem_code = " + problem_code + " AND health_record_id = " + health_record_id;
            rs = statement.executeQuery(query);
            data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("date_of_problem"));
                data.add(rs.getString("treatment"));
                data.add(rs.getString("other_details"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
        return data;
    }
}
