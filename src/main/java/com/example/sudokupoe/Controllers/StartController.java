package com.example.sudokupoe.Controllers;

import com.example.sudokupoe.Views.SudokuView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    private Button JugarBoton;

    @FXML
    void OnActionBotonInicioJuego(ActionEvent event) throws IOException {
        SudokuView sudokuView = SudokuView.getInstance();
        sudokuView.show();

        // Close stage
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();

    }

}
