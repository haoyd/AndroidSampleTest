package com.sample.gofdemo.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class IteratorSample1 {

    public void client() {
        ConcreteAgreegate ca = new ConcreteAgreegate();
        ca.add("小红");
        ca.add("小白");
        ca.add("小绿");
        ca.add("小青");
        ca.add("小黄");
        ca.add("小棕");

        MyIterator myIterator = new ConcreteIterator(ca);

        String a = myIterator.first();
        while (!myIterator.isDone()) {
            System.out.println(myIterator.currentItem() + "请买票");
            myIterator.next();
        }


    }


    abstract class MyIterator {
        public abstract String first();

        public abstract String next();

        public abstract boolean isDone();

        public abstract String currentItem();
    }

    abstract class Agreegate {
        public abstract MyIterator createIterator();
    }

    class ConcreteIterator extends MyIterator{
        private ConcreteAgreegate concreteAgreegate;

        private int current = 0;

        public ConcreteIterator(ConcreteAgreegate concreteAgreegate) {
            this.concreteAgreegate = concreteAgreegate;
        }

        @Override
        public String first() {
            return concreteAgreegate.getItem(0);
        }

        @Override
        public String next() {
            current ++;
            return null;
        }

        @Override
        public boolean isDone() {
            return current >= concreteAgreegate.list.size();
        }

        @Override
        public String currentItem() {
            return concreteAgreegate.getItem(current);
        }
    }

    class ConcreteAgreegate extends Agreegate{

        public List<String> list = new ArrayList<String>();

        @Override
        public MyIterator createIterator() {
            return new ConcreteIterator(this);
        }

        public String getItem(int index) {
            return list.get(index);
        }

        public void add(String item) {
            list.add(item);
        }
    }


}
