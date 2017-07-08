package com.sample.gofdemo.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 2016/11/5.
 */

public class ObserverSample1 {

    public void client() {
        Subject observer = new ConcreteSubject();
        observer.attach(new ConcreteObserver());
        observer.attach(new ConcreteObserver2());

        observer.toNotify();
    }


    private interface Subject{
        void attach(Observer observer);
        void detach(Observer observer);
        void toNotify();
    }

    private interface Observer {
        void update();
    }

    class ConcreteSubject implements Subject{
        List<Observer> list = new ArrayList<Observer>();

        @Override
        public void attach(Observer observer) {
            list.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            list.remove(observer);
        }

        @Override
        public void toNotify() {
            if (list != null && list.size() > 0) {
                for (Observer observer : list) {
                    observer.update();
                }
            }
        }
    }

    class ConcreteObserver implements Observer{

        private int observerState;

        @Override
        public void update() {
            System.out.println("Marry已接收到你的通知");
        }
    }

    class ConcreteObserver2 implements Observer{

        private int observerState;

        @Override
        public void update() {
            System.out.println("Wade已接收到你的通知");
        }
    }



}
