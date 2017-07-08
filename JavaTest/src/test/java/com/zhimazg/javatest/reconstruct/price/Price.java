package com.zhimazg.javatest.reconstruct.price;

import com.zhimazg.javatest.reconstruct.Movie;

/**
 * Created by haoyundong on 2017/6/22.
 */

public abstract class Price {
    public abstract double getCharge(int daysRented);

    public abstract int getPriceCode();

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
