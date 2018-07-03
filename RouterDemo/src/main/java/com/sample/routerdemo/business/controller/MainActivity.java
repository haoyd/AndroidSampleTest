package com.sample.routerdemo.business.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sample.routerdemo.R;
import com.sample.routerdemo.router.RouterManager;

@Route(path = RouterManager.PAGE_MAIN)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void FirstActivity(View view) {
        RouterManager.startFirstPage();
    }

    public void SecondActivity(View view) {
        RouterManager.startSecondPage();
    }

    public void ThirdActivity(View view) {
        RouterManager.startThirdPage();
    }

    public void fourthActivity(View view) {
        RouterManager.startFourthPage();
    }
}
