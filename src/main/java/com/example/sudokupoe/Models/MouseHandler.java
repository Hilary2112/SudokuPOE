package com.example.sudokupoe.Models;

import javafx.animation.PauseTransition;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class MouseHandler extends  MouseAdapter{
    @Override
    public void clickEnTextField(MouseEvent eventoMouse, TextField celda) {
        String estiloOriginal = celda.getStyle();

        celda.setStyle("-fx-background-color: #E6E6FA; -fx-border-color: PURPLE; -fx-border-width: 2;");

        PauseTransition pausa = new PauseTransition(Duration.millis(1000));

        pausa.setOnFinished(evento -> {
            celda.setStyle(estiloOriginal);
        });

        pausa.play();

        celda.requestFocus();
    }
}
