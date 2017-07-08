package com.sample.gofdemo.简单工场模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class OperationRedu extends Operation {

    @Override
    public double getResult(double number1, double number2) {
        double result = 0;
        result = number1 - number2;

        return result;
    }
}
