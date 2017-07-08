package com.sample.gofdemo.装饰模式;

/**
 * Created by haoyundong on 2016/11/3.
 */

public class DecorateExample {

    public void client() {
        Finery finery1 = new TShirt();
        Finery finery2 = new Shoes();

        finery2.decorate(finery1);
        finery2.show();
    }

    /**
     * 人
     */
    abstract class Person {

        protected String name;

        Person(){}

        Person(String name) {
            this.name = name;
            System.out.println("我是" + name);
        }

        public abstract void show();

    }

    /**
     * 服务类
     */
    class Finery extends Person{
        protected Person component;

        public void decorate(Person component) {
            this.component = component;
        }

        @Override
        public void show() {
            if (component != null) {
                component.show();
            }
        }
    }

    /**
     * T恤
     */
    class TShirt extends Finery {

        @Override
        public void show() {
            super.show();

            System.out.println("穿个T恤");
        }
    }

    /**
     * T恤
     */
    class Shoes extends Finery {

        @Override
        public void show() {
            super.show();

            System.out.println("穿双鞋");
        }
    }
}
