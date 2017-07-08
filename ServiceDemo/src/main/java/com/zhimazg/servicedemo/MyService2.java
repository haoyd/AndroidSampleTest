package com.zhimazg.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/16.
 */

public class MyService2 extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        for(int i = 0; i < 100; i ++){
            System.out.println("输出:::" + i);
            Log.d("ServiceDemo","输出:::" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
