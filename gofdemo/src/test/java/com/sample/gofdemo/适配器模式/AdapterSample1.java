package com.sample.gofdemo.适配器模式;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class AdapterSample1 {


    public void client() {
        Player mac = new Forwards("麦迪");
        Player yao = new Translater("姚明");

        mac.attack();
        yao.defense();
    }

    abstract class Player {
        protected String name;

        public Player(String name) {
            this.name = name;
        }

        abstract void attack();

        abstract void defense();
    }

    class Forwards extends Player {

        public Forwards(String name) {
            super(name);
        }

        @Override
        public void attack() {
            System.out.println("前锋" + name + "进攻");
        }

        @Override
        public void defense() {
            System.out.println("前锋" + name + "防守");

        }
    }

    class Center extends Player {

        public Center(String name) {
            super(name);
        }

        @Override
        public void attack() {
            System.out.println("中锋" + name + "进攻");
        }

        @Override
        public void defense() {
            System.out.println("中锋" + name + "防守");

        }
    }

    class ForeignCenter {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void 进攻() {
            System.out.println("外籍中锋" + name + "进攻");
        }

        public void 防守() {
            System.out.println("外籍中锋" + name + "防守");
        }
    }

    class Translater extends Player{
        private ForeignCenter fc = new ForeignCenter();

        public Translater(String name) {
            super(name);
            fc.setName(name);
        }

        @Override
        void attack() {
           fc.进攻();
        }

        @Override
        void defense() {
           fc.防守();
        }



    }






}
