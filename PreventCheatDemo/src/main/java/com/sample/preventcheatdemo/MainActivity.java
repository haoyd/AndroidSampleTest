package com.sample.preventcheatdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView msgView;

    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgView = findViewById(R.id.tv_main);

        initData();

        msgView.setText(sb.toString());
    }

    private void initData() {
        sb.append("package ：" + getPackageName() + "\n");
        sb.append("FileDir ：" + getFilesDir().getAbsolutePath() + "\n");
    }
}
