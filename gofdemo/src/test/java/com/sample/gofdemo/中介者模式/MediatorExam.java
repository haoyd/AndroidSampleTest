package com.sample.gofdemo.中介者模式;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haoyundong on 2017/1/1.
 */

public class MediatorExam {

    public void client() {
        MediatorInterface mediator = new MediatorImpl();

        ColleagueInterface colleague1 = new ColleagueImpl1();
        ColleagueInterface colleague2 = new ColleagueImpl2();

        mediator.addColleague("colleague1", colleague1);
        mediator.addColleague("colleague2", colleague2);

        mediator.send("hello, I am one", colleague2);
        mediator.send("hello, I am two", colleague1);
    }

    interface ColleagueInterface {

        void getMsg(String msg);
    }

    abstract class MediatorInterface {
        private Map<String, ColleagueInterface> colleagues = new HashMap<String, ColleagueInterface>();

        public void addColleague(String colleagueName, ColleagueInterface c){
            colleagues.put(colleagueName, c);
        }
        public void removeColleague(String colleagueName, ColleagueInterface c){
            if (colleagues.containsKey(colleagueName)) {
                colleagues.remove(colleagueName);
            }
        }

        public boolean isContains(ColleagueInterface colleague) {
            return colleagues.containsValue(colleague);
        }

        public abstract void send(String msg, ColleagueInterface colleague);
    }

    class ColleagueImpl1 implements ColleagueInterface {
        @Override
        public void getMsg(String msg) {
            System.out.println("ColleagueImpl1收到消息" + msg);
        }
    }

    class ColleagueImpl2 implements ColleagueInterface {
        @Override
        public void getMsg(String msg) {
            System.out.println("ColleagueImpl2收到消息" + msg);

        }
    }

    class MediatorImpl extends MediatorInterface{

        @Override
        public void send(String msg, ColleagueInterface colleague) {
            if (isContains(colleague)) {
                colleague.getMsg(msg);
            }
        }
    }



}
