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
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.tm.BooksTM;
import lk.ijse.librarymanagementsystem.bo.impl.BookBOImpl;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BooksManageformController implements Initializable {
    @FXML
    private AnchorPane ancpane;

    @FXML
    private TableColumn<BooksTM, String> authorcolumn;

    @FXML
    private TableColumn<BooksTM, JFXButton> deletecolumn;

    @FXML
    private TableColumn<BooksTM, String> genrecolumn;

    @FXML
    private TableColumn<BooksTM, String> idcolumn;

    @FXML
    private TableColumn<BooksTM, String> statuscolumn;

    @FXML
    private TableView<BooksTM> table;

    @FXML
    private TableColumn<BooksTM, String> titlecolumn;

    @FXML
    private TableColumn<BooksTM, JFXButton> updatecolumn;

    BookBOImpl bookServiceImpl = new BookBOImpl();

    @SneakyThrows
    @FXML
    void onAddBookClick(ActionEvent event) {
        Stage stage = new Stage();
        addBookformController.anchorPane = ancpane;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/addBook.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumnValues();
        loadValues();
    }

    private void loadValues() {
        ObservableList<BooksTM> observableList = FXCollections.observableArrayList();
        for (BookDTO b : bookServiceImpl.getAllBooks()) {
            observableList.add(new BooksTM(String.valueOf(b.getId()),b.getTitle(),b.getAuthor(),b.getGenre(),b.getStatus(),b.getUrl(),new JFXButton("Update"),new JFXButton("Delete")));
        }
        table.setItems(observableList);
        for (int i = 0; i < observableList.size(); i++) {
            String id = observableList.get(i).getId();
            observableList.get(i).getUpdate().setStyle("-fx-background-color: rgba(124, 1, 1, 1);-fx-text-fill: White;");
            observableList.get(i).getDelete().setStyle("-fx-background-color: rgba(0, 40, 118, 1);-fx-text-fill: White;");
            observableList.get(i).getDelete().setOnAction(event -> {
                boolean b = bookServiceImpl.deleteBook(id);
                ancpane.getChildren().clear();
                try {
                    ancpane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/admin/books.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            String id1 = observableList.get(i).getId();
            String title = observableList.get(i).getTitle();
            String author = observableList.get(i).getAuthor();
            String genre = observableList.get(i).getGenre();
            String status = observableList.get(i).getStatus();
            String url = observableList.get(i).getUrl();
            observableList.get(i).getUpdate().setOnAction(event -> {
                Stage stage = new Stage();
                UpdateBookFormController.bid = Integer.parseInt(id1);
                UpdateBookFormController.booktitle = title;
                UpdateBookFormController.author = author;
                UpdateBookFormController.genrer = genre;
                UpdateBookFormController.url =url;
                UpdateBookFormController.status = status;
                UpdateBookFormController.pane =ancpane;
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/UpdateBook.fxml"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setResizable(false);
                stage.show();
            });
        }

    }

    private void setColumnValues() {
        idcolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,String>("id"));
        titlecolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,String>("title"));
        authorcolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,String>("author"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,String>("genre"));
        statuscolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,String>("status"));
        updatecolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,JFXButton>("update"));
        deletecolumn.setCellValueFactory(new PropertyValueFactory<BooksTM,JFXButton>("delete"));
    }
}
