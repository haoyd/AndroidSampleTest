package com.zhimazg.activitymodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class StandardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnstandard1;
    private Button btnstandard2;
    private Button btnstandard3;
    private Button btnstandard4;
    private android.widget.LinearLayout activitystandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        this.activitystandard = (LinearLayout) findViewById(R.id.activity_standard);
        this.btnstandard4 = (Button) findViewById(R.id.btn_standard4);
        this.btnstandard3 = (Button) findViewById(R.id.btn_standard3);
        this.btnstandard2 = (Button) findViewById(R.id.btn_standard2);
        this.btnstandard1 = (Button) findViewById(R.id.btn_standard1);

        btnstandard1.setOnClickListener(this);
        btnstandard2.setOnClickListener(this);
        btnstandard3.setOnClickListener(this);
        btnstandard4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_standard1:
                startActivity(new Intent(StandardActivity.this, StandardActivity.class));
                break;
            case R.id.btn_standard2:
                startActivity(new Intent(StandardActivity.this, SingleTopActivity.class));
                break;
            case R.id.btn_standard3:
                startActivity(new Intent(StandardActivity.this, SingleTaskActivity.class));
                break;
            case R.id.btn_standard4:
                startActivity(new Intent(StandardActivity.this, SingleInstanceActivity.class));
                break;

        }
    }
}
