package CRUD;

import Utileries.Connect;

import javax.swing.*;
import java.sql.*;

public class Create {
    private static String URL = "jdbc:postgresql://localhost:5432/Pawesome_Friends";
    private static String user = Connect.getUser(), password = Connect.getPassword();
    private static Connection connection;
    private static PreparedStatement statement;

    public static void createVet(int vet_id, String vet_name, String details) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO vets (vet_id, vet_name, other_details) VALUES (?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, vet_id);
            statement.setString(2, vet_name);
            statement.setString(3, details);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createDog(int dog_id, String dog_name, String place_of_birth, Date date_of_birth, int litter_id, String gender, String details) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO dogs (dog_id, dogs_name, place_of_birth, date_of_birth, born_in_litter_id, gender_mf, other_details) VALUES (?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, dog_id);
            statement.setString(2, dog_name);
            statement.setString(3, place_of_birth);
            statement.setDate(4, date_of_birth);
            statement.setInt(5, litter_id);
            statement.setString(6, gender);
            statement.setString(7, details);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createLitter(int litter_id, int sire_dog_id, int dam_dog_id, String place_of_birth, Date date_of_birth, String details) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO litters (litter_id, litter_sire_dog_id, litter_dam_dog_id, place_of_birth_of_litter, " +
                    "date_of_birth_of_litter, other_details) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, litter_id);
            statement.setInt(2, sire_dog_id);
            statement.setInt(3, dam_dog_id);
            statement.setString(4, place_of_birth);
            statement.setDate(5, date_of_birth);
            statement.setString(6, details);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createRelationship(int relationship_id, int relationship_code, int dog_1_id, int dog_2_id, String details) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO relationships (relationship_id, relationship_code, dog_1_id, dog_2_id, other_details) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, relationship_id);
            statement.setInt(2, relationship_code);
            statement.setInt(3, dog_1_id);
            statement.setInt(4, dog_2_id);
            statement.setString(5, details);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createRelationshipType(int relationship_code, String description) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO relationship_types (relationship_code, relationship_description) VALUES (?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, relationship_code);
            statement.setString(2, description);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createHealthRecord(int health_record_id, int vet_id, int dog_id, String summary, String details) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO health_records (health_record_id, vet_id, dog_id, summary, details) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, health_record_id);
            statement.setInt(2, vet_id);
            statement.setInt(3, dog_id);
            statement.setString(4, summary);
            statement.setString(5, details);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createCommonProblem(int problem_code, String problem_description) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO common_problems (problem_code, problem_description) VALUES (?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, problem_code);
            statement.setString(2, problem_description);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createDogProblems(int problem_code, int health_record_id, Date date_of_problem, String treatment, String details) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            String query = "INSERT INTO dog_problems (problem_code, health_record_id, date_of_problem, treatment, other_details) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, problem_code);
            statement.setInt(2, health_record_id);
            statement.setDate(3, date_of_problem);
            statement.setString(4, treatment);
            statement.setString(5, details);
            int i= statement.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(null,"Save complete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was an error saving the data");
            System.out.println("Error: "+e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
