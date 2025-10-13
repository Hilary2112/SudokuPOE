package com.example.sudokupoe.Models;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public interface IMouseEvent {
    void clickEnTextField(MouseEvent eventoMouse, TextField celda);
    void mouseEntraTextField(MouseEvent eventoMouse, TextField celda);
    void mouseSaleTextField(MouseEvent eventoMouse, TextField celda);
}
