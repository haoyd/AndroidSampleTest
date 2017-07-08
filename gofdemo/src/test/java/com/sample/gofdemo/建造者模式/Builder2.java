package com.sample.gofdemo.建造者模式;

/**
 * 具体建造者
 * Created by haoyundong on 2016/11/3.
 */

public class Builder2 implements Builder {
    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
