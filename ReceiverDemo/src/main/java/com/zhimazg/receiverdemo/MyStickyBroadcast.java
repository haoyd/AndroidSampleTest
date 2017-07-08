package com.zhimazg.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/18.
 */

public class MyStickyBroadcast extends BroadcastReceiver {

    private static final String TAG = "MyStickyBroadcast";
    public static final String ACTION = "m.n.o.p";

    @Override
    public void onReceive(Context context, Intent intent) {

        String str = "";
        str = intent.getStringExtra("aa");
        Log.i(TAG, "MyStickyBroadcast接收到了广播,广播内容为:" + str);
    }
}
