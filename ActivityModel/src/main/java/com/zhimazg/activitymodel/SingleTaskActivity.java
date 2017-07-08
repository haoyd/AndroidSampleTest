package com.zhimazg.activitymodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SingleTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button btnsingletaskself;
    private android.widget.Button btnsingletaskother;
    private android.widget.LinearLayout activitysingletask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        this.activitysingletask = (LinearLayout) findViewById(R.id.activity_single_task);
        this.btnsingletaskother = (Button) findViewById(R.id.btn_single_task_other);
        this.btnsingletaskself = (Button) findViewById(R.id.btn_single_task_self);

        btnsingletaskself.setOnClickListener(this);
        btnsingletaskother.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_single_task_self:
                startActivity(new Intent(SingleTaskActivity.this, SingleTaskActivity.class));
                break;
            case R.id.btn_single_task_other:
                startActivity(new Intent(SingleTaskActivity.this, StandardActivity.class));
                break;
        }
    }
}
