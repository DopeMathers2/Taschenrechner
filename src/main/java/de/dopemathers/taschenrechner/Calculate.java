package de.dopemathers.taschenrechner;

public class Calculate
{
    private static double variableOne;
    private static double variableTwo;
    private static String calcString;
    private static double result;

    public static double addition(double value1,double value2)
    {
        result = value1 + value2;
        return result;
    }

    public static double substract(double value1,double value2)
    {
        result = value1 - value2;
        return result;
    }

    public static double multiply(double value1,double value2)
    {
        result = value1 * value2;
        return result;
    }

    public static double division(double value1,double value2)
    {
        result = value1 / value2;
        return result;
    }


    //Setter and Getter Methods
    public static double getVariableOne()
    {
        return variableOne;
    }
    public static void setVariableOne(double variableOne)
    {
        Calculate.variableOne = variableOne;
    }
    public static double getVariableTwo()
    {
        return variableTwo;
    }
    public static void setVariableTwo(double variableTwo)
    {
        Calculate.variableTwo = variableTwo;
    }
    public static String getCalcString()
    {
        return calcString;
    }
    public static void setCalcString(String calcString)
    {
        Calculate.calcString = calcString;
    }
}