package com.sample.dimdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class WindowTopActivity extends AppCompatActivity {

    private TextView textView;

    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_top);
        textView = (TextView) findViewById(R.id.textView2);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

//        StatusBarUtil.setTransparent(WindowTopActivity.this);
        colourMode(null);

    }

    public void screenAllMode(View view) {
//        StatusBarDisplayUtil.getInstance().configAllScreenMode(this);
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
//        layoutParams.setMargins(0, StatusBarDisplayUtil.getInstance().getStatusBarHeight(this), 0, 0);
        StatusBarUtil.setTranslucent(this, 0);
    }

    public void colourMode(View view) {
//        StatusBarDisplayUtil.getInstance().configColourMode(this, getResources().getColor(R.color.green));
//        StatusBarUtil.setTranslucent(this, 55);
//        StatusBarUtil.setTransparent(this);
        StatusBarUtil.setTranslucentForImageView(this, 50, relativeLayout);
    }
}
