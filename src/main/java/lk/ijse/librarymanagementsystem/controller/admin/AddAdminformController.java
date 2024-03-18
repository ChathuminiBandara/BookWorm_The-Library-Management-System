package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.AdminDTO;
import lk.ijse.librarymanagementsystem.dto.UserDTO;
import lk.ijse.librarymanagementsystem.bo.impl.LogginBOImpl;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AddAdminformController implements Initializable {

    @FXML
    private ComboBox<String> accounttypecombo;

    @FXML
    private TextField emailfield;

    @FXML
    private TextField passwordfiled;

    @FXML
    private TextField usernamefield;
    public static String type = "a" ;

    @FXML
    private Label mainLabel;


    LogginBOImpl logginServiceImpl = new LogginBOImpl();

    @FXML
    void onSaveClick(ActionEvent event) {
        String usernamefieldText = usernamefield.getText();
        String passwordfiledText = passwordfiled.getText();
        String emailfieldText = emailfield.getText();
        if (checkFields(usernamefieldText,passwordfiledText,emailfieldText)) {
            if (accounttypecombo.getValue() != null) {
                if (accounttypecombo.getValue().equals("Admin")) {
                    boolean b = logginServiceImpl.saveAdmin(new AdminDTO(0, usernamefieldText, passwordfiledText, emailfieldText));
                    if (b) {
                        oncanselClick(event);
                    } else {
                        new Alert(Alert.AlertType.ERROR).show();
                        oncanselClick(event);
                    }
                } else if (accounttypecombo.getValue().equals("User")) {
                    boolean b = logginServiceImpl.saveUser(new UserDTO(0, usernamefieldText, passwordfiledText, emailfieldText));
                    if (b) {
                        oncanselClick(event);
                    } else {
                        new Alert(Alert.AlertType.ERROR).show();
                        oncanselClick(event);
                    }
                } else {
                    boolean b = logginServiceImpl.saveUser(new UserDTO(0, usernamefieldText, passwordfiledText, emailfieldText));
                    if (b) {
                        oncanselClick(event);
                    } else {
                        new Alert(Alert.AlertType.ERROR).show();
                        oncanselClick(event);
                    }
                }
            } else {
                boolean b = logginServiceImpl.saveUser(new UserDTO(0, usernamefieldText, passwordfiledText, emailfieldText));
                if (b) {
                    oncanselClick(event);
                } else {
                    new Alert(Alert.AlertType.ERROR).show();
                    oncanselClick(event);
                }
            }
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    private boolean checkFields(String usernamefieldText, String passwordfiledText, String emailfieldText) {
        if (usernamefieldText != null && passwordfiledText != null && emailfieldText != null){
            if (Pattern.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\n",emailfieldText)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @FXML
    void oncanselClick(ActionEvent event) {
        Stage stage = (Stage) passwordfiled.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> observableList = FXCollections.observableArrayList("Admin","User");
        accounttypecombo.setItems(observableList);
        if (type.equals("a")){
            mainLabel.setText("Add Admin");
        }else {
            mainLabel.setText("Add User");
            accounttypecombo.setDisable(true);
        }
    }
}
