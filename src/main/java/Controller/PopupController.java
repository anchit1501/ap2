package Controller;

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

//    Stage stage ;
//    Stage parentStage;
//
//    public PopupController(Stage stage) {
//        this.stage = new Stage();
//        this.parentStage = stage;
//    }
//    public void showStage(Pane root) {
//        Scene scene = new Scene(root, 500, 300);
//        stage.setScene(scene);
////    stage.setResizable();
//        stage.setTitle("Add Task");
//        stage.show();
//    }

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
                    DatabaseUtils.createNewProject(event, project_name.getText().trim());
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
