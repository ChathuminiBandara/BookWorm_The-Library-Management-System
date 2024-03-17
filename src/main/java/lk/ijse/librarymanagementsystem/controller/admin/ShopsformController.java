package lk.ijse.librarymanagementsystem.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.ShopDTO;
import lk.ijse.librarymanagementsystem.dto.tm.ShopsTM;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.impl.ShopServiceImpl;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.security.Provider;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShopsformController implements Initializable {

    @FXML
    private TableColumn<ShopsTM, String> addresscolumn;

    @FXML
    private TableColumn<ShopsTM, String> citycolumn;

    @FXML
    private TableColumn<ShopsTM, JFXButton> deletecolumn;

    @FXML
    private TableColumn<ShopsTM, String> idcolumn;

    @FXML
    private TableColumn<ShopsTM, String> namecolumn;

    @FXML
    private TableColumn<ShopsTM, String> poscodecolumn;

    @FXML
    private TableView<ShopsTM> table;

    @FXML
    private TableColumn<ShopsTM, JFXButton> updatecolumn;

    @FXML
    private AnchorPane pane;

    ShopServiceImpl service = (ShopServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.SHOPService);

    @SneakyThrows
    @FXML
    void onAddBookClick(ActionEvent event) {
        Stage stage = new Stage();
        addShopformController.anchorPane = pane;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/addshop.fxml"))));
        stage.setResizable(false);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumns();
        loadValues();
    }

    private void loadValues() {
        ArrayList<ShopDTO> allShops = service.getAllShops();
        ObservableList<ShopsTM> observableList = FXCollections.observableArrayList();
        for (ShopDTO s : allShops){
            observableList.add(new ShopsTM(String.valueOf(s.getId()),s.getName(),s.getCity(),s.getAddress(),s.getPostalCode(),new JFXButton("Update"),new JFXButton("Delete")));
        }
        table.setItems(observableList);
        for (int i = 0; i < observableList.size(); i++) {
            int id = Integer.parseInt(observableList.get(i).getId());
            observableList.get(i).getUpdate().setStyle("-fx-background-color: rgba(124, 1, 1, 1);-fx-text-fill: White;");
            observableList.get(i).getDelete().setStyle("-fx-background-color: rgba(0, 40, 118, 1);-fx-text-fill: White;");
            observableList.get(i).getDelete().setOnAction(event -> {
                boolean b = service.deleteShop(id);
                pane.getChildren().clear();
                try {
                    pane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/admin/shops.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void setColumns() {
        idcolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("id"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("name"));
        citycolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("city"));
        addresscolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("address"));
        poscodecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,String>("postalCode"));
        updatecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,JFXButton>("update"));
        deletecolumn.setCellValueFactory(new PropertyValueFactory<ShopsTM,JFXButton>("delete"));
    }
}
