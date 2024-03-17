package lk.ijse.librarymanagementsystem.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.ShopDTO;
import lk.ijse.librarymanagementsystem.service.impl.ShopServiceImpl;
import lombok.SneakyThrows;

import java.util.regex.Pattern;

public class addShopformController {

    @FXML
    private TextField addressfield;

    @FXML
    private TextField cityfield;

    @FXML
    private TextField postalcodefield;

    @FXML
    private JFXButton saveButton;

    @FXML
    private TextField shopnameField;
    public static AnchorPane anchorPane;

    ShopServiceImpl service = new ShopServiceImpl();

    @FXML
    void canselClick(ActionEvent event) {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @SneakyThrows
    @FXML
    void onSaveClick(ActionEvent event) {
        if (service.saveShop(new ShopDTO(0, shopnameField.getText(), cityfield.getText(), addressfield.getText(), postalcodefield.getText()))) {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/admin/shops.fxml")));
            canselClick(event);
        } else {
            canselClick(event);
            new Alert(Alert.AlertType.ERROR, "Cant save").show();
        }
    }

}
