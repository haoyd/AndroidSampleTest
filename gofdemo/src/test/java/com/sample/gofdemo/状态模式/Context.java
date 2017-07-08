package com.sample.gofdemo.状态模式;

/**
 * Created by haoyundong on 2016/11/7.
 */

public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态：" + state.getClass().getName());
    }

    public void request() {
        state.handle(this);
    }
}
