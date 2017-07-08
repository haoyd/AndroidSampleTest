package com.zhimazg.javatest.持有对象;

/**
 * Created by haoyundong on 2016/12/9.
 */

public class ObjectHolder {

    public void client() {
        FanXing<String> fanXing = new FanXing<String>();
        fanXing.print("haha");


    }



    class FanXing<T>{
        public void print(T t) {
            System.out.println(t);
        }
    }

}
