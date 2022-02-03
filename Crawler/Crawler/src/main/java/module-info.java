module com.project.crawler {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.jsoup;
    requires java.desktop;

    opens com.project.crawler to javafx.fxml;
    exports com.project.crawler;
    exports com.project.crawler.Controllers;
    opens com.project.crawler.Controllers to javafx.fxml;
    exports com.project.crawler.SQL;
    opens com.project.crawler.SQL to javafx.fxml;
}