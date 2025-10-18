package com.example.sudokupoe.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ventana principal del juego Sudoku que implementa el patrón Singleton.
 * Se encarga de cargar y mostrar la interfaz gráfica del juego desde un archivo FXML.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class SudokuView extends Stage {

    /**
     * Constructor que inicializa la ventana del Sudoku.
     * Carga la interfaz desde el archivo FXML y configura la escena.
     *
     * @throws IOException Si no puede cargar el archivo FXML
     */
    public SudokuView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/sudokupoe/SudokuView.fxml")
        );
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setTitle("sudoku game");

    }

    /**
     * Obtiene la instancia única de SudokuView (patrón Singleton).
     *
     * @return Instancia única de SudokuView
     * @throws IOException Si hay error al crear la instancia
     */
    public static SudokuView getInstance() throws IOException {
        if (SudokuHolder.INSTANCE == null) {
            SudokuHolder.INSTANCE = new SudokuView();
        }
        return SudokuHolder.INSTANCE;
    }

    /**
     * Clase holder para la instancia Singleton.
     */
    private static class SudokuHolder {
        private static SudokuView INSTANCE = null;
    }
}
