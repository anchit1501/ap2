package Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;

public class DatabaseUtils {


    public static void changeScene(ActionEvent event, String fxmlFile, String title, String userName) {

        Parent root = null;
            try {
                root = FXMLLoader.load(DatabaseUtils.class.getResource(fxmlFile));

            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle((title));
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

}
