package com.zhimazg.javatest.type;

/**
 * Created by haoyundong on 2016/12/12.
 */

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("I am cat , I can eat");
    }

    public void catchMouse() {
        System.out.println("I am cat , I can catch mouse");

    }
}
