package com.sample.debugdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String[] menus = {
        "for循环调试"
    };

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
        }
    }

    private void forTest() {
        for (int i =0; i < 10; i++) {
            String s = "i:  " + i;
        }
    }
}
