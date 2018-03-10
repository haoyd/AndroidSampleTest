package com.sample.dimdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * 本次有以下几个技术点需要实现：
 * 1.系统顶部栏的背景颜色和字体颜色改变
 * 2.高斯模糊
 * 3.监听滑动，到顶部的时候要改变颜色
 * 4.ScrollView嵌套ListView解决滑动冲突
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button6(View view) {
        startActivity(new Intent(this, WindowTopActivity.class));
    }

    public void button7(View view) {
        startActivity(new Intent(this, ImageDimActivity.class));
    }

    public void button8(View view) {
        startActivity(new Intent(this, GradualChangeActivity.class));
    }

    public void button9(View view) {
        startActivity(new Intent(this, EventConflictActivity.class));
    }

    public void button10(View view) {
        startActivity(new Intent(this, HeaderPagerActivity.class));
    }






}
