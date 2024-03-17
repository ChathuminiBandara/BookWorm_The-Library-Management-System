package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.dao.BookDAO;
import lk.ijse.librarymanagementsystem.service.BookService;
import lk.ijse.librarymanagementsystem.service.LogginService;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;
import lk.ijse.librarymanagementsystem.service.ShopService;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ResourceBundle;

public class adminMainformController implements Initializable {

    @FXML
    private Label totalbooklbl;

    @FXML
    private Label totalshoplbl;

    @FXML
    private Label totaluserlbl;
    BookService bookService = (BookService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOKService);

    LogginService logginService = (LogginService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.LOGGINService);

    ShopService service = (ShopService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.SHOPService);
    @SneakyThrows
    @FXML
    void onAddAdminClick(MouseEvent event) {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin/AddAdmin.fxml"))));
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalbooklbl.setText(String.valueOf(bookService.getBookCount()));
        totaluserlbl.setText(String.valueOf(logginService.getUserCount()));
        totalshoplbl.setText(String.valueOf(service.getShopCount()));
    }
}
