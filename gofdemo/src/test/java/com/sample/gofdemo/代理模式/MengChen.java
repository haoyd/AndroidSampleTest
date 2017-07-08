package com.sample.gofdemo.代理模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class MengChen implements GiftGive {

    private String girl;


    public MengChen(String name) {
        girl = name;
    }

    @Override
    public void giveDoll() {
        System.out.println(girl + "，我要送你个洋娃娃");
    }

    @Override
    public void giveFood() {
        System.out.println(girl + "，我要送你个蛋糕");

    }
}
