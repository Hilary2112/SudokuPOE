package com.example.sudokupoe.Models;

public class TableroSudokuModelo {

    private int [][] numerosJugando;

    public TableroSudokuModelo(){
        numerosJugando = new int[6][6];
    }

    public void colocarNumeroEnLaCelda(int fila,int columna, int numero){
        numerosJugando[fila][columna] = numero;
    }

    public void eliminarNumeroEnLaCelda(int fila, int columna){
        numerosJugando[fila][columna]= 0;
    }

    public int getNumero(int fila,int columna){
        return numerosJugando[fila][columna];
    }
}
