package com.sample.gofdemo.原型模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public abstract class ProtoResume {

    private String name;
    private int age;

    public ProtoResume(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void display() {
        System.out.println("姓名：" + name + "   性别：" + age);
    }


    public abstract ProtoResume clone();




    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
