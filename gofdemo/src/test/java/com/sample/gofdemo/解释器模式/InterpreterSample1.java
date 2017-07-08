package com.sample.gofdemo.解释器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 2016/11/9.
 */

public class InterpreterSample1 {

    public void client() {
        Context context = new Context();

        List<AbstractException> list = new ArrayList<AbstractException>();

        list.add(new TerminalExpression());
        list.add(new NonterminalExpression());
        list.add(new TerminalExpression());

        for (AbstractException ae : list) {
            ae.interpret(context);
        }
    }


    abstract class AbstractException {

        public abstract void interpret(Context context);
    }

    class Context {
        private String input;
        private String output;

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }
    }

    class TerminalExpression extends AbstractException {
        @Override
        public void interpret(Context context) {
            System.out.println("终结解释器");
        }
    }

    class NonterminalExpression extends AbstractException {
        @Override
        public void interpret(Context context) {
            System.out.println("非终结解释器");

        }
    }



}
