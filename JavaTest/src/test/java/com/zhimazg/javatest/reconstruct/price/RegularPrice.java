package com.zhimazg.javatest.reconstruct.price;

import static com.zhimazg.javatest.reconstruct.Movie.REGULAR;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class RegularPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }

    @Override
    public int getPriceCode() {
        return REGULAR;
    }
}
