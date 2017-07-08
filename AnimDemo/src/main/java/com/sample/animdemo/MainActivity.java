package com.sample.animdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadListener();
    }

    private void loadView() {
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
    }

    private void loadListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, PropertyActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, XMLPropertyActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, ViewAnimActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, VectorActivity.class));
                break;
            case R.id.btn6:
                break;
            case R.id.btn7:

                break;
        }
    }





}
