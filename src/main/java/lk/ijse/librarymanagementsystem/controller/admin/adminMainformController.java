package lk.ijse.librarymanagementsystem.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.bo.BookBO;
import lk.ijse.librarymanagementsystem.bo.LogginBO;
import lk.ijse.librarymanagementsystem.bo.ServiceBO;
import lk.ijse.librarymanagementsystem.bo.BranchBO;
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
    BookBO bookBO = (BookBO) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.BOOKService);

    LogginBO logginBO = (LogginBO) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.LOGGINService);

    BranchBO service = (BranchBO) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.SHOPService);
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
        totalbooklbl.setText(String.valueOf(bookBO.getBookCount()));
        totaluserlbl.setText(String.valueOf(logginBO.getUserCount()));
        totalshoplbl.setText(String.valueOf(service.getShopCount()));
    }
}
