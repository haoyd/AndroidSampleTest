package com.sample.gofdemo.简单工场模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class OperationFactory {

    public static Operation createOperation(String ope) {
        Operation operation = null;

        switch (ope) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationRedu();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }

}
