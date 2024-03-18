package lk.ijse.librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import org.hibernate.Session;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/loginpage.fxml"))));
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }
}
