package com.sample.keepalive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by haoyundong on 2017/3/14.
 */

public class KeepAliveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1,1);
        textView.setLayoutParams(layoutParams);
        setContentView(textView);

        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = 0;
        lp.height = 1;
        lp.width = 1;
        window.setAttributes(lp);

        KeepAliveManager.getInstance().setKeepLiveActivity(this);
    }
}
