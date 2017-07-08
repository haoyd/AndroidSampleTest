package com.zhimazg.activitymodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SingleTopActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button btnsingletopself;
    private android.widget.Button btnsingletopother;
    private android.widget.LinearLayout activitysingletop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
        this.activitysingletop = (LinearLayout) findViewById(R.id.activity_single_top);
        this.btnsingletopother = (Button) findViewById(R.id.btn_single_top_other);
        this.btnsingletopself = (Button) findViewById(R.id.btn_single_top_self);

        btnsingletopself.setOnClickListener(this);
        btnsingletopother.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_single_top_self:
                startActivity(new Intent(SingleTopActivity.this, SingleTopActivity.class));
                break;
            case R.id.btn_single_top_other:
                startActivity(new Intent(SingleTopActivity.this, StandardActivity.class));
                break;
        }
    }
}
