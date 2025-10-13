module com.example.sudokupoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sudokupoe to javafx.fxml;
    exports com.example.sudokupoe;
}