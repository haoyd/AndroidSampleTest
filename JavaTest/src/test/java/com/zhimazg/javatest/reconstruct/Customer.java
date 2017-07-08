package com.zhimazg.javatest.reconstruct;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class Customer {

    private List<Rental> rentals;

    public void client() {
        rentals = new ArrayList<>();
        rentals.add(new Rental("僵尸先生"));
        rentals.add(new Rental("摔跤吧，爸爸"));
        rentals.add(new Rental("铁臂阿童目"));

        rentals = Arrays.asList(new Rental("僵尸先生"), new Rental("摔跤吧，爸爸"), new Rental("铁臂阿童目"));

        System.out.println(statement());
    }

    public String statement() {
        String result = "租给：飞宇" + "\n";

        for (Rental rental : rentals) {
            //显示此笔租借记录
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";

        }
        //结尾打印
        result += "总租金为： " + String.valueOf(getTotalCharge()) + "\n";
        result += "你赚到 " + String.valueOf(getTotalFrequentRenterPointers()) + " 个常客积点";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private double getTotalFrequentRenterPointers() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }


}
