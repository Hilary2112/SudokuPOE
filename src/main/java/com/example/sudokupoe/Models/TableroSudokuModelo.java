package com.example.sudokupoe.Models;


public class TableroSudokuModelo {


    private int[][] tablero;


    public TableroSudokuModelo() {
        tablero = new int[6][6];
    }


    public int[][] getTablero(){
        return tablero;
    }

    public void colocarNumeroEnLaCelda(int fila, int columna, int numero) {
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6){
            tablero[fila][columna] = numero;
        }
    }



    public void eliminarNumeroEnLaCelda(int fila, int columna) {
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6){
            tablero[fila][columna] = 0;
        }
    }

    public int getNumero(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean verificarCeldaVacia(int fila, int columna){
        return tablero[fila][columna] == 0;
    }

    public void limpiarTablero(){
        tablero = new int[6][6];
    }
}
