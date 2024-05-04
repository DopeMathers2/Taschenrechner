package de.dopemathers.taschenrechner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AboutWindow
{

    @FXML
    Button okButton;

    @FXML
    private void okButtonPressed()
    {
        okButton.getScene().getWindow().hide();
    }

}
