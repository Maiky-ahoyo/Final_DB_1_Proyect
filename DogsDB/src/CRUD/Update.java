package CRUD;

import Utileries.Connect;

import javax.swing.*;
import java.sql.*;

public class Update {
    private static String URL = "jdbc:postgresql://localhost:5432/Pawesome_Friends";
    private static String user = Connect.getUser(), password = Connect.getPassword();
    private static Connection connection;
    private static PreparedStatement statement;

    public static boolean updateVet(int vet_id, String vet_name, String details) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE vets SET vet_name = ?, other_details = ? WHERE vet_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, vet_name);
            statement.setString(2, details);
            statement.setInt(3, vet_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateDog(int dog_id, String dog_name, String place_of_birth, Date date_of_birth, int litter_id, String gender, String details) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE dogs SET dogs_name = ?, place_of_birth = ?, date_of_birth = ?, born_in_litter_id = ?, " +
                    "gender_mf = ?, other_details = ? WHERE dog_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, dog_name);
            statement.setString(2, place_of_birth);
            statement.setDate(3, date_of_birth);
            statement.setInt(4, litter_id);
            statement.setString(5, gender);
            statement.setString(6, details);
            statement.setInt(7, dog_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateLitter(int litter_id, int sire_dog_id, int dam_dog_id, String place_of_birth, Date date_of_birth, String details) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE litters SET litter_sire_dog_id = ?, litter_dam_dog_id = ?, place_of_birth_of_litter = ?, " +
                    "date_of_birth_of_litter = ?, other_details = ? WHERE litter_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, sire_dog_id);
            statement.setInt(2, dam_dog_id);
            statement.setString(3, place_of_birth);
            statement.setDate(4, date_of_birth);
            statement.setString(5, details);
            statement.setInt(6, litter_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateRelationship(int relationship_id, int relationship_code, int dog_1_id, int dog_2_id, String details) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE relationships SET relationship_code = ?, dog_1_id = ?, dog_2_id = ?, other_details = ? " +
                    "WHERE relationship_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, relationship_code);
            statement.setInt(2, dog_1_id);
            statement.setInt(3, dog_2_id);
            statement.setString(4, details);
            statement.setInt(5, relationship_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateRelationshipType(int relationship_code, String description) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE relationship_types SET relationship_description = ? WHERE relationship_code = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, description);
            statement.setInt(2, relationship_code);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateHealthRecord(int health_record_id, int vet_id, int dog_id, String summary, String details) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE health_records SET vet_id = ?, dog_id = ?, summary = ?, details = ? WHERE " +
                    "health_record_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, vet_id);
            statement.setInt(2, dog_id);
            statement.setString(3, summary);
            statement.setString(4, details);
            statement.setInt(5, health_record_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateCommonProblem(int problem_code, String problem_description) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE common_problems SET problem_description = ? WHERE problem_code = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, problem_description);
            statement.setInt(2, problem_code);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There was an error saving the data");
            System.out.println("Error: " + e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return updated;
    }

    public static boolean updateDogProblems(int problem_code, int health_record_id, Date date_of_problem, String treatment, String details) {
        boolean updated = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE dog_problems SET health_record_id = ?, date_of_problem = ?, treatment = ?, other_details = ? " +
                    "WHERE problem_code = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, health_record_id);
            statement.setDate(2, date_of_problem);
            statement.setString(3, treatment);
            statement.setString(4, details);
            statement.setInt(5, problem_code);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                updated = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                updated = false;
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
        return updated;
    }

    public static boolean updateAdopted(int dog_id, String owner_name) {
        boolean adopted = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE dogs SET adopted = true, owner = ? WHERE dog_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, owner_name);
            statement.setInt(2, dog_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                adopted = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                adopted = false;
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
        return adopted;
    }

    public static boolean updateReturned(int dog_id) {
        boolean returned = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
            String query = "BEGIN TRANSACTION ";
            statement = connection.prepareStatement(query);
            statement.execute();

            query = "UPDATE dogs SET adopted = false, owner = 'no owner' WHERE dog_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, dog_id);
            statement.executeUpdate();

            int option = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "Save changes", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                connection.commit();
                JOptionPane.showMessageDialog(null, "Save complete");
                returned = true;
            } else {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Save canceled");
                returned = false;
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
        return returned;
    }
}
