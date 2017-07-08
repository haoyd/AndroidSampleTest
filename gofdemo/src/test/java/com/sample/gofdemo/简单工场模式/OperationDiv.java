package com.sample.gofdemo.简单工场模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class OperationDiv extends Operation {

    @Override
    public double getResult(double number1, double number2) {
        double result = 0;

        try {
            result = number1 /number2;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
