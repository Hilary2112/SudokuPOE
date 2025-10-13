package com.example.sudokupoe.Models;

public interface IAlertBox {
    void alertBoxError(String titulo, String mensaje);
    void alertBoxJuegoCompleto(String titulo, String mensaje);
    void alertBoxPista(String titulo, String mensaje);
    void alertBoxNuevoJuego(String titulo, String mensaje);
}
