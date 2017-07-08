package com.zhimazg.javatest.type;

/**
 * Created by haoyundong on 2016/12/12.
 */

public abstract class Animal {
    public abstract void eat();

    @Override
    public String toString() {
        String className = this.getClass().getSimpleName();

        return className;
    }
}
