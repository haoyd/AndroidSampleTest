package com.sample.gofdemo.模板方法模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class TestPaperB extends TestPaper {

    public TestPaperB(String name) {
        System.out.println();
        System.out.println(name + "的试卷：");
    }

    @Override
    public void answer1() {
        question1();
        System.out.println("答案是：C");
    }

    @Override
    public void answer2() {
        question2();
        System.out.println("答案是：D");

    }
}
