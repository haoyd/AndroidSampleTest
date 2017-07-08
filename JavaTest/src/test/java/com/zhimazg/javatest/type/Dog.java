package com.zhimazg.javatest.type;

/**
 * Created by haoyundong on 2016/12/12.
 */

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("I am dog, I can eat.");
    }

    public void call() {
        System.out.println("I am dog, I can call");

    }

}
