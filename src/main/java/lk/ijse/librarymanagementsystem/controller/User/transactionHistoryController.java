package lk.ijse.librarymanagementsystem.controller.User;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.librarymanagementsystem.dto.tm.TransactionTM;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.impl.BorrowingDetailsServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class transactionHistoryController implements Initializable {

    @FXML
    private TableColumn<TransactionTM, Integer> bidcolumn;

    @FXML
    private TableColumn<TransactionTM, String> dueDatecolumn;

    @FXML
    private TableColumn<TransactionTM, String> getDatecolumn;

    @FXML
    private TableColumn<TransactionTM, Integer> idcolumn;

    @FXML
    private TableView<TransactionTM> table;

    @FXML
    private TableColumn<TransactionTM, String> titlecolumn;
    public static int id;
    BorrowingDetailsServiceImpl borrowingDetailsServiceImpl = (BorrowingDetailsServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BORROWINGDETAILService);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumns();
        loadValues();
    }

    private void loadValues() {
        List<BorrowingDetails> details = borrowingDetailsServiceImpl.getDetails(id);
        ObservableList<TransactionTM> observableList = FXCollections.observableArrayList();
        for (BorrowingDetails b : details){
            if (b.getStatus().equals("Returned")) {
                observableList.add(new TransactionTM(b.getId(), b.getUser().getId(), b.getBook().getId(), b.getBook().getTitle(), b.getBorrowingDate(), b.getDueDate(), new JFXButton("Return")));
            }

        }
        table.setItems(observableList);
    }

    private void setColumns() {
        idcolumn.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("transID"));
        bidcolumn.setCellValueFactory(new PropertyValueFactory<TransactionTM,Integer>("bookId"));
        titlecolumn.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("bookTitle"));
        getDatecolumn.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("getDate"));
        dueDatecolumn.setCellValueFactory(new PropertyValueFactory<TransactionTM,String>("dueDate"));
    }
}
