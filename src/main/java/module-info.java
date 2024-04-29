module de.dopemathers.taschenrechner {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.dopemathers.taschenrechner to javafx.fxml;
    exports de.dopemathers.taschenrechner;
}