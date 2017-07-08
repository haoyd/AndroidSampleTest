package com.sample.gofdemo.装饰模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class ConcreteDecorator1 extends Decorator {

    private String addState;

    @Override
    public void operation() {
        super.operation();
        addState = "new state";
        System.out.println("穿条裤子");

    }
}
