package com.sample.routerdemo.business.model;

import android.text.TextUtils;

public class Person {
    String name;
    String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        if (TextUtils.isEmpty(name)) {
            return "";
        } else {
            return "name : " + name + "\n age : " + age;
        }
    }
}
