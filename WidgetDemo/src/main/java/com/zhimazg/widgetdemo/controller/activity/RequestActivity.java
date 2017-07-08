package com.zhimazg.widgetdemo.controller.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhimazg.widgetdemo.R;
import com.zhimazg.widgetdemo.view.RequestView;

public class RequestActivity extends Activity implements View.OnClickListener {

    private RequestView requestView;

    private Button loading;
    private Button taskEmpty;
    private Button netError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        loadView();
        loadlistener();

    }

    private void loadView() {
        requestView = (RequestView) findViewById(R.id.view_request);
        loading = (Button) findViewById(R.id.btn_start_loading);
        taskEmpty = (Button) findViewById(R.id.btn_task_empty);
        netError = (Button) findViewById(R.id.btn_net_error);
    }

    private void loadlistener() {
        loading.setOnClickListener(this);
        taskEmpty.setOnClickListener(this);
        netError.setOnClickListener(this);

        requestView.setFixActionListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestView.setStateLoading();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_loading:
                requestView.setStateLoading();
                break;
            case R.id.btn_task_empty:
                requestView.setStateNoTask();
                break;
            case R.id.btn_net_error:
                requestView.setStateNetError();
                break;

        }
    }
}
