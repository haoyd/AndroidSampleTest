package com.zhimazg.javatest.reconstruct;

import android.text.TextUtils;

import com.zhimazg.javatest.reconstruct.price.Price;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class Movie {
    public static final int REGULAR = 1; // 普通片
    public static final int NEW_RELEASE = 2; // 新片
    public static final int CHILDRENS = 3; // 儿童片

    private Price mPrice;
    private String movieName = "";

    public Movie(Price price, String name) {
        this.mPrice = price;
        this.movieName = name;
    }

    public int getPriceCode() {
        return mPrice.getPriceCode();
    }

    public String getTitle() {
        return movieName;
    }

    public int getFrequentRenterPoints(int daysRented) {
        // 如果租借的是新片，而且天气至少为2天
        return mPrice.getFrequentRenterPoints(daysRented);
    }


    public double getCharge(int daysRented) {

        return mPrice.getCharge(daysRented);
    }
}
