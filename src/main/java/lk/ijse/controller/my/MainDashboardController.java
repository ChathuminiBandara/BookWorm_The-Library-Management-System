package lk.ijse.controller.my;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainDashboardController {
    public AnchorPane Dynamic_Anchorpane;

   public void initialize() throws IOException {
        setform("/FXML_Files/Admin_Panel.fxml");
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
        setform("/FXML_Files/Library_Loans.fxml");
    }

    public void Books_On_action(ActionEvent actionEvent) throws IOException {
        setform("/FXML_Files/Books.fxml");
    }



    public void Settings_on_action(ActionEvent actionEvent) throws IOException {
       setform("/FXML_Files/settings.fxml");
    }

    public void Members_On_action(ActionEvent actionEvent) throws IOException {
       /*setform("/FXML_Files/members.fxml");*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard_form.fxml"));
        AnchorPane anchorPane = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle("1st pane");
        newStage.setScene(new Scene(anchorPane));
        newStage.show();
    }

    public void Branches_On_action(ActionEvent actionEvent) throws IOException {
       setform("/FXML_Files/Library_Branches.fxml");
    }

    public void add_books_On_action(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML_Files/add_new_book.fxml"));
        AnchorPane anchorPane = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle("1st pane");
        newStage.setScene(new Scene(anchorPane));
        newStage.show();
    }
}