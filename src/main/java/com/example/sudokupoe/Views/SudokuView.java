package com.example.sudokupoe.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuView extends Stage {
    public SudokuView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/sudokupoe/SudokuView.fxml")
        );
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setTitle("sudoku game");

    }

    public static SudokuView getInstance() throws IOException {
        if (SudokuHolder.INSTANCE == null) {
            SudokuHolder.INSTANCE = new SudokuView();
        }
        return SudokuHolder.INSTANCE;
    }

    private static class SudokuHolder {
        private static SudokuView INSTANCE = null;
    }
}
