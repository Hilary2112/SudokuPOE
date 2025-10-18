package com.example.sudokupoe.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Genera tableros de Sudoku 6x6 completos y sus soluciones.
 * Utiliza backtracking para crear tableros válidos y oculta celdas para el juego.
 * Mantiene la solución completa para proporcionar pistas precisas.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class GeneradorSudokuModelo {
    private static final int matrizTamano = 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;
    private Random random;
    private ValidadorSudokuModelo validadorSudokuModelo;
    private boolean[][] celdasIniciales;
    private int[][] solucionCompleta; // Guarda la solución completa

    /**
     * Constructor que inicializa el generador con sus dependencias.
     */
    public GeneradorSudokuModelo(){
        random = new Random();
        validadorSudokuModelo = new ValidadorSudokuModelo();
        celdasIniciales = new boolean[matrizTamano][matrizTamano];
        solucionCompleta = new int[matrizTamano][matrizTamano];
    }

    /**
     * Genera un nuevo tablero de Sudoku con solución única.
     *
     * @return Matriz 6x6 con el tablero generado (algunas celdas vacías)
     */
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

    /**
     * Llena el tablero usando backtracking recursivo.
     *
     * @param tablero Tablero a llenar
     * @return true si se pudo completar el tablero, false en caso contrario
     */
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

    /**
     * Oculta celda del tablero completo para crear el juego.
     * Mantiene 2 celdas visibles por cada bloque 2x3.
     *
     * @param tableroCompleto Tablero completamente resuelto
     * @return Tablero con celdas ocultas para jugar
     */
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

    /**
     * Genera un arreglo de números del 1 al 6 en orden aleatorio.
     *
     * @return Arreglo de números mezclados aleatoriamente
     */
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

    /**
     * Verifica si una celda es inicial (no editable).
     *
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * @return true si la celda es inicial, false si es editable
     */
    public boolean esCeldaInicial(int fila, int columna){
        return celdasIniciales[fila][columna];
    }

    /**
     * Reinicia el registro de celdas iniciales.
     */
    private void reiniciarCeldasIniciales(){
        for(int i = 0; i < matrizTamano; i++){
            for(int j = 0; j < matrizTamano; j++){
                celdasIniciales[i][j] = false;
            }
        }
    }

    /**
     * Inicia un nuevo juego configurando el tablero del modelo.
     *
     * @param tableroModelo Modelo del tablero a inicializar
     */

    public void iniciarNuevoJuego(TableroSudokuModelo tableroModelo){
        tableroModelo.setTablero(generarTablero());
    }

    /**
     * Obtiene una pista desde la solución completa guardada.
     *
     * @param tableroActual Tablero actual del juego
     * @return Arreglo [fila, columna, número] con la pista, o null si no hay
     */
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
