package com.example.sudokupoe;

import com.example.sudokupoe.Views.StartView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainProyecto extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StartView startView = StartView.getInstance();
        startView.show();
    }
}
