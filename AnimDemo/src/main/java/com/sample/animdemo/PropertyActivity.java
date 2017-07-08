package com.sample.animdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class PropertyActivity extends Activity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

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
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
    }

    private void loadListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                mostEasyTest(view);
                break;
            case R.id.btn2:
                moreAnim(view);
                break;
            case R.id.btn3:
                popertyHolder(view);
                break;
            case R.id.btn4:
                valueAnimator(view);
                break;
            case R.id.btn5:
                parabola(view);
                break;
            case R.id.btn6:
                animListener(view);
                break;
            case R.id.btn7:
                animListenerAdapter(view);
                break;
            case R.id.btn8:
                animSet1(view);
                break;
            case R.id.btn9:
                animSet2(view);
                break;


        }
    }

    private void mostEasyTest(View view) {
        ObjectAnimator
                .ofFloat(view, "rotationX", 0f, 360f)
                .setDuration(3000)
                .start();

    }

    private void moreAnim(final View view) {
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "zhy", 0f, 1f)
                .setDuration(3000);
        anim.start();

        view.setPivotX(0);
        view.setPivotY(0);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    private void popertyHolder(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f, 0f, 1f, 0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f, 0f, 1f, 0f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f, 0f, 1f, 0f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(4000).start();
    }

    private void valueAnimator(final View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 800, 0);
        animator.setTarget(view);
        animator.setDuration(1000).start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }

    private void parabola(final View view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());

        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                view.setX(point.x);
                view.setY(point.y);

            }
        });
    }


    private void animListener(final View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", 0f, 360f);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(view.getContext(), "开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(view.getContext(), "结束", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Toast.makeText(view.getContext(), "取消", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Toast.makeText(view.getContext(), "再来一次", Toast.LENGTH_SHORT).show();
            }
        });

        animator.setDuration(3000);
        animator.setRepeatCount(4);
        animator.start();
    }

    private void animListenerAdapter(final View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationX", 0f, 360f);
        animator.setDuration(2000);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(view.getContext(), "结束", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void animSet1(View view) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.setInterpolator(new LinearInterpolator());
        //两个动画同时执行
        animSet.playTogether(anim1, anim2);
        animSet.start();
    }

    private void animSet2(View view) {
        float cx = view.getX();
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view, "x", cx, 0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view, "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }


}
