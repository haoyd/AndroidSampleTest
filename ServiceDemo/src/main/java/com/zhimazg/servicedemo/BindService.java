package com.zhimazg.servicedemo;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindService extends Service {

    private static final String TAG = "BindService";
    private MyBinder myBinder = new MyBinder();

    public void MyMethod() {
        Log.i(TAG, "BindService-->MyMethod()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "BindService-->onBind()");
        return myBinder;
    }

    public class MyBinder extends Binder {

        public BindService getService1() {
            return BindService.this;
        }
    }


    @Override
    public void onCreate() {
        Log.i(TAG, "BindService-->onCreate()");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "BindService-->onStart()");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "BindService-->onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "BindService-->onUnbind()");
        return super.onUnbind(intent);
    }

}
