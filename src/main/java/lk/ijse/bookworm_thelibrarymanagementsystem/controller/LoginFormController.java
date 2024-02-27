package lk.ijse.bookworm_thelibrarymanagementsystem.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class LoginFormController {

    public JFXButton btn_login;
    public JFXButton btn_signup;
    public TextField password_Text;
    public TextField name_Text;


    public void login_on_action(ActionEvent actionEvent) {
        password_Text.clear();
        name_Text.clear();

        /*call the suitable dashboard*/

    }

    public void name_on_action(ActionEvent actionEvent) {
    }

    public void password_on_action(ActionEvent actionEvent) {
    }

    public void sign_up_on_action(ActionEvent actionEvent) {
    }

}