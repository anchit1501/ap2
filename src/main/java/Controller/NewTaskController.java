package Controller;

import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class NewTaskController implements Initializable {

    @FXML
    private Button cancelTaskButton;

    @FXML
    private CheckBox completed;

    @FXML
    private Button createTaskButton;

    @FXML
    private DatePicker dueDate;

    @FXML
    private TextArea taskDescription;

    @FXML
    private TextField taskName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cancelTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Dashboard", null);
            }
        });

        createTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Dashboard", null);
            }
        });
    }
}
