package lk.ijse.bookworm_thelibrarymanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Admin_Controller {
    public Pane DynamicPane;

    private void setform(String form) throws IOException {
        URL resource = this.getClass().getResource(form);
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        DynamicPane.getChildren().clear();
        DynamicPane.getChildren().add(load);

    }

    public void DashBoard_On_Action(ActionEvent actionEvent) throws IOException {
        try {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML_Files/Admin_Panel.fxml"));
            AnchorPane anchorPane = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Admin Panel");
            newStage.setScene(new Scene(anchorPane));
            currentStage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Library_Loan_On_action(ActionEvent actionEvent) throws IOException {
        setform("/FXML_Files/Library_Loans.fxml");
    }

    public void Books_On_action(ActionEvent actionEvent) {
    }

    public void Members_On_action(ActionEvent actionEvent) {
    }

    public void Help_On_action(ActionEvent actionEvent) {
    }

    public void Settings_on_action(ActionEvent actionEvent) {
    }


}
