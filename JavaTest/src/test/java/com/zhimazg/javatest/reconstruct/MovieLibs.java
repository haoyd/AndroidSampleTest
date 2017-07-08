package com.zhimazg.javatest.reconstruct;

import com.zhimazg.javatest.reconstruct.price.ChildrenPrice;
import com.zhimazg.javatest.reconstruct.price.NewReleasePrice;
import com.zhimazg.javatest.reconstruct.price.Price;
import com.zhimazg.javatest.reconstruct.price.RegularPrice;

/**
 * Created by haoyundong on 2017/6/22.
 */

public class MovieLibs {

    public static Price processPriceCode(String name) {
        if (name.equals("僵尸先生")) {
            return new RegularPrice();
        } else if (name.equals("摔跤吧，爸爸")) {
            return new NewReleasePrice();
        } else if (name.equals("铁臂阿童目")) {
            return new ChildrenPrice();
        } else {
            return null;
        }
    }
}
