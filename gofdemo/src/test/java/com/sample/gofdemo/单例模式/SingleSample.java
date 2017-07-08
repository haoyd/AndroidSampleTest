package com.sample.gofdemo.单例模式;

/**
 * Created by haoyundong on 2016/11/4.
 */

public class SingleSample {

    public void show() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i ++) {
                    System.out.println("show:" + i);
                }
            }
        }).start();
    }
}
