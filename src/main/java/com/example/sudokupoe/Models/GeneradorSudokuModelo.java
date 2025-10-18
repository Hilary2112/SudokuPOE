package com.example.sudokupoe.Models;

import java.util.Random;

public class GeneradorSudokuModelo {

    private static final int matrizTamano= 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;

    private ValidadorSudokuModelo validadorDelSudoku;
    private Random random;
    private boolean[][] celdasIniciales;
    private int[][] solucionCompleta;

    public GeneradorSudokuModelo (){
        validadorDelSudoku = new ValidadorSudokuModelo();
        random = new Random();
        celdasIniciales = new boolean[matrizTamano][matrizTamano];
        solucionCompleta = new int[matrizTamano][matrizTamano];
    }

    public int[][] generarTablero(){
        int[][] tableroCompleto = new int[matrizTamano][matrizTamano];
        reiniciarCeldasIniciales();

        if (!llenarTablero(tableroCompleto)) {
            return generarTablero();
        }

        for (int i = 0; i < matrizTamano; i++) {
            for (int j = 0; j < matrizTamano; j++) {
                solucionCompleta[i][j] = tableroCompleto[i][j];
            }
        }
        return ocultarCeldasDeTableroCompletado(tableroCompleto);
    }

    private boolean llenarTablero(int[][] tablero){
        for(int fila = 0; fila < matrizTamano; fila++){
            for(int columna = 0; columna < matrizTamano; columna++){
                if(tablero[fila][columna] == 0){
                    int[] numeros = generarNumerosAleatorios();

                    for(int numero : numeros){
                        if(validadorSudokuModelo.verficarSiElMovimientoEsValido(tablero, fila, columna, numero)){
                            tablero[fila][columna] = numero;

                            if(llenarTablero(tablero)){
                                return true;
                            }

                            tablero[fila][columna] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}