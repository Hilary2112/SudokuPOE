package com.example.sudokupoe.Models;


public class TableroSudokuModelo {

    private static final int matrizTamano = 6;
    private int[][] tablero;
    private int[][] tableroNoEditable;

    public TableroSudokuModelo() {
        tablero = new int[matrizTamano][matrizTamano];
        tableroNoEditable = new int[matrizTamano][matrizTamano];
    }

    public void setTablero(int[][] nuevoTableroSudoku) {
        for (int i = 0; i < matrizTamano; i++) {
            for (int j = 0; j < matrizTamano; j++) {
                tablero[i][j] = nuevoTableroSudoku[i][j];
                tableroNoEditable[i][j] = nuevoTableroSudoku[i][j];
            }
        }
    }

    public int[][] getTablero(){
        return tablero;
    }

    public void colocarNumeroEnLaCelda(int fila, int columna, int numero) {
        if (tableroNoEditable[fila][columna] == 0) {
            tablero[fila][columna] = numero;
        }
    }
    
    public void eliminarNumeroEnLaCelda(int fila, int columna) {
        if (tableroNoEditable[fila][columna] == 0) {
            tablero[fila][columna] = 0;
        }
    }

    public int getNumero(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean celdaEditable(int fila, int columna) {
        return tableroNoEditable[fila][columna] == 0;
    }

}
