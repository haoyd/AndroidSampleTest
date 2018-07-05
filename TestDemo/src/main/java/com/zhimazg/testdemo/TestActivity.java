package com.zhimazg.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class TestActivity extends Activity {

    private boolean flag;
    private static final String TAG = "TestActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }


    public void showVideo1(View view) {
        Intent intent = new Intent(this, GifActivity.class);
        intent.putExtra("index", 1);
        startActivity(intent);
    }

    public void showVideo2(View view) {
        Intent intent = new Intent(this, GifActivity.class);
        intent.putExtra("index", 2);
        startActivity(intent);
    }

    public void showVideo3(View view) {
        Intent intent = new Intent(this, GifActivity.class);
        intent.putExtra("index", 3);
        startActivity(intent);
    }


}
