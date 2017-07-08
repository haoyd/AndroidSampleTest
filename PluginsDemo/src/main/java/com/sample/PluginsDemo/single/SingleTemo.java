package com.sample.PluginsDemo.single;

public class SingleTemo {

    private static volatile SingleTemo singleton;

    private SingleTemo() {
    }

    public static SingleTemo getInstance() {
        if (singleton == null) {
            synchronized (SingleTemo.class) {
                if (singleton == null) {
                    singleton = new SingleTemo();
                }
            }
        }
        return singleton;
    }
}