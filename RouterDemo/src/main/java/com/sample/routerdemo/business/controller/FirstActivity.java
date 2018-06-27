package com.sample.routerdemo.business.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sample.routerdemo.R;
import com.sample.routerdemo.router.RouterManager;

@Route(path = RouterManager.PAGE_FIRST)
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
}
