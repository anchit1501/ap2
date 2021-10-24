package Controller;

import Model.ColumnModel;
import Model.ProjectModel;
import Utils.DatabaseConnection;
import Utils.DatabaseUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    public MenuItem button_delete_project;

    @FXML
    public Button button_logout;

    @FXML
    public MenuBar button_menu;

    @FXML
    public MenuItem button_new_project;

    @FXML
    public Button button_profile;

    @FXML
    public Label daily_quote;

    @FXML
    public TabPane project_pane;

    @FXML
    public MenuItem renameButton;

    @FXML
    public MenuItem setAsDefaultButton;

    @FXML
    public MenuItem addColumnButton;

    @FXML
    public MenuItem deleteButton;


    ObservableList<ProjectModel> projectModelObservableList = FXCollections.observableArrayList();
    ObservableList<ColumnModel> columnModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDBConnection();

        project_pane.getTabs().clear();

        String getprojectsQuery = "SELECT * from projects where user_id = 6";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(getprojectsQuery);
            while (queryResult.next()) {
                Integer id = queryResult.getInt("id");
                String projectName = queryResult.getString("project_name");
                Integer status = queryResult.getInt("status");
                Integer userId = queryResult.getInt("user_id");

                // Populate Observable List
                projectModelObservableList.add(new ProjectModel(id, projectName, status, userId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (ProjectModel project : projectModelObservableList) {
            // create Tab
            Tab tab = new Tab(project.getProjectName());

            // create a label
            Label label = new Label(project.getProjectName());

            // add label to the tab
            tab.setContent(label);

            // add tab
            project_pane.getTabs().add(tab);
        }


//        Get columns
        String getcolumnsQuery = "SELECT * from columns where project_id = 1";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(getcolumnsQuery);
            while (queryResult.next()) {
                Integer id = queryResult.getInt("id");
                String columnName = queryResult.getString("column_name");
                Integer status = queryResult.getInt("status");
                Integer projectId = queryResult.getInt("project_id");

                // Populate Observable List
                columnModelObservableList.add(new ColumnModel(id, columnName, status, projectId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(columnModelObservableList);

        if(columnModelObservableList.size()>0){

        }



        button_new_project.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) daily_quote.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/view/popup.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle(("Add New Project"));
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            }
        });

        button_profile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/profile.fxml", "Login", null);
            }
        });

        addColumnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) daily_quote.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/view/newColumn.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle(("Add New Column"));
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            }
        });


    }
}
