package com.sample.gofdemo.单例设计模式;

import android.app.Application;

/**
 * Created by haoyundong on 16/9/24.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication = null;

    /**
     * 构造函数私有
     */
    private MyApplication(){}

    /**
     * 懒汉式
     * @return
     */
    public static synchronized MyApplication getInstance(){

        if(myApplication == null){
            myApplication = new MyApplication();
        }

        return myApplication;



    }








}
