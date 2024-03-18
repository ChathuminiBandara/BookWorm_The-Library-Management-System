package lk.ijse.librarymanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.AdminDTO;
import lk.ijse.librarymanagementsystem.dto.UserDTO;
import lk.ijse.librarymanagementsystem.bo.ServiceBO;
import lk.ijse.librarymanagementsystem.bo.impl.LogginBOImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class passwordCHangeController implements Initializable {
    public static String type  = "z";

    public static UserDTO user = null;
    public static AdminDTO admin = null;

    @FXML
    private TextField emailField;

    @FXML
    private Label mainLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    LogginBOImpl logginServiceImpl = (LogginBOImpl) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.LOGGINService);

    @FXML
    void onSaveClick(ActionEvent event) {
        if (type.equals("a")){
            admin.setUsername(usernameField.getText());
            admin.setPassword(passwordField.getText());
            admin.setEmail(emailField.getText());
            boolean b = logginServiceImpl.updateAdmin(admin);
            if (b){
                new Alert(Alert.AlertType.INFORMATION,"Done").show();
                oncanselClick(event);
            }else {
                new Alert(Alert.AlertType.ERROR).show();
                oncanselClick(event);
            }
        } else if (type.equals("u")) {
            user.setUsername(usernameField.getText());
            user.setPassword(passwordField.getText());
            user.setEmail(emailField.getText());
            boolean b = logginServiceImpl.updateUser(user);
            if (b){
                new Alert(Alert.AlertType.INFORMATION,"Done").show();
                oncanselClick(event);
            }else {
                new Alert(Alert.AlertType.ERROR).show();
                oncanselClick(event);
            }
        }
    }

    @FXML
    void oncanselClick(ActionEvent event) {
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (type.equals("u")){
            usernameField.setText(user.getUsername());
            passwordField.setText(user.getPassword());
            emailField.setText(user.getEmail());
        } else if (type.equals("a")) {
            usernameField.setText(admin.getUsername());
            passwordField.setText(admin.getPassword());
            emailField.setText(admin.getEmail());
        }
    }
}
