package com.sample.gofdemo.备忘录模式;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class MementoSample1 {

    public void client() {
        Role mc = new Role("孟晨");
        mc.showBlood();

        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(mc.getState());

        mc.fight();
        mc.showBlood();

        mc.setState(careTaker.getMemento());
        mc.showBlood();



    }

    class Role{

        private int blood = 100;
        private String name;

        public Role(String name) {
            this.name = name;
        }

        public Memento getState() {
            return new Memento(blood);
        }

        public void setState(Memento memento) {
            blood = memento.getBlood();
        }

        public void fight() {
            System.out.println(name + "开始打怪兽...");
            blood = 0;
        }

        public void showBlood() {
            System.out.println(name + "的剩余血量为：" + blood);
        }

    }

    class Memento {

        private int blood = 100;

        public Memento(int blood) {
            this.blood = blood;
        }

        public int getBlood() {
            return blood;
        }

        public void setBlood(int blood) {
            this.blood = blood;
        }
    }


    class CareTaker {

        private Memento memento;

        public Memento getMemento() {
            System.out.println("获取存档...");
            return memento;
        }

        public void setMemento(Memento memento) {
            System.out.println("存档...");
            this.memento = memento;
        }
    }



}
