package com.example.sudokupoe.Models;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MouseAdapter implements IMouseEvent {
    @Override
    public void clickEnTextField(MouseEvent eventoMouse, TextField celda) {
        // Implementación vacía - las subclases pueden sobrescribir
    }

    @Override
    public void mouseEntraTextField(MouseEvent eventoMouse, TextField celda) {
        // Implementación vacía - las subclases pueden sobrescribir
    }

    @Override
    public void mouseSaleTextField(MouseEvent eventoMouse, TextField celda) {
        // Implementación vacía - las subclases pueden sobrescribir
    }
}
