package com.example.sudokupoe.Controllers;

import com.example.sudokupoe.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController {

    private TableroSudokuModelo tableroSudoku;
    private ValidadorSudokuModelo validadorSudoku;
    private PistaSudokuModelo pistaSudoku;
    private GeneradorSudokuModelo generadorSudoku;
    private AlertBox alertas;
    private MouseHandler mouseHandler;

    @FXML
    private Button BotonNuevoJuego,BotonPista,BotonVerificar;

    @FXML
    private GridPane GridpanePadre;

    private TextField[][] celdasSudoku;

    private static final String ESTILO_NORMAL  = "-fx-border-color: #2c3e50; -fx-border-width: 2; -fx-background-color: white; -fx-font-size: 20; -fx-font-weight: bold;";
    private static final String ESTILO_ERROR   = "-fx-border-color: #e74c3c; -fx-border-width: 3; -fx-background-color: #ffebee; -fx-font-size: 16; -fx-font-weight: bold;";
    private static final String ESTILO_INICIAL = "-fx-border-color: #2c3e50; -fx-border-width: 2; -fx-background-color: #e0e0e0; -fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #34495e;";
    private static final String ESTILO_PISTA   = "-fx-border-color: #f39c12; -fx-border-width: 3; -fx-background-color: #fef9e7; -fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #f39c12;";

    @FXML private TextField celda00,celda01,celda02,celda03,celda04,celda05;
    @FXML private TextField celda10,celda11,celda12,celda13,celda14,celda15;
    @FXML private TextField celda20,celda21,celda22,celda23,celda24,celda25;
    @FXML private TextField celda30,celda31,celda32,celda33,celda34,celda35;
    @FXML private TextField celda40,celda41,celda42,celda43,celda44,celda45;
    @FXML private TextField celda50,celda51,celda52,celda53,celda54,celda55;

    @FXML
    public void initialize() {
        tableroSudoku = new TableroSudokuModelo();
        validadorSudoku = new ValidadorSudokuModelo();
        generadorSudoku = new GeneradorSudokuModelo();
        pistaSudoku = new PistaSudokuModelo(validadorSudoku);
        alertas = new AlertBox();
        mouseHandler = new MouseHandler();

        pistaSudoku.setGenerador(generadorSudoku);

        inicializarMatrizCeldas();
        configurarEventosCeldas();
        iniciarNuevoJuego();
    }

    private void inicializarMatrizCeldas() {
        celdasSudoku = new TextField[][]{
                {celda00, celda01, celda02, celda03, celda04, celda05},
                {celda10, celda11, celda12, celda13, celda14, celda15},
                {celda20, celda21, celda22, celda23, celda24, celda25},
                {celda30, celda31, celda32, celda33, celda34, celda35},
                {celda40, celda41, celda42, celda43, celda44, celda45},
                {celda50, celda51, celda52, celda53, celda54, celda55}
        };
    }

    @FXML
    void OnActionBotonNuevoJuego(ActionEvent event) {

    }

    @FXML
    void OnActionBotonPista(ActionEvent event) {

    }

    @FXML
    void OnActionBotonVerificar(ActionEvent event) {

    }

}
