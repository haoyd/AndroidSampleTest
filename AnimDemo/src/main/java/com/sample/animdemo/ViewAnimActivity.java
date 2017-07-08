package com.sample.animdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class ViewAnimActivity extends Activity {

    private Button button;

    private float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);

        loadView();
        loadListener();
    }



    private void loadView() {
        button = (Button) findViewById(R.id.btn_anim_view);

        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;
    }

    private void loadListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate()
                        .y(mScreenHeight/2)
                        .setDuration(3000)
                        .withStartAction(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        button.setText("start...");
                                    }
                                });
                            }
                        })
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        button.setText("end...");
                                    }
                                });
                            }
                        })
                        .start();
            }
        });
    }
}
