package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dto.bookDto;
import lk.ijse.dto.tm.bookTm;
import lk.ijse.model.bookModel;

import java.sql.SQLException;
import java.util.List;

public class add_new_book {
    public TextField book_name;
    public TextField author;
    public TextField released_year;
    public TextField id;
    public TextField stock_book_count;

    public TableColumn<?,?> name;
    public TableColumn<?,?> authortable;
    public TableColumn<?,?> year;
    public TableColumn<?,?> id1;
    public TableColumn<?,?> book_count;
    public TableView<bookTm> book_tabel;

    public void initialize() {
        setCellValueFactory();
        loadAllBook();
    }
    private bookModel bookModel = new bookModel();

    private void setCellValueFactory() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        authortable.setCellValueFactory(new PropertyValueFactory<>("author"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        book_count.setCellValueFactory(new PropertyValueFactory<>("count"));
    }

    private void loadAllBook() {
        var model = new bookModel();

        ObservableList<bookTm> obList = FXCollections.observableArrayList();

        try {
            List<bookDto> dtoList = model.getAllBook();

            for (bookDto dto : dtoList) {
                obList.add(
                        new bookTm(
                                dto.getName(),
                                dto.getAuthor(),
                                dto.getYear(),
                                dto.getId(),
                                dto.getCount()
                        )
                );
            }

            book_tabel.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add_book_on_action(ActionEvent actionEvent) {
        String name = book_name.getText();
        String author1 = author.getText();
        String year = released_year.getText();
        String Id = id.getText();
        String count = stock_book_count.getText();

        var dto = new bookDto(name, author1, year,Id, count);

        try {
            boolean isSaved = bookModel.saveBook(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "boook saved!").show();
                /*clearFields();*/
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void delete_book_on_action(ActionEvent actionEvent) {
        String name = book_name.getText();

        try {
            boolean isDeleted = bookModel.deleteBook(name);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "book deleted!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "book not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void update_book_on_action(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "book updated!").show();
        String name = book_name.getText();
        String author1 = author.getText();
        String year = released_year.getText();
        String Id = id.getText();
        String count = stock_book_count.getText();



        var dto = new bookDto(name, author1, year, Id, count);

//        var model = new CustomerModel();
        try {
            boolean isUpdated = bookModel.updateBook(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "book updated!").show();
                /*clearFields();*/
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
