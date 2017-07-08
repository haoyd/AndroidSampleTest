package com.zhimazg.widgetdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhimazg.widgetdemo.R;

/**
 * Created by haoyundong on 2016/12/14.
 */

public class RequestView extends RelativeLayout {

    private LinearLayout noTaskLayout;
    private LinearLayout netFailLayout;
    private RelativeLayout loadingLayout;

    private TextView btnError;


    public RequestView(Context context) {
        this(context, null);
//        inflate(context R.layout.layout_request, this);
//        init();
    }

    public RequestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//        inflate(context, R.layout.layout_request, this);
//        init();
    }

    public RequestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_request, this);
        init();

    }

    private void init() {
        noTaskLayout = (LinearLayout) findViewById(R.id.ll_request_no_task);
        netFailLayout = (LinearLayout) findViewById(R.id.ll_request_net_fail);
        loadingLayout = (RelativeLayout) findViewById(R.id.rl_request_loading);

        btnError = (TextView) findViewById(R.id.error_btn);

        noTaskLayout.setVisibility(GONE);
        netFailLayout.setVisibility(GONE);
        loadingLayout.setVisibility(GONE);

    }



    public void setRequestSuccess() {
        this.setVisibility(GONE);
    }

    public void setStateLoading() {
        noTaskLayout.setVisibility(GONE);
        netFailLayout.setVisibility(GONE);
        loadingLayout.setVisibility(VISIBLE);
    }

    public void setStateNoTask() {
        noTaskLayout.setVisibility(VISIBLE);
        netFailLayout.setVisibility(GONE);
        loadingLayout.setVisibility(GONE);
    }

    public void setStateNetError() {
        noTaskLayout.setVisibility(GONE);
        netFailLayout.setVisibility(VISIBLE);
        loadingLayout.setVisibility(GONE);
    }

    public void showLoading() {
        loadingLayout.setVisibility(VISIBLE);
    }

    public void hideLoading() {
        loadingLayout.setVisibility(GONE);
    }

    public void showTaskNull() {
        noTaskLayout.setVisibility(VISIBLE);
    }

    public void hideTaskNull() {
        noTaskLayout.setVisibility(GONE);
    }

    public void showNetFaild() {
        netFailLayout.setVisibility(VISIBLE);
    }

    public void hideNetFaild() {
        netFailLayout.setVisibility(GONE);
    }

    public void setFixActionListener(OnClickListener listener) {
        btnError.setOnClickListener(listener);
    }


}
