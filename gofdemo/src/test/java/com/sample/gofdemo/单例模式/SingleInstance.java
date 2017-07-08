package com.sample.gofdemo.单例模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class SingleInstance {

    private SingleInstance(){
        try {
            Thread.sleep(100);
            System.out.println("Thread----" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //*********************************  懒汉式 start  ************************************************************

    private static SingleInstance singleInstance;

    public synchronized static SingleInstance getInstance() {
        if (singleInstance == null) {

            System.out.println("实例：：：" );
            singleInstance = new SingleInstance();
            System.out.println("实例：：：" + singleInstance);
        }

        return singleInstance;
    }


    //**********************************  懒汉式 end  ***********************************************************




    //**********************************  饿汉式 start  ***********************************************************


    private static SingleInstance singleInstance2 = new SingleInstance();

    public static SingleInstance getInstance2() {
        return singleInstance;
    }

    //**********************************  饿汉式 end  ***********************************************************



    //**********************************  同步锁 start  ***********************************************************

    private static SingleInstance singleInstance3;


    public static SingleInstance getInstance3() {
        synchronized (SingleInstance.class) {
            if (singleInstance3 == null) {
                singleInstance3 = new SingleInstance();
            }
        }
        return singleInstance3;
    }

    //**********************************  同步锁 end  ***********************************************************



    //**********************************  双重同步锁 start  ***********************************************************

    private static SingleInstance singleInstance4;

    public static SingleInstance getInstance4() {
        if (singleInstance4 == null) {
            synchronized (SingleInstance.class) {
                if (singleInstance4 == null) {
                    singleInstance4 = new SingleInstance();
                }
            }
        }
        return singleInstance4;
    }

    //**********************************  双重同步锁 end  ***********************************************************



    public void show() {
        System.out.println("我是单例模式");
    }





}
