package lk.ijse.librarymanagementsystem.controller.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.librarymanagementsystem.dao.UserBookDetail;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.impl.BookServiceImpl;
import lk.ijse.librarymanagementsystem.service.impl.BorrowingDetailsServiceImpl;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookOBJformController implements Initializable {

    @FXML
    private ImageView addIcon;
    public static int userID;


    @FXML
    private Label authorfield;

    @FXML
    private ImageView imageview;

    @FXML
    private Label titleField;
    public static int x;
   public  static ArrayList<BookDTO> allBooks = null;
    String status ;
    int id;

    UserBookDetail userBookDetail = new UserBookDetail();

    @FXML
    void onAddIconClick(MouseEvent event) {
        status = "Booked";
        String bdate = String.valueOf(LocalDate.now());
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(10);
        String dueDate = String.valueOf(localDate);
        boolean b2 = userBookDetail.bookBook(id,status,new BorrowingDetailDTO(0, bdate, dueDate,"Not Returned", userID, id));
         if (b2){
            new Alert(Alert.AlertType.INFORMATION,"Book booked!!").show();
        }
    }

    @FXML
    void mouseEnter(MouseEvent event) {
        if (status.equals("Available")){
            addIcon.setVisible(true);
        }
    }

    @FXML
    void mouseExit(MouseEvent event) {
        addIcon.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValues();
        addIcon.setVisible(false);
    }

    private void setValues() {
        if (allBooks.get(x).getUrl() != null){
            imageview.setImage(new Image(allBooks.get(x).getUrl()));
        }
        status = allBooks.get(x).getStatus();
        id = allBooks.get(x).getId();
        titleField.setText(allBooks.get(x).getTitle());
        authorfield.setText(allBooks.get(x).getAuthor());
    }
}
