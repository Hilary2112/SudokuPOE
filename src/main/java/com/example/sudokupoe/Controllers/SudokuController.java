package com.example.sudokupoe.Controllers;

import com.example.sudokupoe.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Controlador principal para la interfaz gráfica del Sudoku.
 * Gestiona la interacción entre la vista y los modelos del juego.
 * Coordina eventos de usuario, validaciones y actualizaciones de la interfaz.
 *
 * @author Hilary Herrera, Manuel Lopez Sanchez
 */
public class SudokuController {

    private TableroSudokuModelo tableroSudoku;
    private ValidadorSudokuModelo validadorSudoku;
    private PistaSudokuModelo pistaSudoku;
    private GeneradorSudokuModelo generadorSudoku;
    private AlertBox alertas;
    private MouseHandler mouseHandler;

    @FXML
    private Button BotonNuevoJuego, BotonPista, BotonVerificar;

    @FXML
    private GridPane GridpanePadre;

    private TextField[][] celdasSudoku;

    private static final String ESTILO_NORMAL = "-fx-border-color: #2c3e50; -fx-border-width: 2; -fx-background-color: white; -fx-font-size: 20; -fx-font-weight: bold;";
    private static final String ESTILO_ERROR = "-fx-border-color: #e74c3c; -fx-border-width: 3; -fx-background-color: #ffebee; -fx-font-size: 16; -fx-font-weight: bold;";
    private static final String ESTILO_INICIAL = "-fx-border-color: #2c3e50; -fx-border-width: 2; -fx-background-color: #e0e0e0; -fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #34495e;";
    private static final String ESTILO_PISTA = "-fx-border-color: #f39c12; -fx-border-width: 3; -fx-background-color: #fef9e7; -fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #f39c12;";

    @FXML
    private TextField celda00, celda01, celda02, celda03, celda04, celda05;
    @FXML
    private TextField celda10, celda11, celda12, celda13, celda14, celda15;
    @FXML
    private TextField celda20, celda21, celda22, celda23, celda24, celda25;
    @FXML
    private TextField celda30, celda31, celda32, celda33, celda34, celda35;
    @FXML
    private TextField celda40, celda41, celda42, celda43, celda44, celda45;
    @FXML
    private TextField celda50, celda51, celda52, celda53, celda54, celda55;



    /**
     * Método de inicialización llamado automáticamente por JavaFX.
     * Configura todos los modelos, controladores y componentes de la interfaz.
     */
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

    /**
     * Organiza las celdas individuales en una matriz 6x6 para fácil acceso.
     */
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

    /**
     * Maneja el evento del botón "Nuevo Juego".
     * Muestra confirmación y reinicia el tablero si el usuario acepta.
     *
     * @param event Evento de acción del botón
     */
    @FXML
    void OnActionBotonNuevoJuego(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Nuevo Juego");
        confirm.setHeaderText("¿Deseas iniciar un nuevo Sudoku?");
        confirm.setContentText("Esto reiniciará el tablero actual.");
        confirm.showAndWait().ifPresent(response -> iniciarNuevoJuego());
    }

    /**
     * Maneja el evento del botón "Pista".
     * Proporciona una sugerencia al usuario o informa si no es posible.
     *
     * @param event Evento de acción del botón
     */
    @FXML
    void OnActionBotonPista(ActionEvent event) {
        boolean puedeDarPista = pistaSudoku.sePuedeDarPista(tableroSudoku.getTablero());
        if (!puedeDarPista) {
            alertas.alertBoxPista("Sin sugerencias", "Tu puedes!!");
            return;
        }

        int[] pista = pistaSudoku.obtenerPista(tableroSudoku.getTablero());
        if (pista[0] == -1) {
            alertas.alertBoxPista("Sin sugerencias", "No se pudo encontrar una sugerencia válida en este momento.");
            return;
        }

        int fila = pista[0];
        int columna = pista[1];
        int numero = pista[2];

        tableroSudoku.colocarNumeroEnLaCelda(fila, columna, numero);

        TextField celdaPista = celdasSudoku[fila][columna];
        celdaPista.setText(String.valueOf(numero));
        celdaPista.setEditable(false);
        celdaPista.setStyle(ESTILO_PISTA);

        validadorSudoku.validarYMarcarErrores(tableroSudoku.getTablero());
        actualizarEstadoBotonPista();
    }

