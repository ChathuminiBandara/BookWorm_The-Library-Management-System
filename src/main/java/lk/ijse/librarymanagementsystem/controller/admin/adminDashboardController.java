package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminDashboardController implements Initializable {

    @FXML
    private ImageView accountIcon;

    @FXML
    private AnchorPane ancpane;

    @FXML
    private AnchorPane booksPane;

    @FXML
    private AnchorPane dashBoardPane;

    @FXML
    private AnchorPane settingPane;

    @FXML
    private AnchorPane shopPane;

    @FXML
    void onAccountIconClick(MouseEvent event) {

    }

    @FXML
    void onBookManageCLick(ActionEvent event) {
        setPaneColor(booksPane);
        setDashBoard("/view/admin/books.fxml");
    }

    @FXML
    void onSettingsClick(ActionEvent event) {
        setPaneColor(settingPane);
        setDashBoard("/view/admin/settingform.fxml");
    }

    @FXML
    void onShopManageClick(ActionEvent event) {
        setPaneColor(shopPane);
        setDashBoard("/view/admin/shops.fxml");
    }

    @FXML
    void ondashBoardClick(ActionEvent event) {
        setPaneColor(dashBoardPane);
        setDashBoard("/view/admin/admindash.fxml");
    }

    @SneakyThrows
    @FXML
    void onlogoutClick(ActionEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/loginpage.fxml"))));
        stage.setResizable(false);
        stage.show();
        Stage stage1 = (Stage) settingPane.getScene().getWindow();
        stage1.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneclrChange();
        setDashBoard("/view/admin/admindash.fxml");
        setPaneColor(dashBoardPane);
    }

    private void setDashBoard(String url) {
        ancpane.getChildren().clear();
        try {
            ancpane.getChildren().add(FXMLLoader.load(getClass().getResource(url)));
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,"Cant load form!!!").show();
        }
    }

    private void setPaneColor(AnchorPane pane){
        paneclrChange();
        pane.setStyle("-fx-background-color: Black");
    }

    private void paneclrChange() {
        dashBoardPane.setStyle("-fx-background-color: white");
        booksPane.setStyle("-fx-background-color: white");
        shopPane.setStyle("-fx-background-color: white");
        settingPane.setStyle("-fx-background-color: white");
    }
}
