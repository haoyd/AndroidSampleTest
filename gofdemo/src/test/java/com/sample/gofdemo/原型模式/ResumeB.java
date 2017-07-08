package com.sample.gofdemo.原型模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class ResumeB extends ProtoResume {


    public ResumeB(String name, int age) {
        super(name, age);
    }

    @Override
    public ProtoResume clone() {

        return memberwiseClone();
    }

    private ProtoResume memberwiseClone() {
        /**
         * 创建当前对象的浅表副本。
         * 方法是创建一个新对象，然后将当前对象的非静态字段复制到该对象。
         * 如果字段是值类型，则对该字段执行逐行复制；如果字段是引用类型，则复制引用但不复制引用对象；
         * 因此，原始对象及其副本引用同一对象
         */
        String name = getName();
        int age = getAge();
        ResumeB resumeB = new ResumeB(name, age);

        return resumeB;
    }
}
