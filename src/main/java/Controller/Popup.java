package Controller;

import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Popup implements Initializable {

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
                DatabaseUtils.changeScene(event, "/view/dash.fxml", "Login", null);
            }
        });
    }
}
