package com.example.sudokupoe.Models;

import javafx.animation.PauseTransition;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * Manejador de eventos de mouse para celdas del Sudoku.
 * Proporciona feedback visual cuando el usuario hace clic en una celda.
 * Resalta temporalmente la celda seleccionada con color y borde.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class MouseHandler extends  MouseAdapter{

    /**
     * Maneja el evento de clic en un TextField (celda del Sudoku).
     * Aplica un efecto visual temporal de resaltado y solicita el foco.
     *
     * @param eventoMouse Evento de mouse que disparó la acción
     * @param celda TextField (celda) que recibió el clic
     */
    @Override
    public void clickEnTextField(MouseEvent eventoMouse, TextField celda) {
        // Guarda el estilo original para restaurarlo después
        String estiloOriginal = celda.getStyle();

        // Aplica estilo de resaltado temporal
        celda.setStyle("-fx-background-color: #E6E6FA; -fx-border-color: PURPLE; -fx-border-width: 2;");

        PauseTransition pausa = new PauseTransition(Duration.millis(1000));

        pausa.setOnFinished(evento -> {
            celda.setStyle(estiloOriginal);
        });

        // Solicita el foco para permitir entrada de teclado inmediata
        pausa.play();

        celda.requestFocus();
    }
}
