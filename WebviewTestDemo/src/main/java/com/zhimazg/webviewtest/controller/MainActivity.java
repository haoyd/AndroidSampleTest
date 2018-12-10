package com.zhimazg.webviewtest.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhimazg.webviewtest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Activity mActivity;
    private ListView listView;

    private List<String> pages;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;

        initView();
        initData();
        bindListener();
    }



    private void initView() {
        listView = findViewById(R.id.lv_main);

    }

    private void initData() {
        pages = new ArrayList<>();
        pages.add("H5-NA交互测试");
        pages.add("直接打开Url");
        pages.add("WebView设置");
        pages.add("WebView适应内容高度");
        pages.add("DSBridge测试");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pages);
        listView.setAdapter(adapter);
    }

    private void bindListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        startActivity(new Intent(MainActivity.this, H5NaTestActivity.class));
                        break;
                    }
                    case 1: {
                        Uri uri = Uri.parse("http://www.baidu.com");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(mActivity, WebviewActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(mActivity, ListWebviewActivity.class));
                    }
                    case 4: {
                        startActivity(new Intent(mActivity, DSActivity.class));
                    }
                }
            }
        });

    }

}
