package com.sample.keepalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by haoyundong on 2017/3/14.
 */

public class KeepLiveReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        System.out.println(action + ">>>>>>>>>>>>>>>>>>>>>>");
        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            System.out.println("屏幕关闭了...............");
            KeepAliveManager.getInstance().startKeepLiveActivity(context);
        } else if (action.equals(Intent.ACTION_USER_PRESENT)) {
            System.out.println("屏幕打开了...............");
            KeepAliveManager.getInstance().finishKeepLiveActivity();
        }
    }
}
