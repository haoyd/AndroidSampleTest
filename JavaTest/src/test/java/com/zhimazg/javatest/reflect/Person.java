package com.zhimazg.javatest.reflect;

/**
 * Created by haoyundong on 2016/12/13.
 */

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println("I am " + name + " , I am eating " + food);
    }

    public void play() {
        System.out.println("I am " + name + " , I am playing basketball");
    }

    static {
        System.out.println("Person类静态参数初始化");
    }
}
