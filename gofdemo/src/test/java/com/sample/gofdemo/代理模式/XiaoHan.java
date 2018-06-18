package com.sample.gofdemo.代理模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class XiaoHan implements GiftGive {

    private MengChen mengChen;

    public XiaoHan(String name) {
        mengChen = new MengChen(name);
    }

    @Override
    public void giveDoll() {
        mengChen.giveDoll();
    }

    @Override
    public void giveFood() {
        mengChen.giveFood();
    }
}
