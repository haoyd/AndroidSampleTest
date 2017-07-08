package com.zhimazg.widgetdemo.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhimazg.widgetdemo.R;
import com.zhimazg.widgetdemo.view.HomeDialog;

public class MainActivity extends AppCompatActivity {

    private Button toRequest;
    private Button toTitleTip;
    private Button openDialog;
    private Button openSpinner;
    private Button openSpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadListener();

    }



    private void loadView() {
        toRequest = (Button) findViewById(R.id.btn_main_jump_request);
        toTitleTip = (Button) findViewById(R.id.btn_main_title_tip);
        openDialog = (Button) findViewById(R.id.btn_main_dialog);
        openSpinner = (Button) findViewById(R.id.btn_main_spinner);
        openSpinner2 = (Button) findViewById(R.id.btn_main_spinner2);
    }

    private void loadListener() {
        toRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RequestActivity.class));
            }
        });

        toTitleTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TitleTipActivity.class));
            }
        });

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HomeDialog.Builder(MainActivity.this).show();
//                new HomeDialog(MainActivity.this).show();
            }
        });

        openSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
            }
        });

        openSpinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SpinnerActivity2.class));

            }
        });

    }
}
