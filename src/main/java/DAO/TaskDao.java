package DAO;

import Model.TaskModel;
import Utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDao {
    public static void createTask(String taskName, String description, Integer columnId) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();
        PreparedStatement createTaskQuery = null;


        try {
            createTaskQuery = connectDB.prepareStatement("INSERT into tasks(task_name,description,coulumn_id) values(?,?,?)");
            createTaskQuery.setString(1, taskName);
            createTaskQuery.setString(2, description);
            createTaskQuery.setString(3, Integer.toString(columnId));
            Integer queryResult = createTaskQuery.executeUpdate();
            System.out.println(createTaskQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (createTaskQuery != null) {
                try {
                    createTaskQuery.close();
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
