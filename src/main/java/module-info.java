module com.example.sudokupoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.sudokupoe to javafx.fxml;
    opens com.example.sudokupoe.Controllers to javafx.fxml;
    opens com.example.sudokupoe.Views to javafx.fxml;

    exports com.example.sudokupoe.Controllers;
    exports com.example.sudokupoe.Views;
    exports com.example.sudokupoe;
}