package lk.ijse.controller.O;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.tm.ItemTm;


import java.sql.SQLException;
import java.util.List;

public class ItemFormController {
    @FXML
    private TableView<ItemTm> tblItem;
    @FXML
    private TableColumn<?, ?> colAction;
    @FXML
    private TableColumn<?, ?> colCode;
    @FXML
    private TableColumn<?, ?> colDescription;
    @FXML
    private TableColumn<?, ?> colUnitPrice;
    @FXML
    private TableColumn<?, ?> colQtyOnHand;
    public AnchorPane root;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtQtyOnHand;
    @FXML
    private TextField txtUnitPrice;
    private ItemModel itemModel = new ItemModel();

    public void initialize() {
        setCellValueFactory();
        loadAllItems();
        tableListener();
    }

    private void tableListener() {
        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(ItemTm row) {
        txtCode.setText(row.getCode());
        txtDescription.setText(row.getDescription());
        txtUnitPrice.setText(String.valueOf(row.getUnitPrice()));
        txtQtyOnHand.setText(String.valueOf(row.getQtyOnHand()));
    }

    private void setCellValueFactory() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (validateFields()) {
            String code = txtCode.getText();
            String description = txtDescription.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

            var dto = new ItemDto(code, description, unitPrice, qtyOnHand);

            try {
                boolean isSaved = itemModel.saveItem(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
                    clearFields();
                    loadAllItems(); // Reload the table after saving
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    private boolean validateFields() {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        String unitPriceText = txtUnitPrice.getText();
        String qtyOnHandText = txtQtyOnHand.getText();

        if (code.isEmpty() || description.isEmpty() || unitPriceText.isEmpty() || qtyOnHandText.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
            return false;
        }

        try {
            double unitPrice = Double.parseDouble(unitPriceText);
            int qtyOnHand = Integer.parseInt(qtyOnHandText);

            if (unitPrice < 0 || qtyOnHand < 0) {
                new Alert(Alert.AlertType.ERROR, "Unit Price and Qty on Hand must be non-negative").show();
                return false;
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid numeric values").show();
            return false;
        }

        return true;
    }

    private void loadAllItems() {
        ObservableList<ItemTm> obList = FXCollections.observableArrayList();
        try {
            List<ItemDto> dtoList = itemModel.loadAllItems();

            for (ItemDto dto : dtoList) {
                obList.add(new ItemTm(
                        dto.getCode(),
                        dto.getDescription(),
                        dto.getQtyOnHand(),
                        dto.getUnitPrice(),
                        new Button("Delete")
                ));
            }
            tblItem.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /* @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String code = txtCode.getText();
        try {
            boolean isDeleted = itemModel.deleteItem(code);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item deleted!").show();
                loadAllItems(); // Reload the table after deleting
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Item not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }*/

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validateFields()) {
            String code = txtCode.getText();
            String description = txtDescription.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

            try {
                boolean isUpdated = itemModel.updateItem(new ItemDto(code, description, unitPrice, qtyOnHand));
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item updated").show();
                    clearFields();
                    loadAllItems(); // Reload the table after updating
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void codeSearchOnAction(ActionEvent event) {
        String code = txtCode.getText();
        try {
            ItemDto dto = itemModel.searchItem(code);
            if (dto != null) {
                setFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Item not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtCode.setText("");
        txtDescription.setText("");
        txtUnitPrice.setText("");
        txtQtyOnHand.setText("");
    }

    private void setFields(ItemDto dto) {
        txtCode.setText(dto.getCode());
        txtDescription.setText(dto.getDescription());
        txtUnitPrice.setText(String.valueOf(dto.getUnitPrice()));
        txtQtyOnHand.setText(String.valueOf(dto.getQtyOnHand()));
    }



    public void btnBackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}