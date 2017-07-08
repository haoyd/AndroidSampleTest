package com.zhimazg.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/18.
 */

public class NormalReceiver extends BroadcastReceiver {
    private static final String TAG = "NormalReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("receiver", "收到了静态广播");
    }
}
