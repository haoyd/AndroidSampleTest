package com.sample.gofdemo.职责链模式;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class ResponseChainSample1 {

    public void client(int request) {
        Handler leader = new Leader();
        Handler boss = new Boss();
        leader.setSuccessor(boss);

        leader.handleRequest(request);
    }

    abstract class Handler {

        protected Handler handler;

        public void setSuccessor(Handler handler) {
            this.handler = handler;
        }

        public abstract void handleRequest(int request);
    }

    class Leader extends Handler{
        @Override
        public void handleRequest(int request) {
            if (request <= 1000) {
                System.out.println("主管给你加薪" + request);
            } else if (handler != null) {
                handler.handleRequest(request);
            }
        }
    }

    class Boss extends Handler{
        @Override
        public void handleRequest(int request) {
            if (request <= 5000) {
                System.out.println("老大决定给你加薪" + request);
            } else{
                System.out.println("老大拒绝给你加薪");

            }
        }
    }








}
