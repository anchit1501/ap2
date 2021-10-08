package Controller;

import Utils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    public Button button_signup;

    @FXML
    public Button button_signin;

    @FXML
    public TextField first_name;

    @FXML
    public TextField last_name;

    @FXML
    public TextField user_name;

    @FXML
    public TextField user_password;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button_signup");
                if (!user_name.getText().trim().isEmpty()) {
                    DBUtils.signUpUser(event, user_name.getText(), user_password.getText(),first_name.getText(),last_name.getText());
                } else {
                    System.out.println("Please fill in all");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in");
                    alert.show();
                }
            }
        });

        button_signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/view/sign-in.fxml", "Login", null);
            }
        });
    }
}
