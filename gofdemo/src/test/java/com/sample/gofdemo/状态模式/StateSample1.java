package com.sample.gofdemo.状态模式;

/**
 * Created by haoyundong on 2016/11/7.
 */

public class StateSample1 {
    
    public void client() {
        Test test = new Test(new You());
        test.setNum(60);
        test.request();
    }

    public class Test {
        private Percent percent;
        public int num;

        public void setNum(int num) {
            this.num = num;
        }

        public Test(Percent percent) {
            this.percent = percent;
        }

        public Percent getPercent() {
            return percent;
        }

        public void setPercent(Percent percent) {
            this.percent = percent;
        }

        public void request() {
            percent.handle(this);
        }
    }
    
    
    abstract class Percent{
        abstract void handle(Test test);
    }

    class You extends Percent {
        @Override
        void handle(Test test) {
            if (test.num > 90) {
                System.out.println("优");
            } else {
                test.setPercent(new Liang());
                test.request();
            }
        }
    }
    
    class Liang extends Percent {
        @Override
        void handle(Test test) {
            if (test.num > 80) {
                System.out.println("良");
            } else {
                test.setPercent(new Zhong());
                test.request();
            }
        }
    }
    
    class Zhong extends Percent {
        @Override
        void handle(Test test) {
            if (test.num > 70) {
                System.out.println("中");
            } else {
                test.setPercent(new Cha());
                test.request();
            }
        }
    }
    
    class Cha extends Percent {
        @Override
        void handle(Test test) {
            if (test.num >= 60) {
                System.out.println("差");
            } else {
                System.out.println("不及格");
            }
        }
    }
    
    
    
    
    
}
