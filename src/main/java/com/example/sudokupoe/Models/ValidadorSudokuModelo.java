package com.example.sudokupoe.Models;

/**
 * Clase que valida las reglas del Sudoku y gestiona los errores en el tablero.
 * Implementa la lógica para verificar filas, columnas y bloques en un Sudoku 6x6.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 * @version 1.0
 */
public class ValidadorSudokuModelo {

    private static final int matrizTamano= 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;
    private boolean[][] errores;

    /**
     * Constructor que inicializa la matriz de errores.
     */
    public ValidadorSudokuModelo(){
        errores = new boolean[matrizTamano][matrizTamano];
    }

    /**
     * Verifica si un movimiento es válido en una posición específica del tablero.
     *
     * @param tablero Matriz del tablero actual
     * @param fila Fila donde se quiere colocar el número
     * @param columna Columna donde se quiere colocar el número
     * @param numero Número a validar
     * @return true si el movimiento es válido, false en caso contrario
     */
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

    /**
     * Verifica si un número ya existe en la fila especificada.
     */
    private boolean verificarNumeroEnFila(int[][] tablero, int fila, int numero) {
        for (int j = 0; j < matrizTamano; j++) {
            if (tablero[fila][j] == numero) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un número ya existe en la columna especificada.
     */
    private boolean verificarNumeroEnColumna(int[][] tablero, int columna, int numero) {

        for (int i = 0; i < matrizTamano; i++) {
            if (tablero[i][columna] == numero) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica que el número no exista en el bloque 2x3 correspondiente.
     * Calcula el bloque basado en la posición y revisa las 6 celdas del bloque.
     */
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

    /**
     * Valida que todo el tablero cumpla con las reglas del Sudoku.
     *
     * @param tablero Matriz del tablero a validar
     * @return true si el tablero es válido, false en caso contrario
     */
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

    /**
     * Reinicia todos los marcadores de error en el tablero.
     * Limpia la matriz de errores antes de una nueva validación.
     */
    private void limpiarErrores(){
        for(int i = 0; i < matrizTamano; i++){
            for(int j = 0; j < matrizTamano; j++){
                errores[i][j] = false;
            }
        }
    }


    /**
     * Consulta si una celda específica está marcada con error.
     *
     * @param fila Fila de la celda (0-5)
     * @param columna Columna de la celda (0-5)
     * @return true si la celda tiene un número inválido
     */
    public boolean tieneError(int fila, int columna) {
        return errores[fila][columna];
    }

    /**
     * Verifica si el juego está completado correctamente.
     * Comprueba que no hay celdas vacías y que el tablero es válido.
     *
     * @param tablero Tablero a verificar
     * @return true si el juego está ganado, false si hay celdas vacías o errores
     */
    public boolean esJuegoCompletado(int[][] tablero) {
        for (int fila = 0; fila < matrizTamano; fila++) {
            for (int columna = 0; columna < matrizTamano; columna++) {
                if (tablero[fila][columna] == 0) {
                    return false;
                }
            }
        }
        return tableroCompletamenteValido(tablero);
    }

    /**
     * Ejecuta validación completa del tablero y marca todas las celdas con errores.
     * Útil para mostrar al usuario dónde están los números incorrectos.
     *
     * @param tablero Tablero a validar y marcar errores
     */
    public void validarYMarcarErrores(int[][] tablero) {
        limpiarErrores();

        for (int fila = 0; fila < matrizTamano; fila++) {
            for (int columna = 0; columna < matrizTamano; columna++) {
                int numero = tablero[fila][columna];
                if (numero != 0) {
                    tablero[fila][columna] = 0;
                    boolean valido = verficarSiElMovimientoEsValido(tablero, fila, columna, numero);
                    tablero[fila][columna] = numero;

                    if (!valido) {
                        errores[fila][columna] = true;
                    }
                }
            }
        }
    }







}