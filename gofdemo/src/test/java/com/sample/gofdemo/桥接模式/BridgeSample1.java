package com.sample.gofdemo.桥接模式;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class BridgeSample1 {

    public void client() {
        Mobile nokia = new Nokia();
        nokia.setSoftware(new Snake());
        nokia.run();
    }

    abstract class Mobile {

        protected Software software;

        public void setSoftware(Software software) {
            this.software = software;
        }

        public abstract void run();
    }

    abstract class Software {

        public abstract void run();

    }


    class Nokia extends Mobile {

        protected Software software;

        @Override
        public void setSoftware(Software software) {
            this.software = software;
        }

        @Override
        public void run() {
            software.run();
        }
    }

    class Snake extends Software {

        @Override
        public void run() {
            System.out.println("运行贪吃蛇");
        }
    }




}
