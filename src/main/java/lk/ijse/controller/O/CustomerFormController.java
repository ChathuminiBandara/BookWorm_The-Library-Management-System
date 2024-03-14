package lk.ijse.controller.O;


import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.tm.CustomerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerFormController {
    public AnchorPane root;
    public JFXButton btnupdate;
    public JFXButton btndelete;
    public JFXButton clearbtn;
    public JFXButton btnsave;
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<CustomerTm> tblCustomer;
    private CustomerModel cusModel = new CustomerModel();


    //CustomerBO customerBO = new CustomerBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
    }

    private boolean validateCustomer(){
        String id = txtId.getText();
        Pattern compile = Pattern.compile("\\d{10}");
        Matcher matcher = compile.matcher(id);
        boolean matches =matcher.matches();
        if(!matches){
            new Alert(Alert.AlertType.ERROR, "Invalid Customer ID!").show();
            return false;
        }
        String name = txtName.getText();
        Pattern compile1 = Pattern.compile("[a-zA-Z]+");
        Matcher matcher1 = compile1.matcher(name);
        boolean matches1 =matcher1.matches();
        if(!matches1){
            new Alert(Alert.AlertType.ERROR, "Invalid Customer Name!").show();
            return false;
        }
        String address = txtAddress.getText();
        Pattern compile2 = Pattern.compile("[a-zA-Z]+");
        Matcher matcher2 = compile2.matcher(address);
        boolean matches2 =matcher2.matches();
        if(!matches2){
            new Alert(Alert.AlertType.ERROR, "Invalid Customer Address!").show();
            return false;
        }
        String tel = txtTel.getText();
        Pattern compile3 = Pattern.compile("\\d{10}");
        Matcher matcher3 = compile3.matcher(tel);
        boolean matches3 =matcher3.matches();
        if(!matches3){
            new Alert(Alert.AlertType.ERROR, "Invalid Customer Tel!").show();
            return false;
        }

        return true;
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        if(!validateCustomer()){
            new Alert(Alert.AlertType.INFORMATION, "Customer Saved Successfully !").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Customer Not  Saved  !").show();
            // printCustomer();
        }

        var dto = new CustomerDto(id, name, address, tel);

        try {
            boolean isSaved = cusModel.saveCustomer(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
//
//    void printCustomer(ActionEvent event ){
//        InputStream resaourceAsStream = getClass().getResourceAsStream("/lk/ijse/thogakade/view/CustomerForm.fxml");
//    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadAllCustomer() {
        var model = new CustomerModel();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = model.getAllCustomer();

            for (CustomerDto dto : dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTel()
                        )
                );
            }

            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

//        var model = new CustomerModel();
        try {
            boolean isDeleted = cusModel.deleteCustomer(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "customer not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        var dto = new CustomerDto(id, name, address, tel);

//        var model = new CustomerModel();
        try {
            boolean isUpdated = cusModel.updateCustomer(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

//        var model = new CustomerModel();
        try {
            CustomerDto customerDto = cusModel.searchCustomer(id);
//            System.out.println(customerDto);
            if (customerDto != null) {
                txtId.setText(customerDto.getId());
                txtName.setText(customerDto.getName());
                txtAddress.setText(customerDto.getAddress());
                txtTel.setText(customerDto.getTel());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    public void backOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}

