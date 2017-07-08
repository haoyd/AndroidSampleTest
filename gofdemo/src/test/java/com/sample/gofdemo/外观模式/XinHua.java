package com.sample.gofdemo.外观模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class XinHua {

    public void methodA(){
        System.out.println();
        System.out.println("新华：用A计划来完成任务");
        System.out.println("     |");
        System.out.println("     v");


        new MengChen().doWork();
    }

    public void methodB(){
        System.out.println();
        System.out.println("新华：用B计划来完成任务");
        System.out.println("     |");
        System.out.println("     v");


        new FaShuai().doWork();
        new MengChen().doWork();
    }
}
