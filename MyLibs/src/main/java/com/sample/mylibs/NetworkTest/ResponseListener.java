package com.sample.mylibs.NetworkTest;

/**
 * Created by haoyundong on 2018/5/14.
 */

public abstract class ResponseListener {

    abstract void onResponse(String data);

    abstract void onError(ErrorClass error);
}
