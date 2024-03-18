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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.bo.impl.BookBOImpl;
import lombok.SneakyThrows;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class addBookformController implements Initializable {
    public static AnchorPane anchorPane;

    @FXML
    private TextField authorNamefield;

    @FXML
    private TextField bookTitleField;

    @FXML
    private ImageView imageView;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXComboBox<String> selectGenreCombo;
    String imagePath = null;

    BookBOImpl bookServiceImpl = new BookBOImpl();

    @FXML
    void canselClick(ActionEvent event) {

    }

    @FXML
    void onAddImageClick(MouseEvent event) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image file");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imagePath = file.getPath();
            imageView.setImage(image);
        }
    }
    private void closeUI(){
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
    @SneakyThrows
    @FXML
    void onSaveClick(ActionEvent event) {
        boolean b = bookServiceImpl.saveBook(new BookDTO(0, bookTitleField.getText(),
                authorNamefield.getText(), selectGenreCombo.getValue(), "Available", imagePath));
        if (b){
            closeUI();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/admin/books.fxml")));
        }else {
            new Alert(Alert.AlertType.ERROR,"Cant save book Detail!!!!").show();
             closeUI();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList observableList = FXCollections.observableArrayList("Historical","Novel","Education","Children");
        selectGenreCombo.setItems(observableList);
    }
}
