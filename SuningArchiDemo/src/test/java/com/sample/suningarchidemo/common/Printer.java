package com.sample.suningarchidemo.common;

public class Printer {

    public static void print(String msg, boolean hasNextStep) {
        System.out.println(msg);

        if (hasNextStep) {
            System.out.println("    |");
            System.out.println("    v");
        }
    }

    public static void print(String msg) {
        if (msg == null) {
            System.out.println("");
            return;
        }
        System.out.println(msg);
    }
}
