package com.sample.gofdemo.模板方法模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public abstract class TestPaper {

    public void question1() {
        System.out.println("1 + 1 = ?");
        System.out.println("A: 2  B: 3  C: 4  D: 5");
    }

    public abstract void answer1();

    public void question2() {
        System.out.println("2 + 2 = ?");
        System.out.println("A: 2  B: 3  C: 4  D: 5");
    }

    public abstract void answer2();


}
