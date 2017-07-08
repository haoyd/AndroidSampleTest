package com.zhimazg.javatest.初始化与清理;

/**
 * Created by haoyundong on 2016/12/9.
 */

public class EnumDemo {





    public void print() {
        useMethod1();
        useMethod2();
        useMethod3();


    }

    private void useMethod1() {
        Color yello = Color.YELLOW;
        System.out.println(yello);
        System.out.println();
    }

    private void useMethod2() {
        for (Color color : Color.values()) {
            System.out.println(color + " : " + color.ordinal());
        }
        System.out.println();
    }

    private void useMethod3() {
        for (Color color : Color.values()) {

            System.out.print(color);
            switch (color) {
                case RED:
                    System.out.println("这是红色");
                    break;
                case GREEN:
                    System.out.println("这是绿色");

                    break;
                case BLANK:
                    System.out.println("这是黑色");

                    break;
                case YELLOW:
                    System.out.println("这是黄色");

                    break;

            }
        }
    }


    public enum Color {
        RED, GREEN, BLANK, YELLOW
    }

    public enum Num {

    }


}
