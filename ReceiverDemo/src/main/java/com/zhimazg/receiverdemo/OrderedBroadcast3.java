package com.zhimazg.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/18.
 */

public class OrderedBroadcast3 extends BroadcastReceiver {
    private static final String TAG = "OrderedBroadcast3";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);
        String string = "";
        string = bundle.getString("a");

        Log.i(TAG, "OrderedBroadcast3收到广播,收到的广播值为:::" + string);
    }
}
