package com.project.crawler.Controllers;


import com.project.crawler.SQL.Helper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ProgressController {

    @FXML
    private AnchorPane myProgressBar;

    @FXML
    private ProgressBar progress;

    LoadingScreen loadingScreen;

    @FXML
    void initialize() {
        loadingScreen = new LoadingScreen(progress);
        Thread thread = new Thread(loadingScreen);
        thread.start();
    }

    public class LoadingScreen implements Runnable {

        ProgressBar progress;


        public LoadingScreen(ProgressBar progress) {
            this.progress = progress;

        }

        @Override
        public void run() {
            while (progress.getProgress() <= 1) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        progress.setProgress(progress.getProgress() + 0.01);   //МЕНЯТЬ ТУТ!!!!!
                    }
                });
                synchronized (this) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }


        }
    }
}

