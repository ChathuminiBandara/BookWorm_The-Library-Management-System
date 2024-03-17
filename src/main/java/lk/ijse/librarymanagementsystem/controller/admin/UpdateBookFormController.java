package lk.ijse.librarymanagementsystem.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.impl.BookServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateBookFormController implements Initializable {
    public static int bid;
    public static String booktitle;
    public static String author;
    public static String genrer;
    public static String  status;
    public static String url;
    public static AnchorPane pane;
    @FXML
    private TextField authorNamefield;

    @FXML
    private TextField bookTitleField;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXComboBox<String> selectGenreCombo;

    BookServiceImpl bookService = (BookServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOKService);

    @FXML
    void canselClick(ActionEvent event) {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onSaveClick(ActionEvent event) throws IOException {
        String authorNamefieldText = authorNamefield.getText();
        String bookTitleFieldText = bookTitleField.getText();
        String genreComboValue = selectGenreCombo.getValue();
        BookDTO bookDTO = new BookDTO(bid, bookTitleFieldText, authorNamefieldText, genreComboValue, status, url);
        boolean b = bookService.updateBook(bookDTO);
        if (b){
            pane.getChildren().clear();
            pane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/admin/books.fxml")));
            canselClick(event);

        }else {
            new Alert(Alert.AlertType.ERROR,"Error ekk wutto").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList observableList = FXCollections.observableArrayList("Historical","Novel","Education","Children");
        selectGenreCombo.setItems(observableList);
        bookTitleField.setText(booktitle);
        authorNamefield.setText(author);
        selectGenreCombo.setValue(genrer);
    }
}
