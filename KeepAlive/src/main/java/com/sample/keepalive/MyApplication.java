package com.sample.keepalive;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

/**
 * Created by haoyundong on 2017/3/14.
 */

public class MyApplication extends Application {

    public Activity mLiveActivity;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public void startKeepLiveActivity() {
        startActivity(new Intent(this, KeepAliveActivity.class));
    }

    public void finishKeepLiveActivity() {
        if (mLiveActivity != null) {
            mLiveActivity.finish();
        }
    }


}
