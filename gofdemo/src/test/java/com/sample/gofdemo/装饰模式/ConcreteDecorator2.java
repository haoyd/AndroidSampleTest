package com.sample.gofdemo.装饰模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class ConcreteDecorator2 extends Decorator {

    @Override
    public void operation() {
        super.operation();
        addBehavior();

    }

    private void addBehavior() {
        System.out.println("穿个外套");
    }
}
