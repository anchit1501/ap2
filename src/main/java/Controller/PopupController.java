package Controller;

import DAO.ProjectDao;
import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PopupController implements Initializable {

    @FXML
    public Button button_cancel;

    @FXML
    public Button button_create;

    @FXML
    public TextField project_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button_cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Login", null);
            }
        });

        button_create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!project_name.getText().trim().isEmpty()) {
                    ProjectDao.createNewProject(event, project_name.getText().trim());
                } else {
                    System.out.println("Please enter a valid project name");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter a valid project name");
                    alert.show();
                }
            }
        });
    }
}
