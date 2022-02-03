package com.project.crawler.Controllers;

import com.project.crawler.SQL.ConnectionClass;
import com.project.crawler.SQL.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Controller {




    @FXML
    private TextField breadth;

    @FXML
    private TextField depth;

    @FXML
    private CheckBox full;

    @FXML
    private Button go;

    @FXML
    private CheckBox top;

    @FXML
    private TextField url;

    @FXML
    private TextField words;


    @FXML
    void go(ActionEvent actionEvent){
        try{
            URL urlx = new File("src/main/resources/com/project/crawler/open-folder.fxml").toURL();
            Parent root = FXMLLoader.load(urlx);
            Stage stage = new Stage();
            stage.setTitle("wait");
            stage.setScene(new Scene(root, 380, 515));

            int dep = 0;
            dep = Integer.parseInt(depth.getText());
            if(dep == 0) dep = 8;
            int bread = 0;
            bread = Integer.parseInt(breadth.getText());
            if(bread == 0) bread =10000;
            String string = words.getText();
            String urlSite = url.getText();
            boolean topB = top.isManaged();
            boolean fullB = full.isManaged();
            List<String> strings = Helper.stringToList(string);
            ConnectionClass.getConnection(dep, bread, topB, fullB, urlSite, strings);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize(){

    }






}
