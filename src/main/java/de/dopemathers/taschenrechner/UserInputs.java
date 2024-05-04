package de.dopemathers.taschenrechner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class UserInputs
{


        private String sC = "N";

        //Mathelogic Variables
        private static String pMMD;
        private static boolean pMMDTriggered = false;

        private static String varOne = "";
        private static boolean varOneTriggered = false;
        private static String firstSign = "+";
        private static boolean firstSignTriggered = false;

        private static String varTwo = "";
        private static boolean varTwoTriggered = false;
        private static String secondSign;
        private static boolean secondSignTriggered = false;

        private static String result;
        private static boolean enterTriggered = false;

        private static boolean escTriggered = false;
        private static boolean pointTriggered = false;

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

        public static TextField calcDisplayPublic;
        public static Label tempDisplayPublic;

        @FXML
        public void initialize()
        {
            UserInputs.calcDisplayPublic = calcDisplay;
            UserInputs.tempDisplayPublic = tempDisplay;
        }

        public void initTextField()
        {
            calcDisplay.setMouseTransparent(true);
            calcDisplay.setFocusTraversable(false);
        }

        //funktioniert fenster muss nur noch logic bekommen und aufgehübscht werden.
        @FXML
        private void onAboutPressed() throws IOException {
            Stage stg = new Stage();
            stg.setResizable(false);
            stg.setHeight(600);
            stg.setWidth(800);

            FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("aboutWindow.fxml"));

            //noinspection deprecation
            fxmlLoader.setResources(ResourceBundle.getBundle("lang", Calculator.actualLocale));
            bundle = fxmlLoader.getResources();
            stg.setTitle(bundle.getString("abt-window-title"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 430);

            String  style= Calculator.class.getResource("styles/" + Calculator.getStyle()).toExternalForm();
            scene.getStylesheets().add(style);
            stg.getIcons().add(Calculator.getImg16());
            stg.getIcons().add(Calculator.getImg32());
            stg.getIcons().add(Calculator.getImg64());
            stg.getIcons().add(Calculator.getImg128());
            stg.getIcons().add(Calculator.getImg256());
            stg.getIcons().add(Calculator.getImg512());
            stg.setScene(scene);

            stg.show();

        }

        //wieso können die designs nur einmal geswapt werden?
        @FXML
        private void onWhiteModePressed()
        {
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-whitemode.css");
            Calculator.setStyle("taschenrechner-whitemode.css");
        }
        @FXML
        private void onDarkModePressed()
        {
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-darkmode.css");
            Calculator.setStyle("taschenrechner-darkmode.css");
        }
        @FXML
        private void onGreenModePressed()
        {
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-greenmode.css");
            Calculator.setStyle("taschenrechner-greenmode.css");
        }
        @FXML
        private void onRedModePressed()
        {
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-redmode.css");
            Calculator.setStyle("taschenrechner-redmode.css");
        }

        @FXML
        private void onEngPressed() throws IOException
        {
            Calculator.setLanguage("en","EN");
        }

        @FXML
        private void onGerPressed() throws IOException
        {
            Calculator.setLanguage("de","DE");
        }

        @FXML
        private void onClosePressed()
        {
            Calculator.exitApp();
        }

        @FXML
        private void onMinPressed()
        {
           Calculator.minApp();
        }

        @FXML
        private void onMaxPressed()
        {
            Calculator.maxApp(); // funktioniert, möglichkeit aus Vollbild zu kommen einbauen
        }


        private boolean isDigit(String num)
        {
            if(num.equalsIgnoreCase("1") || num.equalsIgnoreCase("2")
                    || num.equalsIgnoreCase("3") || num.equalsIgnoreCase("4")
                    || num.equalsIgnoreCase("5") || num.equalsIgnoreCase("6")
                    || num.equalsIgnoreCase("7") || num.equalsIgnoreCase("8")
                    || num.equalsIgnoreCase("9") || num.equalsIgnoreCase("0"))
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        private boolean isPoint(String num)
        {
            if (num.equalsIgnoreCase(".") || num.equalsIgnoreCase(","))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private boolean isMathsign(String num)
        {
            if(num.equalsIgnoreCase("+") || num.equalsIgnoreCase("-")
                    || num.equalsIgnoreCase("*") || num.equalsIgnoreCase("/"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private boolean isEnter(String num)
        {
            if (num.equalsIgnoreCase("="))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /*Buttons pressed methods
         Wenn button gedrückt wird muss entschieden werden ob Minus oder Plus als vorzeichen stehen -> Sollte Nutzer hier etwas falsches eingeben sollte von + ausgegangen werden, der Bildschrim gelöscht werden und der Test von Vorne beginnen bis Nutzer eine Zahl eingibt.
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


        public static void writeDisplay(String button)
        {
            if (firstSign.equals(null)) firstSign = "+";
            //Es muss geprüft werden ob das Vorzeichen schon gesetzt wurde
            if(!firstSignTriggered) {
                //wurde es noch nicht gesetzt muss geprüft werden ob es ein plus oder ein Minus ist
                if (firstSign.equalsIgnoreCase("+") || firstSign.equalsIgnoreCase("-")) {
                    //Es muss dann gespeichert werden indem firstSignTriggered true wird
                    firstSignTriggered = true;
                    //varOne muss 1 hinzugefügt werden
                    varOne = varOne + button;
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                } else {
                    //Ist es ein anderes Zeichen muss es auf Plus gesetzt werden
                    firstSign = "+";
                    firstSignTriggered = true;
                    varOne = varOne + button;
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                }
            }    //Sollte es bereits gesetzt sein muss geprüft werden ob varOne triggerd ist
            else if(varOneTriggered)
            {
                //Ist varOne schon getriggerd muss geprüft werden ob mathezeichen auch getriggered wurde
                if(pMMDTriggered)
                {
                    //wenn pMMDTriggered wurde muss die zahl varTwo angehangen werden
                    varTwo = varTwo + button;
                    varTwoTriggered = true;
                    calcDisplayPublic.setText(varTwo);
                    tempDisplayPublic.setText(varOne+pMMD+varTwo);
                }
                else
                {
                    //ist pMMD nicht getriggered wird es varOne angehänt.
                    varOne = varOne + button;
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                }

            }
            else
            {
                //Ist varOne noch nicht getriggered muss die Zahl an varOne angehängt werden
                varOne = varOne + button;
                calcDisplayPublic.setText(varOne);
                tempDisplayPublic.setText(varOne);
            }
        }

        @FXML
        public void b1Pressed()
        {

            writeDisplay("1");

        }

        @FXML
        public void b2Pressed()
        {
             writeDisplay("2");
        }

        @FXML
        public void b3Pressed()
        {
           writeDisplay("3");
        }

        @FXML
        public void b4Pressed()
        {
           writeDisplay("4");
        }

        @FXML
        public void b5Pressed()
        {
            writeDisplay("5");
        }

        @FXML
        public void b6Pressed()
        {
            writeDisplay("6");
        }

        @FXML
        public void b7Pressed()
        {
            writeDisplay("7");
        }

        @FXML
        public void b8Pressed()
        {
            writeDisplay("8");
        }

        @FXML
        public void b9Pressed()
        {
            writeDisplay("9");
        }

        @FXML
        public void b0Pressed()
        {
            writeDisplay("0");
        }

        private static void doMath()
        {
            Calculate clac = new Calculate();
            Double temp;

            //testcase
            temp = clac.addition(Double.parseDouble(varOne),Double.parseDouble(varTwo));
            System.out.println(temp);

            if (varTwoTriggered)
            {
                if (pMMD.equalsIgnoreCase("+"))
                {
                    temp = clac.addition(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                }
                else if (pMMD.equalsIgnoreCase("-"))
                {
                    temp = clac.addition(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                }
                else if (pMMD.equalsIgnoreCase("*"))
                {
                    temp = clac.addition(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                }
                else if (pMMD.equalsIgnoreCase("/"))
                {
                    temp = clac.addition(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(varOne);
                }
            }
        }

        @FXML
        public void bEnterPressed()
        {

            doMath();

        }

        @FXML
        public void bESCPressed()
        {
            deleteAll();
        }

        @FXML
        public void bPlusPressed()
        {
            String temp = calcDisplay.getText();
            varOne = temp;

            calcDisplay.setText(bundle.getString("plus-button"));
            pMMD = bundle.getString("plus-button");

            tempDisplay.setText(varOne + " " + pMMD + " ");
            tempDisplayPublic.setText(varOne + " " + pMMD + " ");//implement

            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bMinusPressed()
        {
            String temp = calcDisplay.getText();
            varOne = temp;
            calcDisplay.setText(bundle.getString("minus-button"));
            pMMD = bundle.getString("minus-button");
            tempDisplayPublic.setText(varOne + " " + pMMD + " ");//implement


            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bMultiplyPressed()
        {
            String temp = calcDisplay.getText();
            varOne = temp;
            calcDisplay.setText(bundle.getString("multiply-button"));
            pMMD = bundle.getString("multiply-button");
            tempDisplayPublic.setText(varOne + " " + pMMD + " ");//implement


            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bDivPressed()
        {
            String temp = calcDisplay.getText();
            varOne = temp;
            calcDisplay.setText(bundle.getString("div-button"));
            pMMD = bundle.getString("div-button");
            tempDisplayPublic.setText(varOne + " " + pMMD + " ");//implement


            //test
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        private static void writePoint()
        {
            //Wenn punkt nicht getriggered ist teste ob varOne getriggerd ist wenn nicht und der String ist ungleich "" füge "." hinzu.
            if (!pointTriggered) {
                if(!varOneTriggered){
                    if(!varOne.equalsIgnoreCase("")) {
                        varOne = varOne + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varOne);
                        tempDisplayPublic.setText(varOne);
                    }
                    else
                    {
                        varOne = "0";
                        varOne = varOne + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varOne);
                        tempDisplayPublic.setText(varOne);
                    }
                }
                else
                {
                    if(!varTwo.equalsIgnoreCase("")) {
                        varTwo = varTwo + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varTwo);
                        tempDisplayPublic.setText(varOne+pMMD+varTwo);
                    }
                    else
                    {
                        varTwo = "0";
                        varTwo = varTwo + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varTwo);
                        tempDisplayPublic.setText(varOne+pMMD+varTwo);
                    }
                }


            }
        }

        @FXML
        public void bPunktPressed()
        {
            writePoint();
        }


    public static void initKeyEvents(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if(key.getCode()== KeyCode.ENTER) {
                doMath();
                System.out.println("You pressed enter");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD1 || key.getCode()==KeyCode.DIGIT1) {
                writeDisplay("1");
                System.out.println("You pressed 1");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD2 || key.getCode()==KeyCode.DIGIT2) {
                writeDisplay("2");
                System.out.println("You pressed 2");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD3 || key.getCode()==KeyCode.DIGIT3) {
                writeDisplay("3");
                System.out.println("You pressed 3");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD4 || key.getCode()==KeyCode.DIGIT4) {
                writeDisplay("4");
                System.out.println("You pressed 4");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD5 || key.getCode()==KeyCode.DIGIT5) {
                writeDisplay("5");
                System.out.println("You pressed 5");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD6 || key.getCode()==KeyCode.DIGIT6) {
                writeDisplay("6");
                System.out.println("You pressed 6");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD7 || key.getCode()==KeyCode.DIGIT7) {
                writeDisplay("7");
                System.out.println("You pressed 7");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD8 || key.getCode()==KeyCode.DIGIT8) {
                writeDisplay("8");
                System.out.println("You pressed 8");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD9 || key.getCode()==KeyCode.DIGIT9) {
                writeDisplay("9");
                System.out.println("You pressed 9");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD0 || key.getCode()==KeyCode.DIGIT0) {
                writeDisplay("0");
                System.out.println("You pressed 0");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.MINUS) {
                System.out.println("You pressed -");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.PLUS) {
                System.out.println("You pressed +");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.MULTIPLY) {
                System.out.println("You pressed *");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.DIVIDE) {
                System.out.println("You pressed /");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.BACK_SPACE) {
                System.out.println("You pressed Löschen");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.ESCAPE) {
                deleteAll();
                System.out.println("You pressed Escape");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.DECIMAL || key.getCode()==KeyCode.PERIOD) {
                writePoint();
            }
        });
    }

    public static void deleteAll()
    {

        calcDisplayPublic.setText("");
        tempDisplayPublic.setText("");
        System.out.println("deleteAll ausgeführt!");

        varOne = "";
        varOneTriggered = false;

        varTwo = "";
        varTwoTriggered = false;

        firstSign = "+";
        firstSignTriggered = false;

        secondSign = "";
        secondSignTriggered = false;

        pMMD = "";
        pMMDTriggered = false;

        enterTriggered = false;
        pointTriggered = false;
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
