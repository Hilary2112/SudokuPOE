package com.example.sudokupoe.Models;

public class ValidadorSudokuModelo {

    private static final int matrizTamano= 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;
    private boolean[][] errores;

    public ValidadorSudokuModelo(){
        errores = new boolean[matrizTamano][matrizTamano];
    }

    public boolean verficarSiElMovimientoEsValido(int[][] tablero,int fila, int columna, int numero){
        if (!verificarNumeroEnFila(tablero,fila,numero)) {
            return false;
        }
        if (!verificarNumeroEnColumna(tablero, columna, numero)){
            return false;
        }
        if (!verificarNumeroEnBloque(tablero,fila,columna,numero)){
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

    private boolean verificarNumeroEnBloque(int[][] tablero, int fila, int columna, int numero){
        int inicioDeFila = (fila/altoPorBloque)*altoPorBloque;
        int inicioDeColumna = (columna/anchoPorBloque)*anchoPorBloque;

        for (int i = inicioDeFila; i < inicioDeFila + altoPorBloque; i++){
            for(int j = inicioDeColumna; j < inicioDeColumna + anchoPorBloque; j++){
                if (tablero[i][j] == numero){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean tableroCompletamenteValido(int[][] tablero) {
        for (int fila = 0; fila < matrizTamano; fila++) {
            for (int columna = 0; columna < matrizTamano; columna++) {
                int numero = tablero[fila][columna];
                if (numero != 0) {
                    tablero[fila][columna] = 0;
                    boolean valido = verficarSiElMovimientoEsValido(tablero, fila, columna, numero);
                    tablero[fila][columna] = numero;
                    if (!valido) return false;
                }
            }
        }
        return true;
    }


    private void limpiarErrores(){
        for(int i = 0; i < matrizTamano; i++){
            for(int j = 0; j < matrizTamano; j++){
                errores[i][j] = false;
            }
        }
    }



}