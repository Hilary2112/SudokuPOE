package com.example.sudokupoe.Models;

/**
 * Interfaz para mostrar diferentes tipos de alertas en el juego de Sudoku.
 * Define métodos para mostrar mensajes al usuario en diversas situaciones del juego.
 *
 * @author Hilary Herrera, Manuel Lopez
 * @version 1.0
 */
public interface IAlertBox {
    /**
     * Muestra una alerta de error al usuario.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje de error a mostrar
     */
    void alertBoxError(String titulo, String mensaje);

    /**
     * Muestra una alerta cuando el juego ha sido completado exitosamente.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje de felicitación o información de finalización
     */
    void alertBoxJuegoCompleto(String titulo, String mensaje);

    /**
     * Muestra una alerta relacionada con el sistema de pistas.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje informativo sobre la pista
     */
    void alertBoxPista(String titulo, String mensaje);

    /**
     * Muestra una alerta cuando se inicia un nuevo juego.
     *
     * @param titulo Título de la ventana de alerta
     * @param mensaje Mensaje informativo sobre el nuevo juego
     */
    void alertBoxNuevoJuego(String titulo, String mensaje);
}
