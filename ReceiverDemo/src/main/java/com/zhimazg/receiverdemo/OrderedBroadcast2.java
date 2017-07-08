package com.zhimazg.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/18.
 */

public class OrderedBroadcast2 extends BroadcastReceiver {
    private static final String TAG = "OrderedBroadcast2";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);
        String string = "";
        string = bundle.getString("a");

        Log.i(TAG, "OrderedBroadcast2收到广播,收到的广播值为:::" + string);

//        Bundle tempBundle = new Bundle();
//        string = "ccc";
//        tempBundle.putString("a", string);
//        setResultExtras(tempBundle);
        //在这儿可以拦截广播,其它优先级没有它高的广播将不可以接收到这个广播
        abortBroadcast();
    }
}
