package com.sample.gofdemo.策略模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algorithmInterface();
    }

}
