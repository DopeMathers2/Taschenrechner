package de.dopemathers.taschenrechner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

public class UserInputs
{


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


        //Buttons pressed methods
        @FXML
        public void b1Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("one-button"));
        }

        @FXML
        public void b2Pressed()
        {
             String temp = calcDisplay.getText();
             calcDisplay.setText(temp+ bundle.getString("two-button"));
        }

        @FXML
        public void b3Pressed()
        {
           String temp = calcDisplay.getText();
           calcDisplay.setText(temp+ bundle.getString("three-button"));
        }

        @FXML
        public void b4Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("four-button"));
        }

        @FXML
        public void b5Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("five-button"));
        }

        @FXML
        public void b6Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("six-button"));
        }

        @FXML
        public void b7Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("seven-button"));
        }

        @FXML
        public void b8Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("aight-button"));
        }

        @FXML
        public void b9Pressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("nine-button"));
        }

        @FXML
        public void b0Pressed()
        {
            String temp = calcDisplay.getText();
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
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("plus-button"));
        }

        @FXML
        public void bMinusPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("minus-button"));
        }

        @FXML
        public void bMultiplyPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("multiply-button"));
        }

        @FXML
        public void bDivPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("div-button"));
        }

        @FXML
        public void bPunktPressed()
        {
            String temp = calcDisplay.getText();
            calcDisplay.setText(temp+ bundle.getString("point"));
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
