package lk.ijse.controller.my;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;


public class LoginFormController {
    public TextField password_Text;
    public TextField name_Text;
    public AnchorPane root;


    public void login_on_action(ActionEvent actionEvent) throws IOException {
        password_Text.clear();
        name_Text.clear();

        String enteredUsername = name_Text.getText();
        String enteredPassword = password_Text.getText();
/*
        if ("1".equals(enteredUsername) && "1".equals(enteredPassword)) {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXML_Files/user_dashboard.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("2".equals(enteredUsername) && "2".equals(enteredPassword)) {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXML_Files/Main_Dashboard.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            new Alert(Alert.AlertType.ERROR, "Invalid username or password").show();
        }*/


      /*  if (enteredUsername.equals(1) && enteredPassword.equals(1)){
            try {
                AnchorPane pane = load(getClass().getResource("/FXML_Files/Main_Dashboard.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (enteredUsername.equals(2) && enteredPassword.equals(2)) {
            try {
                AnchorPane pane = load(getClass().getResource("/FXML_Files/user_Dashboard.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR, "wrong password or user name").show();
        }*/

        AnchorPane pane = load(getClass().getResource("/FXML_Files/Main_Dashboard.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();

       /* AnchorPane pane = load(getClass().getResource("/FXML_Files/user_Dashboard.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();*/
    }

    public void sign_up_on_action(ActionEvent actionEvent) {

    }

}