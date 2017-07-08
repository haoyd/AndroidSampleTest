package com.sample.recyclerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();
        initListener();
    }

    private void initView(){
        btn1= (Button) findViewById(R.id.btn_index1);
        btn2= (Button) findViewById(R.id.btn_index2);
        btn3= (Button) findViewById(R.id.btn_index3);
        btn4= (Button) findViewById(R.id.btn_index4);
        btn5= (Button) findViewById(R.id.btn_index5);
        btn6= (Button) findViewById(R.id.btn_index6);
    }

    private void initListener(){
        btn1.setOnClickListener(IndexActivity.this);
        btn2.setOnClickListener(IndexActivity.this);
        btn3.setOnClickListener(IndexActivity.this);
        btn4.setOnClickListener(IndexActivity.this);
        btn5.setOnClickListener(IndexActivity.this);
        btn6.setOnClickListener(IndexActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(IndexActivity.this,MainActivity.class);
        switch (v.getId()){
            case R.id.btn_index1:
                intent.putExtra("index",1);
                break;
            case R.id.btn_index2:
                intent.putExtra("index",2);
                break;
            case R.id.btn_index3:
                intent.putExtra("index",3);
                break;
            case R.id.btn_index4:
                intent.putExtra("index",4);
                break;
            case R.id.btn_index5:
                intent.putExtra("index",5);
                break;
            case R.id.btn_index6:
                intent.putExtra("index",6);
                break;
        }
        startActivity(intent);
    }
}
