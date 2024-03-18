package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.librarymanagementsystem.dao.JoinDAOImpl;
import lk.ijse.librarymanagementsystem.tm.BlackListTM;

import java.net.URL;
import java.util.*;

public class BlackListUsersformController implements Initializable {

    @FXML
    private TableColumn<BlackListTM, String> BookTitleFIeld;

    @FXML
    private TableColumn<BlackListTM, String> BoookIdField;

    @FXML
    private TableColumn<BlackListTM, String> DueDateFiled;

    @FXML
    private TableColumn<BlackListTM, String> UserEmailFIeld;

    @FXML
    private TableColumn<BlackListTM, String> UsernameField;

    @FXML
    private TableView<BlackListTM> table;

    @FXML
    private TableColumn<BlackListTM, String> transIdField;

    @FXML
    private TableColumn<BlackListTM, String> userIdFiled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColmValues();
        loadValues();
    }

    private void loadValues() {
        JoinDAOImpl joinDAO = new JoinDAOImpl();
        List<Object[]> blackListUsers = joinDAO.getBlackListUsers();
        ObservableList<BlackListTM> observableList =FXCollections.observableArrayList();
        for (Object[] array : blackListUsers){
            observableList.add(new BlackListTM(String.valueOf(array[0]),String.valueOf(array[1]),String.valueOf(array[2]),String.valueOf(array[3]),String.valueOf(array[4]),String.valueOf(array[5]),String.valueOf(array[6])));
        }
        table.setItems(observableList);
    }

    private void setColmValues() {
        transIdField.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("transID"));
        DueDateFiled.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("dueDate"));
        BoookIdField.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("BookId"));
        BookTitleFIeld.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("booktitle"));
        userIdFiled.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("userId"));
        UsernameField.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("username"));
        UserEmailFIeld.setCellValueFactory(new PropertyValueFactory<BlackListTM,String>("userEmail"));
    }
}
