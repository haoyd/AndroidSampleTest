package com.sample.gofdemo.状态模式;

/**
 * Created by haoyundong on 2016/11/7.
 */

public class State1 extends State {
    @Override
    public void handle(Context context) {
        context.setState(new State2());
    }
}
