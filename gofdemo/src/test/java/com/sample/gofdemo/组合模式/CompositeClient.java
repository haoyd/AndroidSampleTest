package com.sample.gofdemo.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class CompositeClient {

    public void client() {
        Component head = new Head();
        Component handan = new Handan();
        Component beijing = new Beijing();

        head.add(handan);
        head.add(beijing);

        head.display();

    }


    interface Component {

        void add(Component component);

        void remove(Component component);

        void display();
    }

    class Head implements Component{

        List<Component> datas = new ArrayList<>();

        @Override
        public void add(Component component) {
            datas.add(component);
        }

        @Override
        public void remove(Component component) {
            datas.remove(component);
        }

        @Override
        public void display() {
            System.out.println("全国总部");
            for (Component component : datas) {
                component.display();
            }
        }
    }

    class Handan implements Component{

        List<Component> datas = new ArrayList<>();

        @Override
        public void add(Component component) {
            datas.add(component);
        }

        @Override
        public void remove(Component component) {
            datas.remove(component);
        }

        @Override
        public void display() {
            System.out.println("--邯郸分公司");
        }
    }

    class Beijing implements Component{

        List<Component> datas = new ArrayList<>();

        @Override
        public void add(Component component) {
            datas.add(component);
        }

        @Override
        public void remove(Component component) {
            datas.remove(component);
        }

        @Override
        public void display() {
            System.out.println("--北京分公司");

        }
    }




}
