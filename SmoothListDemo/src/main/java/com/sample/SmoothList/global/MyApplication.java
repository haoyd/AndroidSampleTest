package com.sample.SmoothList.global;

import android.app.Application;

import com.zhimadj.utils.ImageCache;

/**
 * Created by haoyundong on 16/9/27.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageCache.init(this);
    }
}
