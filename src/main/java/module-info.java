module lk.ijse.bookworm_thelibrarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.jfoenix;

    opens lk.ijse.bookworm_thelibrarymanagementsystem to javafx.fxml;
    exports lk.ijse.bookworm_thelibrarymanagementsystem;
    exports lk.ijse.bookworm_thelibrarymanagementsystem.controller;
    opens lk.ijse.bookworm_thelibrarymanagementsystem.controller to javafx.fxml;
}