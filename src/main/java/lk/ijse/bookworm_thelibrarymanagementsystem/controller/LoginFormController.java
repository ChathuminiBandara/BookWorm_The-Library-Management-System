package lk.ijse.bookworm_thelibrarymanagementsystem.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class LoginFormController {

    public JFXButton btn_login;
    public JFXButton btn_signup;
    public TextField password_Text;
    public TextField name_Text;
    public AnchorPane root;


    public void login_on_action(ActionEvent actionEvent) {
        password_Text.clear();
        name_Text.clear();

        try {
            AnchorPane pane = load(getClass().getResource("/FXML_Files/Main_Dashboard.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void name_on_action(ActionEvent actionEvent) {
    }

    public void password_on_action(ActionEvent actionEvent) {
    }

    public void sign_up_on_action(ActionEvent actionEvent) {

    }

}