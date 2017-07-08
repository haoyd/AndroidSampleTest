package com.zhimazg.activitymodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SingleInstanceActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button btnsingleinstanceself;
    private android.widget.Button btnsingleinstanceother;
    private android.widget.LinearLayout activitysingleinstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        this.activitysingleinstance = (LinearLayout) findViewById(R.id.activity_single_instance);
        this.btnsingleinstanceother = (Button) findViewById(R.id.btn_single_instance_other);
        this.btnsingleinstanceself = (Button) findViewById(R.id.btn_single_instance_self);

        btnsingleinstanceself.setOnClickListener(this);
        btnsingleinstanceother.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_single_instance_self:
                startActivity(new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class));
                break;
            case R.id.btn_single_instance_other:
                startActivity(new Intent(SingleInstanceActivity.this, StandardActivity.class));
                break;
        }
    }
}
