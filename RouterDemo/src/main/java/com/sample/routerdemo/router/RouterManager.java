package com.sample.routerdemo.router;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sample.routerdemo.business.model.Person;

public class RouterManager {

    public static final String PAGE_MAIN = "/Main/MainPage";
    public static final String PAGE_FIRST = "/Main/FirstPage";
    public static final String PAGE_SECOND = "/Main/SecondPage";
    public static final String PAGE_THIRD = "/Main/ThirdPage";

    public static void startFirstPage() {
        ARouter.getInstance().build(PAGE_FIRST).navigation();
    }

    public static void startSecondPage() {
        ARouter.getInstance().build(PAGE_SECOND)
                .withString("msg", "I am from MainPage !")
                .navigation();

    }

    public static void startThirdPage() {
        ARouter.getInstance().build(PAGE_THIRD)
                .withSerializable("person", new Person("小明", "20"))
                .navigation();
    }


}
