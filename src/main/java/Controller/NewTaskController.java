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
    private Button cancel_task;

    @FXML
    private CheckBox completed;

    @FXML
    private Button create_task;

    @FXML
    private DatePicker due_date;

    @FXML
    private TextArea task_description;

    @FXML
    private TextField task_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cancel_task.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Dashboard", null);
            }
        });

        create_task.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Dashboard", null);
            }
        });
    }
}
