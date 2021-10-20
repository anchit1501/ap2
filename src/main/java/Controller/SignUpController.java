package Controller;

import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

    @FXML
    public Button image_change;

    @FXML
    public ImageView profile_image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!user_name.getText().trim().isEmpty()) {
                    DatabaseUtils.signUpUser(event, user_name.getText(), user_password.getText(), first_name.getText(), last_name.getText());
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
                DatabaseUtils.changeScene(event, "/view/sign-in.fxml", "Login", null);
            }
        });

        image_change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                InputStream fileInputStream;
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FileChooser fileChooser = new FileChooser();
                // File extension
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.png", "*.jpg", "*.jpeg");
                fileChooser.getExtensionFilters().add(extFilter);
                fileChooser.setTitle("Open Image");

                File file = fileChooser.showOpenDialog(stage);

                if (file != null) {
                    try {
                        System.out.println(file);
                        fileInputStream = new FileInputStream(file);
                        System.out.println(fileInputStream);
                        profile_image.getImage().cancel();
                        profile_image.setImage(new Image(fileInputStream));
                    } catch (FileNotFoundException e) {
                        Scene scene = new Scene(new Label(e.getMessage()), 579.0, 723.0);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.setTitle("Error while loading image");
                        stage.show();
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
