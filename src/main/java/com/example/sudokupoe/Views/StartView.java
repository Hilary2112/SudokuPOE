package com.example.sudokupoe.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ventana inicial de la aplicación Sudoku que implementa el patrón Singleton.
 * Se encarga de cargar y mostrar la pantalla de inicio desde un archivo FXML.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class StartView extends Stage {
    /**
     * Constructor que inicializa la ventana de inicio.
     * Carga la interfaz desde el archivo FXML y configura la escena.
     *
     * @throws IOException Si no puede cargar el archivo FXML
     */
    public  StartView()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/sudokupoe/hello-view.fxml")
        );
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setTitle("sudoku game");
    }

    /**
     * Obtiene la instancia única de StartView (patrón Singleton).
     *
     * @return Instancia única de StartView
     * @throws IOException Si hay error al crear la instancia
     */
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
