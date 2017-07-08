package com.zhimazg.javatest.reconstruct.price;

import static com.zhimazg.javatest.reconstruct.Movie.CHILDRENS;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class ChildrenPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

    @Override
    public int getPriceCode() {
        return CHILDRENS;
    }
}
