package com.example.sudokupoe.Models;

import javafx.scene.control.Alert;

public class AlertBox implements  IAlertBox{
    @Override
    public void alertBoxError(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText("Error en el Sudoku");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @Override
    public void alertBoxJuegoCompleto(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText("¡Felicidades!");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @Override
    public void alertBoxPista(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText("Pista");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @Override
    public void alertBoxNuevoJuego(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText("Nuevo Juego");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
