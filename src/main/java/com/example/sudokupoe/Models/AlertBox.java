package com.example.sudokupoe.Models;

import javafx.scene.control.Alert;

/**
 * Implementación de la interfaz IAlertBox para mostrar alertas en JavaFX.
 * Proporciona diferentes tipos de ventanas de diálogo para diversas situaciones del juego.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class AlertBox implements  IAlertBox{

    /**
     * Muestra una alerta de error con icono de error.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje de error detallado
     */
    @Override
    public void alertBoxError(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText("Error en el Sudoku");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra una alerta informativa cuando el juego se completa exitosamente.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje de felicitación al usuario
     */
    @Override
    public void alertBoxJuegoCompleto(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText("¡Felicidades!");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra una alerta con información sobre pistas del juego.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje informativo sobre la pista
     */
    @Override
    public void alertBoxPista(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText("Pista");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra una alerta de confirmación para iniciar un nuevo juego.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje de confirmación para nuevo juego
     */
    @Override
    public void alertBoxNuevoJuego(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText("Nuevo Juego");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
