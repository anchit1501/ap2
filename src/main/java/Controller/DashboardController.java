package Controller;

import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
                DatabaseUtils.changeScene(event, "/view/popup.fxml", "Popup", null);
            }
        });
    }

}
