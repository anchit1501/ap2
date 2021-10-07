package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
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
                DBUtils.logInUser(event,user_name.getText(), user_password.getText());
            }
        });

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(("button_sig_up"));
                DBUtils.changeScene(event,"sign-up.fxml","Sign Up",null);
            }
        });
    }
}