package lk.ijse.librarymanagementsystem.controller.User;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.impl.BookServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class userMailFormController implements Initializable {


    @FXML
    private GridPane gridpane;

    BookServiceImpl bookServiceImpl = (BookServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOKService);
    @FXML
    private JFXComboBox<String> combo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combo.setValue("");
        setGripPane(bookServiceImpl.getAllBooks());
        comboSetItem();

    }

    private void comboSetItem() {
        ObservableList observableList = FXCollections.observableArrayList("All","Historical","Novel","Education","Children");
        combo.setItems(observableList);
    }

    @FXML
    void selectinggenreCombo(ActionEvent event) {
        String value = combo.getValue();
        if (value.equals("All")){
            setGripPane(bookServiceImpl.getAllBooks());
        }else {
            setGripPane(bookServiceImpl.getBooksFilterWithGenre(value));
        }
    }

    private void setGripPane(ArrayList<BookDTO> allBooks) {
        gridpane.getChildren().clear();
        int colomn = 0;
        int row = 0;
        for (int i = 0; i < allBooks.size(); i++) {
            try {
                BookOBJformController.x = i ;
                BookOBJformController.allBooks =allBooks;
                Parent parent = FXMLLoader.load(getClass().getResource("/view/user/bookOBJ.fxml"));
                gridpane.add(parent, colomn, row++);

                GridPane.setMargin(parent, new Insets(5,5,5,5));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
