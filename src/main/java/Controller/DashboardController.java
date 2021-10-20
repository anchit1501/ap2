package Controller;

import Utils.DatabaseUtils;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
    }

}
