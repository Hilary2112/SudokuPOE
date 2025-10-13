package com.example.sudokupoe.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView extends Stage {
    public  StartView()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/sudokupoe/hello-view.fxml")
        );
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setTitle("sudoku game");
    }

    public static StartView getInstance() throws IOException {
        if (StartView.StarViewHolder.INSTANCE == null) {
            StarViewHolder.INSTANCE = new StartView();
        }
        return StartView.StarViewHolder.INSTANCE;
    }

    private static class StarViewHolder {
        private static StartView INSTANCE = null;
    }
}
