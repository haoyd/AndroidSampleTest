package com.sample.keepalive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by haoyundong on 2017/3/14.
 */

public class KeepAliveManager {

    private Activity keepLiveActivity;

    private static KeepAliveManager keepAliveManager = new KeepAliveManager();

    private KeepAliveManager(){}

    public static KeepAliveManager getInstance() {
        return keepAliveManager;
    }

    public void setKeepLiveActivity(KeepAliveActivity activity) {
        keepLiveActivity = activity;
    }

    public void startKeepLiveActivity(Context context) {
        context.startActivity(new Intent(context, KeepAliveActivity.class));
    }

    public void finishKeepLiveActivity() {
        if (keepLiveActivity != null) {
            keepLiveActivity.finish();
        }
    }

    public void startKeepLiveService(Context context) {
        context.startService(new Intent(context, KeepLiveService.class));
    }
}
