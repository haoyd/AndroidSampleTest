package com.sample.gofdemo.建造者模式;

/**
 * 抽象建造者
 * Created by haoyundong on 2016/11/3.
 */

public interface Builder {
    void buildPartA();
    void buildPartB();
    Product getResult();
}
