package com.example.sudokupoe.Models;

public class PistaSudokuModelo {
    private ValidadorSudokuModelo validador;
    private static final int matrizTamano = 6;
    private GeneradorSudokuModelo generador;

    public PistaSudokuModelo(ValidadorSudokuModelo validador){
        this.validador = validador;
    }

    public void setGenerador(GeneradorSudokuModelo generador) {
        this.generador = generador;
    }

    public int[] obtenerPista(int[][] tablero){
        if (!sePuedeDarPista(tablero))
            return new int[]{-1, -1, -1};

        if (generador != null) {
            int[] pista = generador.obtenerPistaDesdeSolucion(tablero);
            if (pista != null){
                return pista;
            }
        }

        for(int fila = 0; fila < matrizTamano; fila++){
            for(int columna = 0; columna < matrizTamano; columna++){
                if(tablero[fila][columna] == 0){
                    for(int numero = 1; numero <= matrizTamano; numero++){
                        if(validador.verficarSiElMovimientoEsValido(tablero, fila, columna, numero)){
                            return new int[]{fila, columna, numero};
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1, -1};
    }

    public boolean sePuedeDarPista(int[][] tablero){
        int celdasVacias = 0;
        for(int fila = 0; fila < matrizTamano; fila++){
            for(int columna = 0; columna < matrizTamano; columna++){
                if(tablero[fila][columna] == 0) {
                    celdasVacias++;
                }
            }
        }
        return celdasVacias > 1;
    }
}

