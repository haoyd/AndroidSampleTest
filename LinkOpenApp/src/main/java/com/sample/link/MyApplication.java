package com.sample.link;

import android.app.Application;
import android.util.Log;

/**
 * Created by haoyundong on 2016/11/9.
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, ">>>启动了应用");
    }
}
