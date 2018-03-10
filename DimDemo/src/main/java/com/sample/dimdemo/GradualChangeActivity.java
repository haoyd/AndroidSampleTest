package com.sample.dimdemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GradualChangeActivity extends AppCompatActivity {

    private CustomScrollView scrollView;
    private View titleBackground;

    public static final float CHANGE_NUMBER = 130f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradual_change);

        bindView();
        bindListener();

    }

    private void bindView() {
        scrollView = (CustomScrollView) findViewById(R.id.scroll_gradual_change);
        titleBackground = findViewById(R.id.title_bg);

        setModeTranscluent(null);
//        MIUISetStatusBarLightMode(getWindow(), true);

    }

    private void bindListener() {
        scrollView.setScrollViewListener(new CustomScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                if (y == 0) {
                    titleBackground.setAlpha(0);
                    StatusBarUtil.setTranslucent(GradualChangeActivity.this, Color.parseColor("#ffffff"), 0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_VISIBLE);
                    }
                }else if (y < CHANGE_NUMBER) {
                    float alphaNum = 1 / CHANGE_NUMBER * y;
                    Log.d("aa", ">>>>>>>   y值为：" + y + "   alpha值为：" + alphaNum);
                    titleBackground.setAlpha(alphaNum);
                    StatusBarUtil.setTranslucent(GradualChangeActivity.this, Color.parseColor("#ffffff"), alphaNum);
                } else {
                    titleBackground.setAlpha(1);
                    StatusBarUtil.setTranslucent(GradualChangeActivity.this, Color.parseColor("#ffffff"), 1);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                }
            }
        });

    }

    public void setModeTranscluent(View view) {
        StatusBarUtil.setTransparent(this);
    }

    public void setModeColourBar(View view) {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.yellow));
    }


    public boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if(dark){
                    extraFlagField.invoke(window,darkModeFlag,darkModeFlag);//状态栏透明且黑色字体
                }else{
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result=true;
            }catch (Exception e){

            }
        }
        return result;
    }


}
