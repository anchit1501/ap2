package Controller;

import DAO.ColumnDao;
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

public class NewColumnController implements Initializable {
    @FXML
    public Button cancelButton;

    @FXML
    public Button createButton;

    @FXML
    public TextField columnName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Login", null);
            }
        });

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!columnName.getText().trim().isEmpty()) {
                    ColumnDao.createNewColumn(event, columnName.getText().trim(),"1");
                } else {
                    System.out.println("Please enter a valid column name");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter a valid column name");
                    alert.show();
                }
            }
        });
    }
}
