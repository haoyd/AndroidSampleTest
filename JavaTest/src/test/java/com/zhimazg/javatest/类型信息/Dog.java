package com.zhimazg.javatest.类型信息;

/**
 * Created by haoyundong on 2016/11/24.
 */

public class Dog implements Animal {
    @Override
    public void doWork() {
        System.out.println("I can call !");
    }

    public void otherAbility() {
        System.out.println("Haha, I catch catch mouse too !");
    }
}
