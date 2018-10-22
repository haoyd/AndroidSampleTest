package com.sample.debugdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String[] menus = {
            "for循环调试",
            "计算表达式"
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
//                int result = sumSelf(20);
                int a = 10;
                int b = 20;
                break;
        }
    }

    private void forTest() {
        for (int i =0; i < 10; i++) {
            String s = "i:  " + i;
        }
    }


    private int sumSelf(int num) {
        int result = 0;

        for (int i = 0; i < num; i++) {
            result += i;
        }

        return result;
    }
}
