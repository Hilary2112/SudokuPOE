package com.example.sudokupoe.Models;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MouseHandler extends  MouseAdapter{
    @Override
    public void clickEnTextField(MouseEvent eventoMouse, TextField celda) {
        // Resaltar la celda cuando se hace click
        celda.setStyle("-fx-background-color: #FFFFCC; -fx-border-color: BLUE; -fx-border-width: 2;");
        celda.requestFocus();
    }
}
