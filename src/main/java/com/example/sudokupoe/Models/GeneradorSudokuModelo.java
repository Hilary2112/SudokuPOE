package com.example.sudokupoe.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneradorSudokuModelo {
    private static final int matrizTamano = 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;
    private Random random;
    private ValidadorSudokuModelo validadorSudokuModelo;
    private boolean[][] celdasIniciales;
    private int[][] solucionCompleta; // Guarda la solución completa

    public GeneradorSudokuModelo(){
        random = new Random();
        validadorSudokuModelo = new ValidadorSudokuModelo();
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

    private int[][] ocultarCeldasDeTableroCompletado(int[][] tableroCompleto) {
        int[][] celdaAOcultar = new int[matrizTamano][matrizTamano];

        for (int i = 0; i < matrizTamano; i++) {
            for (int j = 0; j < matrizTamano; j++) {
                celdaAOcultar[i][j] = tableroCompleto[i][j];
            }
        }

        for(int bloqueFila = 0; bloqueFila < matrizTamano; bloqueFila += altoPorBloque){
            for(int bloqueCol = 0; bloqueCol < matrizTamano; bloqueCol += anchoPorBloque){

                ArrayList<int[]> posiciones = new ArrayList<>();
                for(int i = bloqueFila; i < bloqueFila + altoPorBloque; i++){
                    for(int j = bloqueCol; j < bloqueCol + anchoPorBloque; j++){
                        posiciones.add(new int[]{i, j});
                    }
                }

                Collections.shuffle(posiciones);

                for(int posicion = 0; posicion < posiciones.size(); posicion++){
                    int[] celda = posiciones.get(posicion);
                    if(posicion < 2){
                        celdasIniciales[celda[0]][celda[1]] = true;
                    } else {
                        celdaAOcultar[celda[0]][celda[1]] = 0;
                    }
                }
            }
        }

        return celdaAOcultar;
    }

    private int[] generarNumerosAleatorios(){
        int[] numeros = {1, 2, 3, 4, 5, 6};

        for(int indiceActual = 0; indiceActual < numeros.length; indiceActual++){
            int posicionAleatoria = random.nextInt(numeros.length);

            int numeroPosicionActual = numeros[indiceActual];
            numeros[indiceActual] = numeros[posicionAleatoria];
            numeros[posicionAleatoria] = numeroPosicionActual;
        }

        return numeros;
    }

    public boolean esCeldaInicial(int fila, int columna){
        return celdasIniciales[fila][columna];
    }

    private void reiniciarCeldasIniciales(){
        for(int i = 0; i < matrizTamano; i++){
            for(int j = 0; j < matrizTamano; j++){
                celdasIniciales[i][j] = false;
            }
        }
    }

    public void iniciarNuevoJuego(TableroSudokuModelo tableroModelo){
        tableroModelo.setTablero(generarTablero());
    }

    public int[] obtenerPistaDesdeSolucion(int[][] tableroActual) {
        for (int fila = 0; fila < matrizTamano; fila++) {
            for (int columna = 0; columna < matrizTamano; columna++) {
                if (tableroActual[fila][columna] == 0 && !celdasIniciales[fila][columna]) {
                    return new int[]{fila, columna, solucionCompleta[fila][columna]};
                }
            }
        }
        return null;
    }

}
