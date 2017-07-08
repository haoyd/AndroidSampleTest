package com.zhimazg.javatest.reconstruct.price;

import static com.zhimazg.javatest.reconstruct.Movie.NEW_RELEASE;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class NewReleasePrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getPriceCode() {
        return NEW_RELEASE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
