package com.sample.gofdemo.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 16/9/24.
 */

public class BuilderModel {



    class Product{
        List<String> parts = new ArrayList<String>();

        public void add(String part){
            parts.add(part);
        }

        public void show(){
            for(String s : parts){
                System.out.print(s);
            }
        }

    }

    /**
     * 抽象建造者
     */
    abstract class Builder{
        public abstract void buildPartA();
        public abstract void buildPartB();
        public abstract Product getResult();
    }

    /**
     * 具体建造者类
     */
    class Builder1 extends Builder{
        Product product = new Product();

        @Override
        public void buildPartA() {
            product.add("部件A");
        }

        @Override
        public void buildPartB() {
            product.add("部件B");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    /**
     * 具体建造者类
     */
    class Builder2 extends Builder{
        Product product = new Product();

        @Override
        public void buildPartA() {
            product.add("部件X");
        }

        @Override
        public void buildPartB() {
            product.add("部件Y");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    /**
     * 指挥类
     */
    class Director{
        public Director(Builder builder){
            builder.buildPartA();
            builder.buildPartB();
        }
    }

    /**
     * 客户端调用
     */
    class Client{

        public void main(){
            //请2个建造者，每个建造者都有2项技能
            Builder b1 = new Builder1();
            Builder b2 = new Builder2();

            //请2个指挥者，每个指挥者可以指挥建造者建造哪些东西
            Director director1 = new Director(b1);
            Director director2 = new Director(b2);

            //把你建造的东西给我一下
            Product p1 = b1.getResult();
            //我看看
            p1.show();

            //把你建造的东西也给我一下
            Product p2 = b2.getResult();
            //我看看
            p2.show();
        }
    }



}
