package de.dopemathers.taschenrechner;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class UserInputs
{


        private String sC = "N";
        private String pMMD;
        private String varOne;
        private boolean varOneTriggered = false;
        private String varTwo;
        private boolean varTwoTriggered = false;
        private String firstSign;
        private boolean firstSignTriggered = false;

        //init all Controls + Language bundle
        @FXML
        private ResourceBundle bundle = Calculator.getBundle();
        @FXML
        Button plusButton;
        @FXML
        Button minusButton;
        @FXML
        Button multiplyButton;
        @FXML
        Button divButton;
        @FXML
        Button zeroButton;
        @FXML
        Button oneButton;
        @FXML
        Button twoButton;
        @FXML
        Button threeButton;
        @FXML
        Button fourButton;
        @FXML
        Button fiveButton;
        @FXML
        Button sixButton;
        @FXML
        Button sevenButton;
        @FXML
        Button aightButton;
        @FXML
        Button nineButton;
        @FXML
        Button pointButton;
        @FXML
        Button enterButton;
        @FXML
        Button escButton; /* to implement */
        @FXML
        TextField calcDisplay;
        @FXML
        Label tempDisplay;
        @FXML
        MenuItem close;

        @FXML
        private void onClosePressed()
        {

            tempDisplay.getScene().getWindow().t

        }

        @FXML
        public void onPMMDPressed(String mathsign)
        {
            sC = mathsign;

            switch (sC)
        {
            case "+":

                break;

            case "-":

                break;

            case "*":

                break;

            case "/":

                break;

        }


        }

        private void firstSignIsTriggered()
        {
            if(firstSignTriggered == false) {
                if (calcDisplay.getText().equalsIgnoreCase("+"))
                {
                    firstSign = "+";
                    firstSignTriggered = true;
                }
                else if (calcDisplay.getText().equalsIgnoreCase("*"))
                {
                    firstSign = "+";
                    firstSignTriggered = true;
                }
                else if (calcDisplay.getText().equalsIgnoreCase("/"))
                {
                    firstSign = "+";
                    firstSignTriggered = true;
                }
                else if (calcDisplay.getText().equalsIgnoreCase("-"))
                {
                    firstSign = "-";
                    firstSignTriggered = true;
                }
                else
                {

                }
            }
        }

        /*Buttons pressed methods
         Wenn button gedrückt wird muss entschieden werden ob Minus oder Plus als vorzeichen stehen -> Sollte Nutzer hier etwas falsches eingeben sollte von + ausgegangen werden.
         Sobald ein Vorzeichen eingetragen wurde muss dies festgehalten werden und das vorzeichen muss gespeichert werden -> varFirstSign firstSignTriggered
         Danach muss gecheckt werden ob bereits ein Vorzeichen gespeichert wurde (firstSignTriggered == true), hiernach muss eine Zahl folgen also muss geprüft werden ob die nächste zahl wirklich eine Zahl ist. -> Sollte es nicht Zahl oder Komma (sofern kommaIsTriggered = false) sein so muss das Zeichen gelöscht werden (außnahme Mathezeichen da dies eine neue Variable einleitet)
         Ist dies erledigt muss die erste Zahl in der ersten Variablen gespeichert werden -> varOne
         der Check ob es eine Zahl oder ein komma ist muss bei jedem Tastendruck ausgeführt werden.-> Komma darf nur einmal pro Zahl genutzt werden -> kommaTriggered == true -> muss nach Mathezeichen reseteted werden -> kommaTriggered = false;
         Vorzeichen müssen gesperrt sein bis eine Zahl eingegeben wurde. -> danach muss firstSignTriggered = false; damit müssen die +-*div buttons wieder freigegeben werden
         Wird nach einem Vorzeichen ein Komma gesetzt muss die erste Zahl automatisch 0 sein -> dies muss jedes mal gecheckt werden solang kommaIsTriggered = false;
         wird abschließend ein Mathezeichen eingegeben wird die Zahl in varOne gespeichert.
         danach muss gecheckt werden ob das nächste Zeichen eine Zahl ist oder ein anderes Mathezeichen, bei anderem Mathezeichen wird das aktuelle überschrieben -> pMMD
         ist es eine Zahl wird das aktuelle Mathezeichen gespeichert. -> pMMD bleibt unverändert
         ab hier wird gecheckt ob jedes weitere zeichen eine Zahl ist sollte dies der Fall sein wird die varTwo weitergeschrieben -> varTwo + aktuelles Zeichen -> sollte es sich nicht um eine Zahl oder ein Komma handel (sofern kommaIsTriggered == false) so muss dieses Zeichen gelöscht werden -> dies wird wiederholt bis der user Enter drückt (dann wird das ergebnis der von Mathezeichen bestimmten arethmetik ausgegeben) -> Sollte der User nach der zweiten Variablen ein weiteres Mathezeichen eingeben so muss davon ausgegangen werden der User möchte mit dem ergebnis der ersten beiden Variablen und diesem Mathezeichen weiterrechnen.
         Ist die eingabe Enter wird varOne und varTwo in form von Mathezeichen ausgerechnet in finalVar sowie varOne gespeichert und ausgegeben.
         ab hier kann mit varOne von vorne gerechnet werden.
         Es sollte jederzeit mit ESC möglich sein den kompletten Vorgang abzubrechen. -> ESC löscht alle Variablen und setzt den Display zurück */


        @FXML
        public void b1Pressed()
        {
            firstSignIsTriggered();
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("one-button"));
        }

        @FXML
        public void b2Pressed()
        {
             String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
             calcDisplay.setText(temp+ bundle.getString("two-button"));
        }

        @FXML
        public void b3Pressed()
        {
           String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
           calcDisplay.setText(temp+ bundle.getString("three-button"));
        }

        @FXML
        public void b4Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("four-button"));
        }

        @FXML
        public void b5Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("five-button"));
        }

        @FXML
        public void b6Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("six-button"));
        }

        @FXML
        public void b7Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("seven-button"));
        }

        @FXML
        public void b8Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("aight-button"));
        }

        @FXML
        public void b9Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("nine-button"));
        }

        @FXML
        public void b0Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            calcDisplay.setText(temp+ bundle.getString("zero-button"));
        }

        @FXML
        public void bEnterPressed()
        {

        }

        @FXML
        public void bESCPressed()
        {
            calcDisplay.setText("");
        }

        @FXML
        public void bPlusPressed()
        {
            firstSignIsTriggered();
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            varOne = temp;
            calcDisplay.setText(bundle.getString("plus-button"));
            pMMD = bundle.getString("plus-button");
            onPMMDPressed(pMMD);

            tempDisplay.setText(varOne + " " + pMMD + " ");

            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bMinusPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            varOne = temp;
            calcDisplay.setText(bundle.getString("minus-button"));
            pMMD = bundle.getString("minus-button");
            onPMMDPressed(pMMD);


            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bMultiplyPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            varOne = temp;
            calcDisplay.setText(bundle.getString("multiply-button"));
            pMMD = bundle.getString("multiply-button");
            onPMMDPressed(pMMD);


            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bDivPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            deleteDisplay(temp);
            varOne = temp;
            calcDisplay.setText(bundle.getString("div-button"));
            pMMD = bundle.getString("div-button");
            onPMMDPressed(pMMD);


            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bPunktPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText("");
            calcDisplay.setText(temp+ bundle.getString("point"));
        }


        private String deleteDisplay(String temp)
        {
            if (calcDisplay.getText() == "+")
            {
                temp = "";
                return temp;
            }
            else if (calcDisplay.getText() == "*")
            {
                temp = "";
                return temp;
            }
            else if (calcDisplay.getText() == "-")
            {
                temp = "";
                return temp;
            }
            else if (calcDisplay.getText() == "/")
            {
                temp = "";
                return temp;
            }
            else
            {
                temp = "NULL";
                return temp;
            }
        }


        //Getter and Setter Methods
    public Button getOneButton()
    {
        return oneButton;
    }
    public Button getAightButton()
    {
        return aightButton;
    }
    public Button getDivButton()
    {
        return divButton;
    }
    public Button getEnterButton()
    {
        return enterButton;
    }
    public Button getEscButton()
    {
        return escButton;
    }
    public Button getFiveButton()
    {
        return fiveButton;
    }
    public Button getFourButton()
    {
        return fourButton;
    }
    public Button getMinusButton()
    {
        return minusButton;
    }
    public Button getMultiplyButton()
    {
        return multiplyButton;
    }
    public Button getNineButton()
    {
        return nineButton;
    }
    public Button getPlusButton()
    {
        return plusButton;
    }
    public Button getPointButton()
    {
        return pointButton;
    }
    public Button getSevenButton()
    {
        return sevenButton;
    }
    public Button getSixButton()
    {
        return sixButton;
    }
    public Button getThreeButton()
    {
        return threeButton;
    }
    public Button getTwoButton()
    {
        return twoButton;
    }
    public Button getZeroButton()
    {
        return zeroButton;
    }
    public TextField getCalcDisplay()
    {
        return calcDisplay;
    }
    public void setAightButton(Button aightButton)
    {
        this.aightButton = aightButton;
    }
    public void setCalcDisplay(TextField calcDisplay)
    {
        this.calcDisplay = calcDisplay;
    }
    public void setDivButton(Button divButton)
    {
        this.divButton = divButton;
    }
    public void setEnterButton(Button enterButton)
    {
        this.enterButton = enterButton;
    }
    public void setEscButton(Button escButton)
    {
        this.escButton = escButton;
    }
    public void setFiveButton(Button fiveButton)
    {
        this.fiveButton = fiveButton;
    }
    public void setFourButton(Button fourButton)
    {
        this.fourButton = fourButton;
    }
    public void setMinusButton(Button minusButton)
    {
        this.minusButton = minusButton;
    }
    public void setMultiplyButton(Button multiplyButton)
    {
        this.multiplyButton = multiplyButton;
    }
    public void setNineButton(Button nineButton)
    {
        this.nineButton = nineButton;
    }
    public void setOneButton(Button oneButton)
    {
        this.oneButton = oneButton;
    }
    public void setPlusButton(Button plusButton)
    {
        this.plusButton = plusButton;
    }
    public void setPointButton(Button pointButton)
    {
        this.pointButton = pointButton;
    }
    public void setSevenButton(Button sevenButton)
    {
        this.sevenButton = sevenButton;
    }
    public void setSixButton(Button sixButton)
    {
        this.sixButton = sixButton;
    }
    public void setThreeButton(Button threeButton)
    {
        this.threeButton = threeButton;
    }
    public void setTwoButton(Button twoButton)
    {
        this.twoButton = twoButton;
    }
    public void setZeroButton(Button zeroButton)
    {
        this.zeroButton = zeroButton;
    }
}
