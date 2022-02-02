package com.project.crawler.Controllers;

import com.project.crawler.SQL.ConnectionClass;
import com.project.crawler.SQL.Helper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
            URL url = new File("src/main/resources/com/project/crawler/progress.fxml").toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle("wait");
            stage.setScene(new Scene(root, 380, 515));


            String string = words.getText();
            List<String> strings = Helper.stringToList(string);
            System.out.println(Helper.listToSQL(strings));
            ConnectionClass.getConnection(Helper.listToSQL(strings));

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize(){

    }




}
