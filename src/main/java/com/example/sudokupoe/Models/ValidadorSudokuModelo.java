package com.example.sudokupoe.Models;

public class ValidadorSudokuModelo {

    private static final int matrizTamano= 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;

    public boolean verficarSiElMovimientoEsValido(int[][] tablero,int fila, int columna, int numero){
        if (!verificarNumeroEnFila(tablero,fila,numero)) {
            return false;
        }
        if (!verificarNumeroEnColumna(tablero, columna, numero)){
            return false;
        }
        if (!VerificarNumeroEnBloque(tablero,fila,columna,numero)){
            return false;
        }
        return true;
    }

    private boolean verificarNumeroEnFila(int[][] tablero, int fila, int numero) {
        for (int j = 0; j < matrizTamano; j++) {
            if (tablero[fila][j] == numero) {
                return false;
            }
        }
        return true;
    }


    private boolean verificarNumeroEnColumna(int[][] tablero, int columna, int numero) {

        for (int i = 0; i < matrizTamano; i++) {
            if (tablero[i][columna] == numero) {
                return false;
            }
        }
        return true;
    }
 }