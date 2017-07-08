package com.zhimazg.javatest.reconstruct;

import com.zhimazg.javatest.reconstruct.price.Price;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class Rental {

    private Movie movie;
    private int daysRented = 5;

    public Rental(String movieName) {
        Price price = MovieLibs.processPriceCode(movieName);
        movie = new Movie(price, movieName);
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int getFrequentRenterPoints() {
        // 如果租借的是新片，而且天气至少为2天
        return movie.getFrequentRenterPoints(daysRented);
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }
}
