module de.dopemathers.taschenrechner {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens de.dopemathers.taschenrechner to javafx.fxml;
    exports de.dopemathers.taschenrechner;
}