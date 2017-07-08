package com.zhimazg.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by haoyundong on 2016/10/16.
 */

public class MyService extends Service {
    private static final String TAG = "MyService";
    private MyBinder myBinder = new MyBinder();



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "MyService-->onStartCommand()");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i ++){
                    Log.i("ServiceDemo","输出:::" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();



        return super.onStartCommand(intent, flags, startId);

    }

    public void executeService(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i ++){
                    Log.i("ServiceDemo","输出:::" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "MyService-->onBind()");
        return myBinder;
    }


    public class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }


    @Override
    public void onCreate() {
        Log.i(TAG, "MyService-->onCreate()");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "MyService-->onStart()");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "MyService-->onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "MyService-->onUnbind()");
        return super.onUnbind(intent);
    }
}
