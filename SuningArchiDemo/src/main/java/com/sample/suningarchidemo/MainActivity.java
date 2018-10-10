package com.sample.suningarchidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhimazg.testdemo.GifActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoPlugin(View view) {
        Intent intent = new Intent(this, GifActivity.class);
        intent.putExtra("index", 1);
        startActivity(intent);
    }
}
