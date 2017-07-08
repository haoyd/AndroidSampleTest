package com.zhimazg.widgetdemo.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.zhimazg.widgetdemo.R;
import com.zhimazg.widgetdemo.view.TitleTipView;

public class TitleTipActivity extends AppCompatActivity {

    private TitleTipView titleTipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_tip);

        loadView();
        loadListener();
    }



    private void loadView() {
        titleTipView = (TitleTipView) findViewById(R.id.ttv);
    }

    private void loadListener() {
        titleTipView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(view.getContext(), "您点击了第" + position + "个按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
