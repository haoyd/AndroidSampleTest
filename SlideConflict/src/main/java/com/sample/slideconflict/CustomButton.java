package com.sample.slideconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by haoyundong on 2017/3/28.
 */

public class CustomButton extends Button {

    private static final String TAG = "CustomButton";

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        log("onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        log("dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}
