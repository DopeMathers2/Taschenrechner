package de.dopemathers.taschenrechner;

import javafx.event.Event;
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

        //Mathelogic Variables
        private static String pMMD = "";
        private static boolean pMMDTriggered = false;

        private static String varOne = "";
        private static boolean varOneTriggered = false;
        private static String firstSign = "+";
        private static boolean firstSignTriggered = false;

        private static String varTwo = "";
        private static boolean varTwoTriggered = false;
        private static String secondSign = "+";
        private static boolean secondSignTriggered = false;

        private static String result;

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
        public static Button enterPublic;

        @FXML
        public void initialize()
        {
            UserInputs.calcDisplayPublic = calcDisplay;
            UserInputs.tempDisplayPublic = tempDisplay;
            UserInputs.enterPublic = enterPublic;
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

        @FXML
        private void onWhiteModePressed() throws IOException {
            System.out.println("Whitemode");
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-whitemode.css");
            Calculator.saveStyle("taschenrechner-whitemode.css");
        }
        @FXML
        private void onDarkModePressed() throws IOException {
            System.out.println("Darkmode");
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-darkmode.css");
            Calculator.saveStyle("taschenrechner-darkmode.css");
        }
        @FXML
        private void onGreenModePressed() throws IOException {
            System.out.println("Greenmode");
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-greenmode.css");
            Calculator.saveStyle("taschenrechner-greenmode.css");
        }
        @FXML
        private void onRedModePressed() throws IOException {
            System.out.println("Redmode");
            Calculator.setStyle(calcDisplay.getScene(),"taschenrechner-redmode.css");
            Calculator.saveStyle("taschenrechner-redmode.css");
        }

        @FXML
        private void onEngPressed() throws IOException
        {
            Calculator.setLanguage("en","EN",calcDisplay.getScene());
        }

        @FXML
        private void onGerPressed() throws IOException
        {
            Calculator.setLanguage("de","DE",calcDisplay.getScene());
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

        @FXML
        private void onNegatePressed()
        {

            if (!firstSignTriggered)
            {
               if (firstSign.equalsIgnoreCase( "+"))
               {
                   firstSign = "-";
                   calcDisplay.setText(firstSign);
                   tempDisplay.setText(firstSign);
               }
               else
               {
                   firstSign = "+";
                   calcDisplay.setText(firstSign);
                   tempDisplay.setText(firstSign);
               }
            }
            else
            {
                if (secondSign.equalsIgnoreCase("+"))
                {
                    secondSign = "-";
                    calcDisplay.setText(pMMD+ secondSign);
                    tempDisplay.setText(firstSign+varOne+pMMD+secondSign);
                }
                else
                {
                    secondSign = "+";
                    calcDisplay.setText(pMMD);
                    tempDisplay.setText(firstSign+varOne+pMMD);
                }
            }

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

        public static void writeDisplay(String button)
        {

            if (firstSignTriggered == false)
            {
                if (firstSign.equalsIgnoreCase("+") || firstSign.equalsIgnoreCase("-")) {
                    //Es muss dann gespeichert werden indem firstSignTriggered true wird
                    firstSignTriggered = true;
                    //varOne muss 1 hinzugefügt werden
                    varOne = varOne + button;
                    if(firstSign.equalsIgnoreCase("+"))calcDisplayPublic.setText(varOne);
                    else calcDisplayPublic.setText(firstSign+varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                } else {
                    //Ist es ein anderes Zeichen muss es auf Plus gesetzt werden
                    firstSign = "+";
                    firstSignTriggered = true;
                    varOne = varOne + button;
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                }
            }
            else
            {
                if(varOneTriggered == false)
                {
                    varOne = varOne + button;
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                }
                else
                {
                    if(pMMD.equalsIgnoreCase(""))
                    {
                        varOne = varOne + button;
                        calcDisplayPublic.setText(varOne);
                        tempDisplayPublic.setText(firstSign+varOne);
                    }
                    else
                    {
                        varTwo = varTwo + button;
                        calcDisplayPublic.setText(varTwo);
                        if (secondSign.equalsIgnoreCase("+"))tempDisplayPublic.setText(firstSign+varOne+pMMD+varTwo);
                        if (secondSign.equalsIgnoreCase("-"))tempDisplayPublic.setText(firstSign+varOne+pMMD+secondSign+varTwo);
                        pMMDTriggered = true;
                        System.out.println("pmmd triggered");
                    }

                }


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
                if (secondSign.equalsIgnoreCase("-")) varTwo = secondSign + varTwo;

                if (pMMD.equalsIgnoreCase("+"))
                {
                    temp = clac.addition(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                }
                else if (pMMD.equalsIgnoreCase("-"))
                {
                    temp = clac.substract(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                }
                else if (pMMD.equalsIgnoreCase("*"))
                {
                    temp = clac.multiply(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                }
                else if (pMMD.equalsIgnoreCase("/"))
                {
                    temp = clac.division(Double.parseDouble(varOne),Double.parseDouble(varTwo));
                    varOne = temp.toString();
                    calcDisplayPublic.setText(varOne);
                    tempDisplayPublic.setText(firstSign+varOne);
                }

                pMMDTriggered = false;
                pMMD = "";
                varTwoTriggered = false;
                varTwo = "";
                pointTriggered = false;

            }
        }

        @FXML
        public void bEnterPressed()
        {
            if (pMMDTriggered) {
                varTwoTriggered = true;
                doMath();
            }
        }

        @FXML
        public void bESCPressed()
        {
            deleteAll();
        }

        private static void mathsignPressed(String sign)
        {
            if (pMMDTriggered == false)
            {
                if (!firstSignTriggered)
                {
                    if (sign.equalsIgnoreCase("+") || sign.equalsIgnoreCase("-"))
                    {
                        firstSign = sign;
                        tempDisplayPublic.setText(firstSign);
                        if (firstSign.equalsIgnoreCase("-")) calcDisplayPublic.setText(firstSign);
                        else calcDisplayPublic.setText("");
                    }
                }
                else //wenn first sign triggered ist kann ich sicher sein in varOne befindet sich eine Zahl
                {
                    varOneTriggered = true;
                    pMMD = sign;
                    pointTriggered = false;
                    tempDisplayPublic.setText(firstSign+varOne+sign);
                    calcDisplayPublic.setText(sign);
                }}
            else
            {
                doMath();
            }
        }

        @FXML
        public void bPlusPressed()
        {

            mathsignPressed(bundle.getString("plus-button"));
            //test
            System.out.println("firstsign ist: " + firstSign);
            System.out.println("firstsignTriggered ist: " + firstSignTriggered);
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bMinusPressed()
        {
            mathsignPressed(bundle.getString("minus-button"));

            //test
            System.out.println("firstsign ist: " + firstSign);
            System.out.println("firstsignTriggered ist: " + firstSignTriggered);
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bMultiplyPressed()
        {
            mathsignPressed(bundle.getString("multiply-button"));

            //test
            System.out.println("firstsign ist: " + firstSign);
            System.out.println("firstsignTriggered ist: " + firstSignTriggered);
            System.out.println("varOne ist: " + varOne);
            System.out.println("pMMD ist: " + pMMD);
            System.out.println("varTwo ist: " + varTwo);
        }

        @FXML
        public void bDivPressed()
        {
            mathsignPressed(bundle.getString("div-button"));


            //test
            System.out.println("firstsign ist: " + firstSign);
            System.out.println("firstsignTriggered ist: " + firstSignTriggered);
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
                        tempDisplayPublic.setText(firstSign+varOne);
                    }
                    else
                    {
                        varOne = "0";
                        varOne = varOne + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varOne);
                        tempDisplayPublic.setText(firstSign+varOne);
                    }
                }
                else
                {
                    if(!varTwo.equalsIgnoreCase("")) {
                        varTwo = varTwo + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varTwo);
                        tempDisplayPublic.setText(firstSign+varOne+pMMD+varTwo);
                    }
                    else
                    {
                        varTwo = "0";
                        varTwo = varTwo + ".";
                        pointTriggered = true;
                        calcDisplayPublic.setText(varTwo);
                        tempDisplayPublic.setText(firstSign+varOne+pMMD+varTwo);
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
            if(key.getCode()== KeyCode.ENTER || key.getCharacter().getBytes()[0] == '\n' || key.getCharacter().getBytes()[0] == '\r')
            {
                if (pMMDTriggered) {
                    varTwoTriggered = true;
                    doMath();
                }
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
            if(key.getCode()==KeyCode.MINUS || key.getCode()==KeyCode.SUBTRACT) {
                mathsignPressed("-");
                System.out.println("You pressed -");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.ADD || key.getCode()==KeyCode.PLUS) {
                mathsignPressed("+");
                System.out.println("You pressed +");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.MULTIPLY) {
                mathsignPressed("*");
                System.out.println("You pressed *");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.DIVIDE) {
                mathsignPressed("/");
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
