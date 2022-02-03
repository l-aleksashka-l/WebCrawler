package com.project.crawler.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFolderController {

    @FXML
    private AnchorPane myProgressBar;

    @FXML
    private Button open;

    @FXML
    void open(ActionEvent actionEvent){
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            assert desktop != null;
            desktop.open(new File("D:\\Download\\Projects\\WebCrawler\\Crawler\\Crawler\\target\\test\\full.csv"));
            desktop.open(new File("D:\\Download\\Projects\\WebCrawler\\Crawler\\Crawler\\target\\test\\top.csv"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
