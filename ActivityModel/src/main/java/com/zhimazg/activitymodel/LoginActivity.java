package com.zhimazg.activitymodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(LoginActivity.this, StandardActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(LoginActivity.this, SingleTopActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(LoginActivity.this, SingleTaskActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(LoginActivity.this, SingleInstanceActivity.class));
                break;

        }
    }
}

