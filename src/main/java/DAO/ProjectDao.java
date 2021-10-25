package DAO;

import Model.UserModel;
import Utils.DatabaseConnection;
import Utils.DatabaseUtils;
import Utils.UserSession;
import javafx.event.ActionEvent;

import java.sql.*;

public class ProjectDao {

    public static void createNewProject(ActionEvent event, String projectName) {

        System.out.println(UserSession.getInstance().getUserId());

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement projectDetailsQuery = null;
        ResultSet queryResult = null;
        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trello", "root", "admin@123");
            projectDetailsQuery = connectDB.prepareStatement("INSERT INTO projects(project_name,user_id) VALUES (?,?)");
            projectDetailsQuery.setString(1, projectName);
            projectDetailsQuery.setString(2,UserSession.getInstance().getUserId());
            projectDetailsQuery.executeUpdate();
            DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Welcome", null);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (projectDetailsQuery != null) {
                try {
                    projectDetailsQuery.close();
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
