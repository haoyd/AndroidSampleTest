package com.zhimazg.widgetdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhimazg.widgetdemo.R;

/**
 * Created by haoyundong on 2016/11/24.
 */

public class MyActionBar extends RelativeLayout {
    private TextView left;
    private TextView title;
    private TextView right;

    public MyActionBar(Context context) {
        super(context);
        inflate(context, R.layout.layout_actionbar, this);
        init();
    }


    public MyActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.layout_actionbar, this);
        init();
    }

    public MyActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_actionbar, this);
        init();
    }



    private void init() {

        left = (TextView) findViewById(R.id.tv_bar_left);
        title = (TextView) findViewById(R.id.tv_bar_title);
        right = (TextView) findViewById(R.id.tv_bar_right);

        setHintListener();


    }

    private void setHintListener() {
        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("您点击了后退按钮");
            }
        });

        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("您点击了设置按钮");
            }
        });


    }

    private void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void setLeftListener(OnClickListener onClickListener) {
        left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        right.setOnClickListener(onClickListener);
    }

}
