package com.zhimazg.testdemo;

import android.app.Activity;
import android.os.Bundle;


public class TestActivity extends Activity {

    private boolean flag;
    private static final String TAG = "TestActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }


}
