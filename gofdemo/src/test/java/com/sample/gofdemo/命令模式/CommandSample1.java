package com.sample.gofdemo.命令模式;

/**
 * Created by haoyundong on 2016/11/8.
 */

public class CommandSample1 {


    public void client() {
        Receiver receiver = new Receiver();
        Command orderMenu = new OrderMenu(receiver);

        Waiter girl = new Waiter();
        girl.setOrder(orderMenu);
        girl.toNotify();

    }


    abstract class Command {
        protected Receiver receiver;

        public Command(Receiver receiver) {
            this.receiver = receiver;
        }

        public abstract void execute();
    }

    class OrderMenu extends Command{

        public OrderMenu(Receiver receiver) {
            super(receiver);
        }

        @Override
        public void execute() {
            System.out.println("点一个凉菜");
            receiver.action();
        }
    }

    class ConcreteCommand extends Command {

        private Receiver receiver;

        public ConcreteCommand(Receiver receiver) {
            super(receiver);
            this.receiver = receiver;
        }

        @Override
        public void execute() {

        }
    }

    class Receiver {

        public void action() {
            System.out.println("接收者收到请求");
        }
    }


    class Waiter {
        private Command command;

        public void setOrder(Command command) {
            this.command = command;
        }

        public void toNotify() {
            System.out.println("服务员去通知一下");
            command.execute();
        }
    }







}
