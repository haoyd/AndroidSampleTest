package com.sample.routerdemo.business.model;

import android.text.TextUtils;

import java.io.Serializable;


public class Person implements Serializable{
    private String name;
    private String age;

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
