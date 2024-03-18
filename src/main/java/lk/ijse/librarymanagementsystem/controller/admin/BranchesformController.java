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
import lk.ijse.librarymanagementsystem.dto.BranchDTO;
import lk.ijse.librarymanagementsystem.tm.BranchesTM;
import lk.ijse.librarymanagementsystem.bo.ServiceBO;
import lk.ijse.librarymanagementsystem.bo.impl.BranchBOImpl;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BranchesformController implements Initializable {

    @FXML
    private TableColumn<BranchesTM, String> addresscolumn;

    @FXML
    private TableColumn<BranchesTM, String> citycolumn;

    @FXML
    private TableColumn<BranchesTM, JFXButton> deletecolumn;

    @FXML
    private TableColumn<BranchesTM, String> idcolumn;

    @FXML
    private TableColumn<BranchesTM, String> namecolumn;

    @FXML
    private TableColumn<BranchesTM, String> poscodecolumn;

    @FXML
    private TableView<BranchesTM> table;

    @FXML
    private TableColumn<BranchesTM, JFXButton> updatecolumn;

    @FXML
    private AnchorPane pane;

    BranchBOImpl service = (BranchBOImpl) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.SHOPService);

    @SneakyThrows
    @FXML
    void onAddBookClick(ActionEvent event) {
        Stage stage = new Stage();
        addBranchesformController.anchorPane = pane;
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
        ArrayList<BranchDTO> allShops = service.getAllShops();
        ObservableList<BranchesTM> observableList = FXCollections.observableArrayList();
        for (BranchDTO s : allShops){
            observableList.add(new BranchesTM(String.valueOf(s.getId()),s.getName(),s.getCity(),s.getAddress(),s.getPostalCode(),new JFXButton("Update"),new JFXButton("Delete")));
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
        idcolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,String>("id"));
        namecolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,String>("name"));
        citycolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,String>("city"));
        addresscolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,String>("address"));
        poscodecolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,String>("postalCode"));
        updatecolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,JFXButton>("update"));
        deletecolumn.setCellValueFactory(new PropertyValueFactory<BranchesTM,JFXButton>("delete"));
    }
}
