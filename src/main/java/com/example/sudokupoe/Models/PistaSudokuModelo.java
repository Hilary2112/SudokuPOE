package com.example.sudokupoe.Models;

/**
 * Clase que proporciona pistas para el juego de Sudoku.
 * Ofrece ayuda al usuario sugiriendo movimientos válidos cuando está atascado.
 * Puede generar pistas simples o usar la solución precalculada del generador.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 * @version 1.0
 */
public class PistaSudokuModelo {
    private ValidadorSudokuModelo validador;
    private static final int matrizTamano = 6;
    private GeneradorSudokuModelo generador;

    /**
     * Constructor que inicializa el validador de movimientos.
     *
     * @param validador Instancia del validador para verificar movimientos
     */
    public PistaSudokuModelo(ValidadorSudokuModelo validador) {
        this.validador = validador;
    }

    /**
     * Establece el generador de Sudoku para obtener pistas desde la solución.
     *
     * @param generador Instancia del generador con la solución precalculada
     */
    public void setGenerador(GeneradorSudokuModelo generador) {
        this.generador = generador;
    }

    /**
     * Obtiene una pista para el tablero actual.
     * Primero intenta usar la solución del generador, luego busca movimientos válidos.
     *
     * @param tablero Matriz 6x6 con el estado actual del juego
     * @return Arreglo con [fila, columna, número] de la pista, o [-1,-1,-1] si no hay pista
     */
    public int[] obtenerPista(int[][] tablero) {
        if (!sePuedeDarPista(tablero))
            return new int[]{-1, -1, -1};

        // primero Intenta obtener pista desde la solución precalculada
        if (generador != null) {
            int[] pista = generador.obtenerPistaDesdeSolucion(tablero);
            if (pista != null) {
                return pista;
            }
        }

        // Busca la primera celda vacía con un movimiento válido
        for (int fila = 0; fila < matrizTamano; fila++) {
            for (int columna = 0; columna < matrizTamano; columna++) {
                if (tablero[fila][columna] == 0) {
                    for (int numero = 1; numero <= matrizTamano; numero++) {
                        if (validador.verficarSiElMovimientoEsValido(tablero, fila, columna, numero)) {
                            return new int[]{fila, columna, numero};
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1, -1};
    }

    /**
     * Verifica si es posible dar una pista en el estado actual del juego.
     * Evita dar pistas cuando el juego está casi terminado (solo queda 1 celda vacía).
     *
     * @param tablero Matriz 6x6 con el estado actual del juego
     * @return true si se puede dar pista, false si hay muy pocas celdas vacías
     */
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

