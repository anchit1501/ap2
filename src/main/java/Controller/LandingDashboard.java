package Controller;

import Utils.DatabaseUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingDashboard implements Initializable {

    @FXML
    public MenuBar button_menu;

    @FXML
    public MenuItem button_delete;

    @FXML
    public MenuItem button_new_project;

    @FXML
    public Menu button_project;

    @FXML
    public Menu button_workspace;

    @FXML
    public Label quote_label;

//
//    Stage stage;

//    public LandingDashboard() {
//        this.stage = new Stage();
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_new_project.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) quote_label.getScene().getWindow();
                Parent root = null;
                try {
//                    Parent home_page_parent = FXMLLoader.load(getClass().getResource("/View/scene2.fxml"));
                    root = FXMLLoader.load(getClass().getResource("/view/popup.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle(("Add New Project"));
                stage.setScene(new Scene(root, 600, 400));
                stage.show();

//                try {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/popup.fxml"));
//                    // Customize controller instance
//                    Callback<Class<?>, Object> controllerFactory = param -> {
//                        return new PopupController(stage);
//                    };
//                    loader.setControllerFactory(controllerFactory);
//                    Pane root = loader.load();
//                    PopupController newProjectController = loader.getController();
//                    newProjectController.showStage(root);
//                    stage.close();
//                } catch (IOException e) {
//                    System.out.println("Error loading new project fxml!");
//                }
            }
        });
    }
}
