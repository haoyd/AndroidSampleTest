package com.sample.slideconflict;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        log("dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        log("onTouchEvent");
        return super.onTouchEvent(event);
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }


}
