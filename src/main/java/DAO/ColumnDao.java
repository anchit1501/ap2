package DAO;

import Utils.DatabaseConnection;
import Utils.DatabaseUtils;
import javafx.event.ActionEvent;

import java.sql.*;

public class ColumnDao {

    public static void createNewColumn(ActionEvent event, String projectName, String projectId) {
        ResultSet resultSet = null;

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement insertColumnQuery = null;

        try {
            insertColumnQuery = connectDB.prepareStatement("INSERT INTO columns(column_name,project_id) VALUES (?,?)");
            insertColumnQuery.setString(1, projectName);
            insertColumnQuery.setString(2,projectId);
            insertColumnQuery.executeUpdate();
            DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Welcome", null);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (insertColumnQuery != null) {
                try {
                    insertColumnQuery.close();
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
