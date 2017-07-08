package com.sample.gofdemo.适配器模式;

/**
 * Created by haoyundong on 16/9/24.
 */

public class Adapter {

    /**
     * 客户端所期待的接口
     */
    abstract class Target{
        public abstract void request();
    }

    /**
     * 需要适配的类
     */
    class Adapee{
        public void specialRequest(){
            System.out.print("特殊请求");
        }
    }

    class MyAdapter extends Target{
        private Adapee adapee = new Adapee();


        @Override
        public void request() {
            adapee.specialRequest();
        }
    }

    class Client{
        void main(){
            Target target = new MyAdapter();
            target.request();
        }
    }


}
