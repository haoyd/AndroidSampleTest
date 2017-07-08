package com.sample.gofdemo.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体产品
 * Created by haoyundong on 2016/11/3.
 */

public class Product {
    List<String> parts = new ArrayList<String>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        for(String s : parts){
            System.out.println(s);
        }
    }
}