    /**
     * Maneja el evento del botón "Verificar".
     * Valida el tablero actual y muestra el resultado al usuario.
     *
     * @param event Evento de acción del botón
     */
    @FXML
    void OnActionBotonVerificar(ActionEvent event) {
        validadorSudoku.validarYMarcarErrores(tableroSudoku.getTablero());
        actualizarEstilosCeldas();

        boolean tieneErrores = false;
        int celdasLlenas = 0;

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (tableroSudoku.getNumero(fila, columna) != 0) {
                    celdasLlenas++;
                }
                if (validadorSudoku.tieneError(fila, columna)) {
                    tieneErrores = true;
                }
            }
        }

        if (tieneErrores) {
            alertas.alertBoxError("Errores encontrados", "Hay números duplicados en filas, columnas o bloques. Revisa las celdas resaltadas.");
        } else if (celdasLlenas == 36) {
            mostrarDialogoJuegoCompletado();
        } else {
            int celdasVacias = 36 - celdasLlenas;
            alertas.alertBoxJuegoCompleto("Validación correcta",
                    "ESPERA!! Vas por buen camino pero... \n\n" +
                            "Te faltan " + celdasVacias + " celdas por completar.");
        }
    }

    /**
     * Configura eventos de mouse y teclado para todas las celdas del tablero.
     */
    private void configurarEventosCeldas() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                TextField celdaActual = celdasSudoku[fila][columna];
                configurarEventosParaCelda(celdaActual, fila, columna);
            }
        }
    }

    /**
     * Configura eventos específicos para una celda individual.
     *
     * @param celda TextField de la celda
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     */
    private void configurarEventosParaCelda(TextField celda, int fila, int columna) {
        celda.setOnMouseClicked(evento -> {
            if (!generadorSudoku.esCeldaInicial(fila, columna)) {
                mouseHandler.clickEnTextField(evento, celda);
            }
        });

        celda.setOnKeyReleased(evento -> manejarEntradaTeclado(celda, fila, columna));
    }

    /**
     * Maneja la entrada de teclado en las celdas.
     * Valida y procesa los números ingresados por el usuario.
     *
     * @param celda Celda donde se ingresó el texto
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     */
    private void manejarEntradaTeclado(TextField celda, int fila, int columna) {
        String textoIngresado = celda.getText();

        if (textoIngresado.length() > 1) {
            textoIngresado = textoIngresado.substring(textoIngresado.length() - 1);
            celda.setText(textoIngresado);
        }

        if (!textoIngresado.matches("[1-6]*")) {
            celda.setText("");
            return;
        }

        if (generadorSudoku.esCeldaInicial(fila, columna)) {
            celda.setText(String.valueOf(tableroSudoku.getNumero(fila, columna)));
            return;
        }

        int valor = textoIngresado.isEmpty() ? 0 : Integer.parseInt(textoIngresado);
        actualizarModeloTablero(fila, columna, valor);

        validadorSudoku.validarYMarcarErrores(tableroSudoku.getTablero());
        actualizarEstilosCeldas();
    }

    /**
     * Actualiza el modelo del tablero con el nuevo valor ingresado.
     *
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * @param valor Nuevo valor a establecer
     */
    private void actualizarModeloTablero(int fila, int columna, int valor) {
        if (valor == 0) {
            tableroSudoku.eliminarNumeroEnLaCelda(fila, columna);
        } else {
            tableroSudoku.colocarNumeroEnLaCelda(fila, columna, valor);
        }
    }

    /**
     * Actualiza los estilos visuales de todas las celdas basado en su estado actual.
     */
    private void actualizarEstilosCeldas() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                TextField celda = celdasSudoku[fila][columna];
                String estilo = obtenerEstiloCelda(fila, columna);
                celda.setStyle(estilo);
            }
        }
    }

    /**
     * Determina el estilo CSS apropiado para una celda basado en su estado.
     *
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * @return String con el estilo CSS correspondiente
     */
    private String obtenerEstiloCelda(int fila, int columna) {
        if (validadorSudoku.tieneError(fila, columna)) {
            return ESTILO_ERROR;
        } else if (generadorSudoku.esCeldaInicial(fila, columna)) {
            return ESTILO_INICIAL;
        } else {
            return ESTILO_NORMAL;
        }
    }

    /**
     * Inicia un nuevo juego generando un tablero fresco.
     */
    private void iniciarNuevoJuego() {
        generadorSudoku.iniciarNuevoJuego(tableroSudoku);
        actualizarInterfazUsuario();
        actualizarEstilosCeldas();
        actualizarEstadoBotonPista();
    }

    /**
     * Actualiza la interfaz de usuario para reflejar el estado actual del tablero.
     */
    private void actualizarInterfazUsuario() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                int valorActual = tableroSudoku.getNumero(fila, columna);
                TextField celdaActual = celdasSudoku[fila][columna];

                if (valorActual == 0) {
                    celdaActual.setText("");
                } else {
                    String textoNumero = String.valueOf(valorActual);
                    celdaActual.setText(textoNumero);
                }

                boolean esCeldaInicial = generadorSudoku.esCeldaInicial(fila, columna);
                celdaActual.setEditable(!esCeldaInicial);
            }
        }
    }

    /**
     * Actualiza el estado del botón de pista (habilitado/deshabilitado).
     */
    private void actualizarEstadoBotonPista() {
        boolean puedeDarPista = pistaSudoku.sePuedeDarPista(tableroSudoku.getTablero());
        BotonPista.setDisable(!puedeDarPista);
    }

    /**
     * Muestra el diálogo de felicitaciones cuando el juego se completa exitosamente.
     */
    private void mostrarDialogoJuegoCompletado() {
        alertas.alertBoxJuegoCompleto("¡Felicitaciones!", "¡Has completado el Sudoku!\n\nExcelente trabajo.");

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                celdasSudoku[fila][columna].setEditable(false);
            }
        }

        BotonPista.setDisable(true);
    }


}