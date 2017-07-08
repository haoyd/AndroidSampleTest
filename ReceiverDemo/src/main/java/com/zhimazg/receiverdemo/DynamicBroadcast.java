package com.zhimazg.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/18.
 */

public class DynamicBroadcast extends BroadcastReceiver {

    private Context mContext = null;
    private DynamicBroadcast dynamicBroadcast = null;

    public DynamicBroadcast(Context context) {
        mContext = context;
        dynamicBroadcast = this;
    }

    public void registAction(String action) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        mContext.registerReceiver(dynamicBroadcast, intentFilter);

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("receiver", "收到了动态广播");

    }
}
