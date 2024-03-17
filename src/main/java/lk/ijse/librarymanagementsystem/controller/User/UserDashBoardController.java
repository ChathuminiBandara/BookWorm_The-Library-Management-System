package lk.ijse.librarymanagementsystem.controller.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.controller.passwordCHangeController;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDashBoardController implements Initializable {

    @FXML
    private AnchorPane ancpane;

    @FXML
    private AnchorPane booksPane;

    @FXML
    private AnchorPane transactionpane;
    @SneakyThrows
    @FXML
    void onpasswordCHangeCLick(ActionEvent event) {
        Stage stage = new Stage();
        passwordCHangeController.type = "u";
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/passwordChange.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onBookManageCLick(ActionEvent event) {
        btnCLR(booksPane);
        navigateUI("/view/user/userMainform.fxml");
    }
    @FXML
    void ontransactionManageClick(ActionEvent event) {
        btnCLR(transactionpane);
        navigateUI("/view/user/transactionform.fxml");

    }

    @SneakyThrows
    @FXML
    void onlogoutClick(ActionEvent event) {
        Stage stage = (Stage) booksPane.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/loginpage.fxml"))));
        stage1.setResizable(false);
        stage1.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navigateUI("/view/user/userMainform.fxml");
        btnCLR(booksPane);
    }

    private void btnCLR(AnchorPane pane) {
        removeClr();
        pane.setStyle("-fx-background-color: black");
    }

    private void removeClr() {
        booksPane.setStyle("-fx-background-color: white");
        transactionpane.setStyle("-fx-background-color: white");
    }

    @SneakyThrows
    private void navigateUI(String url) {
        ancpane.getChildren().clear();
        ancpane.getChildren().add(FXMLLoader.load(getClass().getResource(url)));
    }
}
