package com.sample.gofdemo;

import com.sample.gofdemo.中介者模式.MediatorClient;
import com.sample.gofdemo.享元模式.FlyweightSample1;
import com.sample.gofdemo.代理模式.GiftGive;
import com.sample.gofdemo.代理模式.XiaoHan;
import com.sample.gofdemo.单例模式.SingleInstance;
import com.sample.gofdemo.原型模式.ResumeA;
import com.sample.gofdemo.命令模式.CommandSample1;
import com.sample.gofdemo.备忘录模式.MementoSample1;
import com.sample.gofdemo.外观模式.XinHua;
import com.sample.gofdemo.工厂方法模式.Colleague;
import com.sample.gofdemo.工厂方法模式.ColleagueFactory;
import com.sample.gofdemo.工厂方法模式.FeiYuFactory;
import com.sample.gofdemo.工厂方法模式.XinHuaFactory;
import com.sample.gofdemo.建造者模式.Builder;
import com.sample.gofdemo.建造者模式.Builder1;
import com.sample.gofdemo.建造者模式.Builder2;
import com.sample.gofdemo.建造者模式.Director;
import com.sample.gofdemo.建造者模式.Product;
import com.sample.gofdemo.抽象工厂模式.AbstractFacSample1;
import com.sample.gofdemo.桥接模式.BridgeSample1;
import com.sample.gofdemo.模板方法模式.TestPaper;
import com.sample.gofdemo.模板方法模式.TestPaperA;
import com.sample.gofdemo.模板方法模式.TestPaperB;
import com.sample.gofdemo.状态模式.StateSample1;
import com.sample.gofdemo.策略模式.Context;
import com.sample.gofdemo.策略模式.Strategy1;
import com.sample.gofdemo.策略模式.Strategy2;
import com.sample.gofdemo.简单工场模式.Operation;
import com.sample.gofdemo.简单工场模式.OperationFactory;
import com.sample.gofdemo.组合模式.CompositeClient;
import com.sample.gofdemo.职责链模式.ResponseChainSample1;
import com.sample.gofdemo.装饰模式.ConcreteComponent;
import com.sample.gofdemo.装饰模式.ConcreteDecorator1;
import com.sample.gofdemo.装饰模式.ConcreteDecorator2;
import com.sample.gofdemo.观察者模式.ObserverSample1;
import com.sample.gofdemo.解释器模式.InterpreterSample1;
import com.sample.gofdemo.访问者模式.VisitorSample1;
import com.sample.gofdemo.迭代器模式.IteratorSample1;
import com.sample.gofdemo.适配器模式.AdapterSample1;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void client() throws Exception {
        //单例模式
//        singleClient();

        //建造者模式
//        builderClient();

        //策略模式
//        strategyClient();

        //简单工厂模式
//        sampleFactoryClient();

        //装饰模式
//        decoration();

        //代理模式
//        proxyClient();

        //工厂方法模式
//        factoryMethodClient();

        //原型模式
//        protoTypeClient();

        //模板方法模式
//        templateMethodClient();

        //外观模式
//        facade();

        //观察者模式
//        observer();

        //抽象工厂模式
//        abstractFactory();

        //状态模式
//        state();

        //适配器模式
//        adapterClient();

        //备忘录模式
//        mementoClient();

        //组合模式
//        compositeClient();

        //迭代器模式
//        iteratorClient();

        //桥接模式
//        bridgeClient();

        //命令模式
//        CommandClient();

        //职责链模式
//        ResponseChainClient();

        //中介者模式
//        mediatorClient();

        //享元模式
//        flyweightClient();

        //解释器模式
//        interpreterClient();

        //访问者模式
//        visitorClient();
//        BaseAdapter

    }



    /**
     * 单例设计模式
     */
    private void singleClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingleInstance singleInstance = SingleInstance.getInstance();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingleInstance singleInstance1 = SingleInstance.getInstance();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingleInstance singleInstance2 = SingleInstance.getInstance();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SingleInstance singleInstance3 = SingleInstance.getInstance();
            }
        }).start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        singleInstance.show();
    }

    /**
     * 建造者模式
     */
    private void builderClient() {
        //请2个建造者，每个建造者都有2项技能
        Builder builder1 = new Builder1();
        Builder builder2 = new Builder2();

        //指挥官安排一下他俩的工作
        Director director;
        director = new Director(builder1);
        director = new Director(builder2);

        //把你俩造的产品拿出来
        Product product1 = builder1.getResult();
        Product product2 = builder2.getResult();

        //我看看
        product1.show();
        product2.show();
    }

    /**
     * 策略模式
     */
    private void strategyClient() {
        Context context;

        context = new Context(new Strategy1());
        context.contextInterface();

        context = new Context(new Strategy2());
        context.contextInterface();

    }

    /**
     * 简单工厂模式
     */
    private void sampleFactoryClient() {
        Operation operation = OperationFactory.createOperation("*");
        System.out.println(operation.getResult(5,5));
    }

    /**
     * 单一职责原则
     */
    private void singleResponse() {
        /**
         * 对类和方法尽量做到功能单一，修改某一块功能的时候尽量只动这块功能的代码，而不需要动其它的地方，降低偶合。
         */
    }

    /**
     * 开放封装原则
     */
    private void open_close() {
        /**
         * 对更改封闭，对扩展开放。在有修改的时候尽量不要动现有的代码，对它的扩展进行修改。
         */
    }

    /**
     * 依赖倒转原则
     */
    private void depend_reverse() {
        /**
         * 尽量面向接口编程
         * 父类出现的地方一定可以出现子类
         * 在软件里面，把父类替换成子类后，程序行为没有变化；简单说：子类必须可以替换它的父类型。
         */
    }

    /**
     * 装饰模式
     */
    private void decoration() {
        ConcreteComponent cc = new ConcreteComponent();
        ConcreteDecorator1 cd1 = new ConcreteDecorator1();
        ConcreteDecorator2 cd2 = new ConcreteDecorator2();

        cd1.setComponent(cc);
        cd2.setComponent(cd1);
        cd2.operation();


        /**
         * 这块可以写一个穿衣服的例子
         */

//        new DecorateExample().client();
    }

    /**
     * 代理模式
     */
    private void proxyClient() {
        GiftGive xiaoHan = new XiaoHan("李京");
        xiaoHan.giveDoll();
        xiaoHan.giveFood();
    }

    /**
     * 工厂方法模式
     */
    private void factoryMethodClient() {
        ColleagueFactory cf1 = new XinHuaFactory();
        ColleagueFactory cf2 = new FeiYuFactory();

        Colleague xinhua = cf1.createColleague();
        Colleague feiyu = cf2.createColleague();

        xinhua.joke();
        feiyu.joke();
    }

    /**
     * 原型模式
     */
    private void protoTypeClient() {
        ResumeA resume1 = new ResumeA("孟晨", 25);
        resume1.display();

        ResumeA resume2 = (ResumeA) resume1.clone();
        resume2.setAge(28);
        resume2.display();

    }

    /**
     * 模板方法模式
     */
    private void templateMethodClient() {
        TestPaper mengchen = new TestPaperA("孟晨");
        mengchen.answer1();
        mengchen.answer2();

        TestPaper feiyu = new TestPaperB("飞宇");
        feiyu.answer1();
        feiyu.answer2();
    }

    /**
     * 迪米特法则
     */
    private void dimilt() {
        /**
         * 两个类尽量避免直接接触，而是引入一个第三者来转发调用
         */
    }

    /**
     * 外观模式
     */
    private void facade() {
        //老大打电话说：新华，你来一下邯郸，咱们商量点事
        XinHua xinHua = new XinHua();
        //老大跟新华说：咱们要做一个网站，让想了解咱们公司的人看到咱们公司的介绍
        xinHua.methodA();
        //老大跟新华说：咱们要做一个网站，不仅要能看到咱们公司的简介，还要让用户能够留言
        xinHua.methodB();
    }

    /**
     * 观察者模式
     */
    private void observer() {
        new ObserverSample1().client();
    }

    /**
     * 抽象工厂模式
     */
    private void abstractFactory() {
        new AbstractFacSample1().client();
    }

    /**
     * 状态模式
     */
    private void state() {
//        com.sample.gofdemo.状态模式.Context context = new com.sample.gofdemo.状态模式.Context(new State1());
//        context.request();
//        context.request();
//        context.request();
//        context.request();
//        context.request();

        new StateSample1().client();
    }

    /**
     * 适配器模式
     */
    private void adapterClient() {
        new AdapterSample1().client();
    }

    /**
     * 备忘录模式
     */
    private void mementoClient() {
        new MementoSample1().client();
    }

    /**
     * 组合模式
     */
    private void compositeClient() {
        new CompositeClient().client();
    }

    /**
     * 迭代器模式
     */
    private void iteratorClient() {
        new IteratorSample1().client();
    }

    /**
     * 桥接模式
     */
    private void bridgeClient() {
       new BridgeSample1().client();
    }

    /**
     * 命令模式
     */
    private void CommandClient() {
        new CommandSample1().client();
    }

    /**
     * 职责链模式
     */
    private void ResponseChainClient() {
        new ResponseChainSample1().client(6000);
    }

    /**
     * 中介者模式
     */
    private void mediatorClient() {
        new MediatorClient().client();
    }

    /**
     * 享元模式
     */
    private void flyweightClient() {
        new FlyweightSample1().client();
    }

    /**
     * 解释器模式
     */
    private void interpreterClient() {
        new InterpreterSample1().client();
    }

    /**
     * 访问者模式
     */
    private void visitorClient() {
        new VisitorSample1().client();
    }

}

















