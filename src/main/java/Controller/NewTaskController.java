package Controller;

import DAO.TaskDao;
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
    public Button cancelTaskButton;

    @FXML
    public CheckBox completed;

    @FXML
    public Button createTaskButton;

    @FXML
    public DatePicker dueDate;

    @FXML
    public TextArea taskDescription;

    @FXML
    public TextField taskName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Integer columnId = null;

        cancelTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Dashboard", null);
            }
        });

        createTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!taskName.getText().trim().isEmpty()) {
                    TaskDao.createTask(taskName.getText(),taskDescription.getText(),columnId);
                    DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Dashboard", null);
                } else {
                    System.out.println("Please enter a task name");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter a task name");
                    alert.show();
                }
            }
        });
    }
}
