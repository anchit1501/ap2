package Controller;


import DAO.ProfileDao;
import Model.ProfileModel;
import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    public Button saveButton;

    @FXML
    public Button cancelButton;

    @FXML
    public TextField firstName;

    @FXML
    public TextField lastName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ProfileModel userProfile = null;
        Integer userId = 1;

        try {
            userProfile = ProfileDao.getProfileData("1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userProfile != null) {
            firstName.setText(userProfile.getFirstName());
            lastName.setText(userProfile.getLastName());

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Something went wrong");
            alert.show();
        }

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProfileDao.updateProfile(firstName.getText(), lastName.getText(), userId);
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Welcome", null);
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.changeScene(event, "/view/dashboard.fxml", "Login", null);
            }
        });


    }
}
