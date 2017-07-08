package com.sample.gofdemo.建造者模式;

/**
 * 具体建造者
 * Created by haoyundong on 2016/11/3.
 */

public class Builder1 implements Builder {
    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件1");
    }

    @Override
    public void buildPartB() {
        product.add("部件2");
    }

    @Override
    public Product getResult() {
        return product;
    }


}
