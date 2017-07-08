package com.sample.gofdemo.命令模式;

/**
 * Created by haoyundong on 2017/1/1.
 */

public class CommandExam {

    public void client() {
        Receiver receiver = new Receiver();

        Command command = new OrderMenu(receiver);

        Waiter waiter = new Waiter();
        waiter.setOrder(command);
        waiter.toNotify();


    }

    abstract class Command{
        Receiver receiver;

        public Command(Receiver receiver) {
            this.receiver = receiver;
        }

        abstract void exec();
    }


    class OrderMenu extends Command {
        public OrderMenu(Receiver receiver) {
            super(receiver);
        }

        @Override
        void exec() {
            System.out.println("点凉菜");
            receiver.action();
        }
    }

    class OrderMeet extends Command {
        public OrderMeet(Receiver receiver) {
            super(receiver);
        }

        @Override
        void exec() {
            System.out.println("点肉");
            receiver.action();
        }
    }




    class Receiver{
        public void action() {

        }
    }

    class Waiter{
        Command command;

        public void setOrder(Command command) {
            this.command = command;
        }

        public void toNotify() {
            command.exec();
        }
    }

}
