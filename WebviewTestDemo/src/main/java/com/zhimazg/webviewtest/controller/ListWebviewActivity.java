package com.zhimazg.webviewtest.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zhimazg.webviewtest.R;
import com.zhimazg.webviewtest.view.CustomWebView;

public class ListWebviewActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_webview);

        listView = findViewById(R.id.lv_list_web);
        listView.setAdapter(adapter);
    }


    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new CustomWebView(ListWebviewActivity.this);
            }

            return convertView;
        }
    };


}
