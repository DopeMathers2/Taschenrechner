package de.dopemathers.taschenrechner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.Objects;

public class AboutWindow
{

    @FXML
    Button okButton;
    @FXML
    TextArea textArea;


    @FXML
    public void initialize()
    {
        textArea.setText(Calculator.getBundle().getString("about-me"));
        textArea.setEditable(false);
        textArea.setMouseTransparent(true);
        textArea.setFocusTraversable(false);
        String  style= Objects.requireNonNull(Calculator.class.getResource("styles/" + Calculator.actualStyle)).toExternalForm();
        textArea.getStylesheets().add(style);

    }

    @FXML
    private void okButtonPressed()
    {
        okButton.getScene().getWindow().hide();
    }

}
