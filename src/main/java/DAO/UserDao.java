package DAO;

import Model.UserModel;
import Utils.DatabaseConnection;
import Utils.DatabaseUtils;
import Utils.UserSession;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;

public class UserDao {
    UserSession userSession = null;

    public static void logInUser(ActionEvent event, String userName, String password) throws SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement userDetailsQuery = null;
        UserModel userProfile = null;
        ResultSet queryResult = null;

        try {
            userDetailsQuery = connectDB.prepareStatement("SELECT id,user_password from users where user_name =?");
            userDetailsQuery.setString(1, userName);
            queryResult = userDetailsQuery.executeQuery();
            if (!queryResult.isBeforeFirst()) {
                System.out.println("User not found in database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credential are incorrect");
                alert.show();
            } else {
                while (queryResult.next()) {
                    String retrievedPassword = queryResult.getString("user_password");
                    if (retrievedPassword.equals(password)) {
                        UserSession.putUserDetails(userName, queryResult.getString("id"));
//                        UserSession.setUserId(queryResult.getString("id"));
//                        UserSession.setUserName(queryResult.getString("user_name"));
                        DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Welcome", null);
                    } else {
                        System.out.println("Password mismatch");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credential are incorrect");
                        alert.show();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (queryResult != null) {
                try {
                    queryResult.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userDetailsQuery != null) {
                try {
                    userDetailsQuery.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connectDB != null) {
                try {
                    connectDB.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }


    public static void signUpUser(ActionEvent event, String userName, String password, String firstName, String last_name) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement userDetailsQuery = null;
        PreparedStatement signUpUserQuery = null;
        ResultSet queryResult = null;

        try {
            userDetailsQuery = connectDB.prepareStatement("SELECT * FROM users WHERE user_name=?");
            userDetailsQuery.setString(1, userName);
            queryResult = userDetailsQuery.executeQuery();

            if (queryResult.isBeforeFirst()) {
                System.out.println("User Exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this Username");
                alert.show();
            } else {
                signUpUserQuery = connectDB.prepareStatement("INSERT INTO users(user_name,user_password,first_name,last_name) VALUES(?, ?, ?, ?);");
                signUpUserQuery.setString(1, userName);
                signUpUserQuery.setString(2, password);
                signUpUserQuery.setString(3, firstName);
                signUpUserQuery.setString(4, last_name);
                signUpUserQuery.executeUpdate();
                DatabaseUtils.changeScene(event, "/view/signIn.fxml", "Welcome", userName);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (queryResult != null) {
                try {
                    queryResult.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (userDetailsQuery != null) {
                try {
                    userDetailsQuery.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (signUpUserQuery != null) {
                try {
                    signUpUserQuery.close();
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
