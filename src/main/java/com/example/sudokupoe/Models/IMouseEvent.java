package com.example.sudokupoe.Models;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Interfaz que define los eventos de mouse para las celdas del Sudoku.
 * Proporciona métodos para manejar interacciones del usuario con la interfaz gráfica.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 * @version 1.0
 */
public interface IMouseEvent {
    /**
     * Se ejecuta cuando el usuario hace clic en una celda (TextField).
     *
     * @param eventoMouse Evento de mouse que contiene información del clic
     * @param celda Celda (TextField) que recibió el clic
     */
    void clickEnTextField(MouseEvent eventoMouse, TextField celda);

    /**
     * Se ejecuta cuando el cursor del mouse entra en una celda.
     * Útil para efectos de hover o resaltado.
     *
     * @param eventoMouse Evento de mouse que contiene información de entrada
     * @param celda Celda (TextField) por donde entró el mouse
     */
    void mouseEntraTextField(MouseEvent eventoMouse, TextField celda);

    /**
     * Se ejecuta cuando el cursor del mouse sale de una celda.
     * Útil para restaurar el estado normal después de efectos de hover.
     *
     * @param eventoMouse Evento de mouse que contiene información de salida
     * @param celda Celda (TextField) de donde salió el mouse
     */
    void mouseSaleTextField(MouseEvent eventoMouse, TextField celda);
}
