package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;
import java.util.Collections;

public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String userName) {

        Parent root = null;

        if (userName != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardController dashboardController = loader.getController();
                dashboardController.setUserInfo(userName);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle((title));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String userName, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trello", "root", "admin@123");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE user_name=?");
            psCheckUserExists.setString(1, userName);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User Exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this Username");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users(user_name,user_password) VALUES(? ?)");
                psInsert.setString(1, userName);
                psInsert.setString(2, password);
                psInsert.executeUpdate();

                changeScene(event, "dashboard.fxml", "Welcome", userName);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String userName, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trello", "root", "admin@123");
            preparedStatement = connection.prepareStatement("SELECT user_password from users where user_name =?");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in databse!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credential are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("user_passowrd");
                    if (retrievedPassword.equals(password)) {

                        changeScene(event, "dashboard.fxml", "Welcome", userName);

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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
