package com.example.sudokupoe;

import com.example.sudokupoe.Views.StartView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Método principal de inicio de JavaFX que configura y muestra la ventana inicial.
 * patrón Singleton para obtener la instancia de StartView y mostrarla.
 *
 * @throws IOException Si ocurre un error al cargar la vista inicial
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class MainProyecto extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StartView startView = StartView.getInstance();
        startView.show();
    }
}
