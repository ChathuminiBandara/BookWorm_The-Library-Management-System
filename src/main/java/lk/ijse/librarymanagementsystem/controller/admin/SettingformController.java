package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class SettingformController {

    @FXML
    private AnchorPane pane;

    @SneakyThrows
    @FXML
    void adminAddbtnClick(ActionEvent event) {
        Stage stage = new Stage();
        AddAdminformController.type = "a";
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/AddAdmin.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @SneakyThrows
    @FXML
    void changeAccpasswordbtnClick(ActionEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/passwordChange.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @SneakyThrows
    @FXML
    void userAddbtnClick(ActionEvent event) {
        Stage stage = new Stage();
        AddAdminformController.type = "u";
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/AddAdmin.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @SneakyThrows
    @FXML
    void userBlackListbtnClick(ActionEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/blacklistUsers.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

}
