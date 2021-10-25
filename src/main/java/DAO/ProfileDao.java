package DAO;

import Model.ProfileModel;
import Utils.DatabaseConnection;

import java.sql.*;

public class ProfileDao {

    public static ProfileModel getProfileData(String id) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement getUserDetailsQuery = null;
        ProfileModel userProfile = null;

        try {
            getUserDetailsQuery = connectDB.prepareStatement("SELECT * FROM users WHERE id= ?");
            getUserDetailsQuery.setString(1, id);
            ResultSet queryResult = getUserDetailsQuery.executeQuery();

            while (queryResult.next()) {
                Integer userId = queryResult.getInt("id");
                String firstName = queryResult.getString("first_name");
                String lastName = queryResult.getString("last_name");
                System.out.println(userId + firstName + lastName);

                // Populate Object
                userProfile = new ProfileModel(userId, firstName, lastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (getUserDetailsQuery != null) {
                try {
                    getUserDetailsQuery.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userProfile;
    }

    public static void updateProfile(String firstName, String lastName, Integer id) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement updateUserDetailsQuery = null;


        try {
            updateUserDetailsQuery = connectDB.prepareStatement("UPDATE users SET first_name = ?, last_name = ? WHERE id= ?");
            updateUserDetailsQuery.setString(1, firstName);
            updateUserDetailsQuery.setString(2, lastName);
            updateUserDetailsQuery.setString(3, Integer.toString(id));
            Integer queryResult = updateUserDetailsQuery.executeUpdate();
            System.out.println(updateUserDetailsQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (updateUserDetailsQuery != null) {
                try {
                    updateUserDetailsQuery.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
