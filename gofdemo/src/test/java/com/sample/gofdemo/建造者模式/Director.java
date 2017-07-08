package com.sample.gofdemo.建造者模式;

/**
 * 指挥类
 * Created by haoyundong on 2016/11/3.
 */

public class Director {
    public Director(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
