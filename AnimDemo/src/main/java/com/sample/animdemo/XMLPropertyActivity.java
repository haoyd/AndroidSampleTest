package com.sample.animdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class XMLPropertyActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;

    private ViewGroup container;
    private LayoutTransition mTransition;

    private int mVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlproperty);

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

        cb1 = (CheckBox) findViewById(R.id.id_appear);
        cb2 = (CheckBox) findViewById(R.id.id_change_appear);
        cb3 = (CheckBox) findViewById(R.id.id_disappear);
        cb4 = (CheckBox) findViewById(R.id.id_change_disappear);

        container = (ViewGroup) findViewById(R.id.gl_container);

        mTransition = new LayoutTransition();
        container.setLayoutTransition(mTransition);
    }

    private void loadListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                scaleX(view);
                break;
            case R.id.btn2:
                scaleDouble(view);
                break;
            case R.id.btn3:
                orderAnim(view);
                break;
            case R.id.btn4:
                transitionTest();
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
            case R.id.btn7:

                break;
        }
    }

    /**
     * 执行缩放
     *
     * @param view
     */
    private void scaleX(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.obj_scale);
        animator.setTarget(view);
        animator.start();
    }

    /**
     * 同时执行两个
     *
     * @param view
     */
    private void scaleDouble(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.obj_scale_double);
        animator.setTarget(view);
        animator.start();
    }

    /**
     * 有序执行
     *
     * @param view
     */
    private void orderAnim(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.obj_orderring);
        animator.setTarget(view);
        animator.start();
    }

    private void transitionTest() {
        final Button button = new Button(this);
        button.setText((++mVal) + "");
        container.addView(button, Math.min(1, container.getChildCount()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.removeView(button);
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mTransition = new LayoutTransition();
        mTransition.setAnimator(LayoutTransition.APPEARING, (cb1.isChecked() ? mTransition.getAnimator(LayoutTransition.APPEARING) : null));
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, (cb2.isChecked() ? mTransition.getAnimator(LayoutTransition.CHANGE_APPEARING) : null));
        mTransition.setAnimator(LayoutTransition.DISAPPEARING,(cb3.isChecked() ? mTransition.getAnimator(LayoutTransition.DISAPPEARING) : null));
        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,(cb4.isChecked() ? mTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING): null));
        container.setLayoutTransition(mTransition);
    }
}
