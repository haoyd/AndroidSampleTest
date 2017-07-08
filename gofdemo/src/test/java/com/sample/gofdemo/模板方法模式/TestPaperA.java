package com.sample.gofdemo.模板方法模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class TestPaperA extends TestPaper {

    public TestPaperA(String name) {
        System.out.println(name + "的试卷：");
    }

    @Override
    public void answer1() {
        question1();
        System.out.println("答案是：A");
    }

    @Override
    public void answer2() {
        question2();
        System.out.println("答案是：B");

    }
}
