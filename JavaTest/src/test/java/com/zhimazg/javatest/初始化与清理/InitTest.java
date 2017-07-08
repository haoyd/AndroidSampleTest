package com.zhimazg.javatest.初始化与清理;

/**
 * Created by haoyundong on 2016/12/7.
 */

public class InitTest {
    private int i;
    private String s1;
    private String s2 = "123";
    private String s3;
    private long l;
    private double d;
    private char c;

    public InitTest() {
        s3 = "s3...";
    }

    public void print() {
        System.out.println("int--" + i);
        System.out.println("long--" + l);
        System.out.println("double--" + d);
        System.out.println("char--" + c);
        System.out.println("String1--" + s1);
        System.out.println("String2--" + s2);
        System.out.println("String3--" + s3);
    }

    public void a() {
        System.out.println("aaa");
    }

    public void b() {
        a();
        this.a();
    }


    private static void aa() {
//        bb(); 在static内部不能调用非静态方法
    }

    private void bb() {
        aa();//在非静态方法中可以调用静态方法。
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("InitTest对象被回收");
        super.finalize();
    }


}
