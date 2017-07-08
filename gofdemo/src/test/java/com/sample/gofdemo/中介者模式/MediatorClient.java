package com.sample.gofdemo.中介者模式;

/**
 * Created by haoyundong on 2016/11/9.
 */

public class MediatorClient {

    public void client() {
        UN un = new UN();

        China china = new China(un);
        USA usa = new USA(un);

        un.setChina(china);
        un.setUsa(usa);

        un.send("我是美国,我想跟你交个朋友", usa);
        un.send("算了吧，看不上你", china);


    }

    /**
     * 抽象中介者
     */
    abstract class Mediator {
        public abstract void send(String msg, Colleague colleague);
    }


    /**
     * 抽象同事类
     */
    abstract class Colleague {
        protected  Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }
    }

    class UN extends Mediator{
        private China china;
        private USA usa;

        public void setChina(China china) {
            this.china = china;
        }

        public void setUsa(USA usa) {
            this.usa = usa;
        }

        @Override
        public void send(String msg, Colleague colleague) {
            if (colleague == china) {
                usa.toNotify(msg);
            } else if (colleague == usa) {
                china.toNotify(msg);
            }
        }
    }

    class China extends Colleague {

        public China(Mediator mediator) {
            super(mediator);
        }

        public void toNotify(String msg) {
            System.out.println("中国收到消息：" + msg);
        }
    }

    class USA extends Colleague {

        public USA(Mediator mediator) {
            super(mediator);
        }

        public void toNotify(String msg) {
            System.out.println("美国收到消息：" + msg);
        }
    }




}
