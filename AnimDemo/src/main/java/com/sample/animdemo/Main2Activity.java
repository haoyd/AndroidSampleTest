package com.sample.animdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class Main2Activity extends Activity implements View.OnClickListener{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loadView();
        loadListener();
    }

    private void loadView() {
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
    }

    private void loadListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                alphaTest(view);
                break;
            case R.id.btn2:
                rotateTest(view);
                break;
            case R.id.btn3:
                scaleTest(view);
                break;
            case R.id.btn4:
                translateTest(view);
                break;
            case R.id.btn5:
                moreAnim(view);
                break;
            case R.id.btn6:
                animSet(view);
                break;
            case R.id.btn7:

                break;
        }
    }

    private void alphaTest(View view) {
        //xml文件写法
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_test);
//        view.startAnimation(animation);

        //代码写法
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(3000);
        view.startAnimation(animation);

    }

    private void rotateTest(View view) {
        //xml文件写法
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_test);
//        view.startAnimation(animation);

        //代码写法
        RotateAnimation animation = new RotateAnimation(0.0f, 360f, view.getWidth() / 2, view.getHeight() / 2);
        animation.setDuration(3000);
        view.startAnimation(animation);
    }

    private void scaleTest(View view) {
        //xml文件写法
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_test);
//        view.startAnimation(animation);

        //代码写法
        ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 0, 0);
        animation.setDuration(3000);
        view.startAnimation(animation);
    }

    private void translateTest(View view) {
        //xml文件写法
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_test);
//        view.startAnimation(animation);

        //代码写法
        TranslateAnimation animation = new TranslateAnimation(0f, 0f, 0f, 200f);
        animation.setDuration(3000);
        view.startAnimation(animation);
    }

    private void moreAnim(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.more_test);
        view.startAnimation(animation);
    }

    private void animSet(View view) {
        AnimationSet anim = new AnimationSet(this, null);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_test);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.more_test);
        anim.addAnimation(animation);
        anim.addAnimation(animation1);
        anim.setDuration(3000);
        view.startAnimation(anim);
    }

}
