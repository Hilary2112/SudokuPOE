package com.example.sudokupoe.Models;

import java.util.Random;

public class GeneradorSudokuModelo {

    private static final int matrizTamano= 6;
    private static final int altoPorBloque = 2;
    private static final int anchoPorBloque = 3;

    private ValidadorSudokuModelo validadorDelSudoku;
    private Random random;

    public GeneradorSudokuModelo (){
        validadorDelSudoku = new ValidadorSudokuModelo();
        random = new Random();
    }

}
