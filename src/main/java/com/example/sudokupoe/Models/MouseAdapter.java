package com.example.sudokupoe.Models;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Clase adaptadora que implementa la interfaz IMouseEvent con métodos vacíos.
 * Permite que las subclases sobrescriban solo los métodos que necesitan,
 * evitando la implementación obligatoria de todos los métodos de la interfaz.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 * @version 1.0
 */
public class MouseAdapter implements IMouseEvent {

    /**
     * Maneja el evento de clic en un TextField.
     * Implementación vacía para ser sobrescrita por subclases.
     *
     * @param eventoMouse Evento de mouse que disparó la acción
     * @param celda TextField (celda) que recibió el clic
     */
    @Override
    public void clickEnTextField(MouseEvent eventoMouse, TextField celda) {
        // Implementación vacía - las subclases pueden sobrescribir
    }

    /**
     * Maneja el evento cuando el mouse entra en un TextField.
     * Implementación vacía para ser sobrescrita por subclases.
     *
     * @param eventoMouse Evento de mouse que disparó la acción
     * @param celda TextField (celda) por donde entró el mouse
     */
    @Override
    public void mouseEntraTextField(MouseEvent eventoMouse, TextField celda) {
        // Implementación vacía - las subclases pueden sobrescribir
    }

    /**
     * Maneja el evento cuando el mouse sale de un TextField.
     * Implementación vacía para ser sobrescrita por subclases.
     *
     * @param eventoMouse Evento de mouse que disparó la acción
     * @param celda TextField (celda) de donde salió el mouse
     */
    @Override
    public void mouseSaleTextField(MouseEvent eventoMouse, TextField celda) {
        // Implementación vacía - las subclases pueden sobrescribir
    }
}
