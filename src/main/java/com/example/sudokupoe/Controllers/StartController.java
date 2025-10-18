package com.example.sudokupoe.Controllers;

import com.example.sudokupoe.Views.SudokuView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador para la pantalla de inicio del juego Sudoku.
 * Maneja la transición desde la pantalla inicial al juego principal.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class StartController {

    /**
     * Botón para iniciar el juego desde la pantalla de inicio.
     */
    @FXML
    private Button JugarBoton;

    /**
     * Maneja el evento del botón "Jugar" en la pantalla de inicio.
     * Abre la ventana principal del Sudoku y cierra la ventana actual.
     *
     * @param event Evento de acción del botón
     * @throws IOException Si ocurre un error al cargar la vista del Sudoku
     */
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
