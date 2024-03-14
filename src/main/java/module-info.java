module lk.ijse.bookworm_thelibrarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.jfoenix;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires jakarta.persistence;
    requires jasperreports;

    opens lk.ijse to javafx.fxml;
    exports lk.ijse;
    exports lk.ijse.controller;
    opens lk.ijse.controller to javafx.fxml;
    exports lk.ijse.controller.my;
    opens lk.ijse.controller.my to javafx.fxml;
    exports lk.ijse.controller.O;
    opens lk.ijse.controller.O to javafx.fxml;
}