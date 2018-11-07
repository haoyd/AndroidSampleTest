package com.sample.debugdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String TAG = "MainActivity";

    public static final String[] menus = {
            "for循环调试",
            "计算表达式",
            "日志输出",
            "特殊log技巧",
            "查看错误日志",
            "Android Profiler",
            "耗时方法测试"
    };

    public static final int[] testData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private MenuListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_main);
        listView.bindData(menus);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                forTest();
                break;
            case 1:
                sumSelf(20);
                break;
            case 2:
                logTest();
                break;
            case 3:
                specialLogSkill();
                break;
            case 4:
                commonExceptionCheck();
                break;
            case 5:
                startActivity(new Intent(this, ProfilerTestActivity.class));
                break;
            case 6:
                longRunningOperation();
                break;
        }
    }

    /**
     * for循环测试
     */
    private void forTest() {
        for (int i =0; i < 10; i++) {
            String s = "i:  " + i;
        }
    }

    /**
     * 从1加到本身
     * @param num
     * @return
     */
    private int sumSelf(int num) {
        int result = 0;

        for (int i = 0; i < num; i++) {
            result += i;
        }

        return result;
    }

    /**
     * 打印log的各种类型
     */
    private void logTest() {
        Log.v(TAG, "测试");
        Log.d(TAG, "测试");
        Log.i(TAG, "测试");
        Log.w(TAG, "测试");
        Log.e(TAG, "测试");
        Log.wtf(TAG, "测试");
    }

    /**
     * 特殊log输出日志
     */
    private void specialLogSkill() {
        Log.d(TAG, "specialLogSkill(MainActivity.java:79)");
    }

    /**
     * 异常日志分析
     */
    private void commonExceptionCheck() {
        try {
            Cat cat = null;
            cat.catchMouse();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            Animal animal = new Animal();
            ((Cat) animal).catchMouse();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    /**
     * 耗时方法测试
     */
    private void longRunningOperation() {
        try {
            Thread.sleep(2000);
            Toast.makeText(this, "耗时方法测试", Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

