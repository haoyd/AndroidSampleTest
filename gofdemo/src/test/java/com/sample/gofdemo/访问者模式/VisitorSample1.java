package com.sample.gofdemo.访问者模式;

/**
 * Created by haoyundong on 2016/11/9.
 */

public class VisitorSample1 {

    public void client() {
        Person man = new Man();
        Person woman = new Woman();

        State success = new Sucsess();
        State fail = new Fail();

        man.accept(success);
        woman.accept(success);

        man.accept(fail);
        woman.accept(fail);



    }

    abstract class Person {

        public abstract void accept(State state);
    }

    abstract class State {

        public abstract void getManConclusion();
        public abstract void getWomanConclusion();

    }

    class Man extends Person {
        @Override
        public void accept(State state) {
            state.getManConclusion();
        }
    }

    class Woman extends Person {
        @Override
        public void accept(State state) {
            state.getWomanConclusion();
        }
    }

    class Sucsess extends State {

        @Override
        public void getManConclusion() {
            System.out.println("男人成功时，背后多半有一个伟大的女人");
        }

        @Override
        public void getWomanConclusion() {
            System.out.println("女人成功时，背后多半有一个不成功的男人");

        }
    }

    class Fail extends State {

        @Override
        public void getManConclusion() {
            System.out.println("男人失败时，闷头喝酒，谁也不用劝");

        }

        @Override
        public void getWomanConclusion() {
            System.out.println("女人失败时，眼泪汪汪，谁也劝不了");

        }
    }










}
