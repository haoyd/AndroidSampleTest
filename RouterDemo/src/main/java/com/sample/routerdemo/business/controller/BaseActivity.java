package com.sample.routerdemo.business.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;

public class BaseActivity extends AppCompatActivity {

    @Autowired
    public String jsonData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        Log.d("life", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life", "onDestroy");
    }
}
