package com.example.sudokupoe.Models;

/**
 * Clase que representa el tablero de Sudoku 6x6.
 * Gestiona el estado del juego, incluyendo celdas editables y no editables.
 * Mantiene dos matrices: una para el estado actual y otra para las celdas fijas iniciales.
 *
 * @author Hilary Herrera, Manuel Lopez sanchez
 * @version 1.0
 */
public class TableroSudokuModelo {

    private static final int matrizTamano = 6;
    private int[][] tablero;
    private int[][] tableroNoEditable;

    /**
     * Constructor que inicializa las matrices del tablero.
     * Crea dos matrices 6x6: una para el juego actual y otra para las celdas fijas.
     */
    public TableroSudokuModelo() {
        tablero = new int[matrizTamano][matrizTamano];
        tableroNoEditable = new int[matrizTamano][matrizTamano];
    }

    /**
     * Establece un nuevo tablero de juego.
     * Copia el tablero proporcionado tanto al tablero actual como al de celdas fijas.
     *
     * @param nuevoTableroSudoku Matriz 6x6 con el nuevo estado del juego
     */
    public void setTablero(int[][] nuevoTableroSudoku) {
        for (int i = 0; i < matrizTamano; i++) {
            for (int j = 0; j < matrizTamano; j++) {
                tablero[i][j] = nuevoTableroSudoku[i][j];
                tableroNoEditable[i][j] = nuevoTableroSudoku[i][j];
            }
        }
    }

    /**
     * Obtiene el estado actual del tablero.
     *
     * @return Matriz 6x6 con los números actuales del juego
     */
    public int[][] getTablero(){
        return tablero;
    }

    /**
     * Coloca un número en una celda, solo si es editable.
     * Las celdas no editables (predefinidas) no pueden ser modificadas.
     *
     * @param fila Fila de la celda (0-5)
     * @param columna Columna de la celda (0-5)
     * @param numero Número a colocar (1-6)
     */
    public void colocarNumeroEnLaCelda(int fila, int columna, int numero) {
        if (tableroNoEditable[fila][columna] == 0) {
            tablero[fila][columna] = numero;
        }
    }

    /**
     * Elimina el número de una celda, solo si es editable.
     * Establece el valor a 0 (vacío) en celdas modificables.
     *
     * @param fila Fila de la celda (0-5)
     * @param columna Columna de la celda (0-5)
     */
    public void eliminarNumeroEnLaCelda(int fila, int columna) {
        if (tableroNoEditable[fila][columna] == 0) {
            tablero[fila][columna] = 0;
        }
    }

    /**
     * Obtiene el número en una posición específica del tablero.
     *
     * @param fila Fila de la celda (0-5)
     * @param columna Columna de la celda (0-5)
     * @return El número en la celda (0 si está vacía)
     */
    public int getNumero(int fila, int columna) {
        return tablero[fila][columna];
    }

    /**
     * Verifica si una celda es editable por el usuario.
     * Las celdas con valor 0 en el tablero no editable son modificables.
     *
     * @param fila Fila de la celda (0-5)
     * @param columna Columna de la celda (0-5)
     * @return true si la celda puede ser editada, false si es fija
     */
    public boolean celdaEditable(int fila, int columna) {
        return tableroNoEditable[fila][columna] == 0;
    }

}
