package Controller;

import DAO.UserDao;
import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public Button button_signin;

    @FXML
    public TextField user_name;

    @FXML
    public TextField user_password;

    @FXML
    public Button button_signup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    UserDao.logInUser(event,user_name.getText(), user_password.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/signUp.fxml","Sign Up",null);
            }
        });
    }
}