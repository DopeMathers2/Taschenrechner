package de.dopemathers.taschenrechner;

public class Calculate
{
    private double result;

    public double addition(double value1,double value2)
    {
        result = value1 + value2;
        return result;
    }

    public double substract(double value1,double value2)
    {
        result = value1 - value2;
        return result;
    }

    public double multiply(double value1,double value2)
    {
        result = value1 * value2;
        return result;
    }

    public double division(double value1,double value2)
    {
        result = value1 / value2;
        return result;
    }

}