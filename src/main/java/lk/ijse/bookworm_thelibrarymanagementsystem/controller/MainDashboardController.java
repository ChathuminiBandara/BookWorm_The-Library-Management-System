package lk.ijse.bookworm_thelibrarymanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class MainDashboardController {
    public AnchorPane Dynamic_Anchorpane;

    public void initialize() throws IOException {
        setform("/FXML_Files/Main_Dashboard.fxml");
    }
    private void setform(String form) throws IOException {
        URL resource = this.getClass().getResource(form);
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        Dynamic_Anchorpane.getChildren().clear();
        Dynamic_Anchorpane.getChildren().add(load);

    }

    public void DashBoard_On_Action(ActionEvent actionEvent) throws IOException {
        setform("/FXML_Files/Admin_Panel.fxml");
    }

    public void Library_Loan_On_action(ActionEvent actionEvent) throws IOException {
        setform("/FXML_Files/Library_loans");
    }

    public void Books_On_action(ActionEvent actionEvent) throws IOException {
        setform("/FXML_Files/Books.fxml");
    }

    public void Help_On_action(ActionEvent actionEvent) {
        /*setform("/FXML_files/");*/
    }

    public void Settings_on_action(ActionEvent actionEvent) {
    }

    public void Members_On_action(ActionEvent actionEvent) {
    }
}
