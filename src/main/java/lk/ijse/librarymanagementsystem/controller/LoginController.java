package lk.ijse.librarymanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.controller.User.BookOBJformController;
import lk.ijse.librarymanagementsystem.controller.User.transactionManageformController;
import lk.ijse.librarymanagementsystem.controller.admin.AddAdminformController;
import lk.ijse.librarymanagementsystem.dto.AdminDTO;
import lk.ijse.librarymanagementsystem.dto.UserDTO;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.impl.LogginServiceImpl;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXButton logginBtn;

    @FXML
    private AnchorPane pane;


    @FXML
    private TextField usernameField;
    @FXML
    private AnchorPane panee;
    PasswordField passwordField1 ;
    TextField textField;

    LogginServiceImpl loggingService = (LogginServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.LOGGINService);

    @FXML
    void onEyeMouseEntered(MouseEvent event) {
        String text = passwordField1.getText();
        textFieldEntering(text);
    }

    private void textFieldEntering(String text) {
        textField = new TextField();
        textField.setPrefHeight(30);
        textField.setPrefWidth(262);
        textField.setStyle("-fx-border-color: blue");
        textField.setStyle("-fx-border-width: 1px");
        textField.setText(text);
        panee.getChildren().clear();
        panee.getChildren().add(textField);
    }

    @FXML
    void onEyeMouseExits(MouseEvent event) {
        String text = textField.getText();
        setpasswordField();
        setPasswordValues(text);
    }

    private void setPasswordValues(String text) {
        passwordField1.setText(text);
    }

    @FXML
    void onLogginCLick(ActionEvent event) {
        Stage stage = new Stage();
        String usernameFieldText = usernameField.getText();
        String passwordField1Text = passwordField1.getText();
        for (UserDTO u : loggingService.getAllUsers()){
            if (u.getUsername().equals(usernameFieldText) && u.getPassword().equals(passwordField1Text)){
                try {
                    BookOBJformController.userID = u.getId();
                    passwordCHangeController.user = u;
                    passwordCHangeController.type = "u";
                    transactionManageformController.id = u.getId();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user/UserDashboard.fxml"))));
                } catch (IOException e) {
                     new Alert(Alert.AlertType.ERROR,"Cant load dashboard").show();
                }
                stage.setResizable(false);
                stage.show();
                closeLogin();
            }
        }
        if (!stage.isShowing()){
        for (AdminDTO a : loggingService.getAllAdmins()) {
            if (a.getUsername().equals(usernameFieldText) && a.getPassword().equals(passwordField1Text)) {
                try {
                    passwordCHangeController.admin = a;
                    passwordCHangeController.type = "a";
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/adminDashboard.fxml"))));
                } catch (IOException e) {
                    new Alert(Alert.AlertType.ERROR, "Cant load dashboard").show();
                }
                stage.setResizable(false);
                stage.show();
                closeLogin();
            }
        }
        }
    }

    private void closeLogin() {
        Stage stage  = (Stage) logginBtn.getScene().getWindow();
        stage.close();
    }


    @SneakyThrows
    @FXML
    void onSignUpClick(MouseEvent event) {
        Stage stage = new Stage();
        AddAdminformController.type = "u";
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/AddAdmin.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setpasswordField();
    }

    private void setpasswordField() {
        passwordField1 = new PasswordField();
        passwordField1.setPrefWidth(262);
        passwordField1.setPrefHeight(30);
        passwordField1.setPromptText("Enter your password");
        passwordField1.setStyle("-fx-border-width: 1px");
        passwordField1.setStyle("-fx-border-color: blue");
        panee.getChildren().clear();
        panee.getChildren().add(passwordField1);
    }
}
