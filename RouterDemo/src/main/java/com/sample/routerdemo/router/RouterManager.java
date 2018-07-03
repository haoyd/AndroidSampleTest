package com.sample.routerdemo.router;

import android.os.ResultReceiver;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sample.routerdemo.business.model.Person;

public class RouterManager {

    public static final String PAGE_MAIN = "/Main/MainPage";
    public static final String PAGE_FIRST = "/Main/FirstPage";
    public static final String PAGE_SECOND = "/Main/SecondPage";
    public static final String PAGE_THIRD = "/Main/ThirdPage";
    public static final String PAGE_FOURTH = "/Main/FourthPage";
    public static final String PAGE_FIFTH = "/Main/FifthPage";

    public static void startMainPage() {
        ARouter.getInstance()
                .build(PAGE_MAIN)
                .withString("msg", "hello world")
                .navigation();
    }

    public static void startFirstPage() {
        ARouter.getInstance().build(PAGE_FIRST).navigation();
    }

    public static void startSecondPage() {
        ARouter.getInstance().build(PAGE_SECOND)
                .withString("message", "I am from MainPage !")
                .navigation();

    }

    public static void startThirdPage() {
        Person person = new Person("小明", "20");

        ARouter.getInstance().build(PAGE_THIRD)
                .withObject("person", person)
                .navigation();
    }

    public static void startFourthPage() {
        ARouter.getInstance().build(PAGE_FOURTH)
                .withString("jsonData", "I am from MainPage !")
                .navigation();
    }

    public static void startFifthPage(ResultReceiver resultReceiver) {
        ARouter.getInstance().build(PAGE_FIFTH)
                .navigation();
    }

}
