package com.sample.routerdemo.business.controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sample.routerdemo.R;
import com.sample.routerdemo.router.RouterManager;

@Route(path = RouterManager.PAGE_FOURTH)
public class FourthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

    }

    public void showMsg(View view) {
        if (!TextUtils.isEmpty(jsonData)) {
            Toast.makeText(this, jsonData, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "参数放到父类不可以解析", Toast.LENGTH_SHORT).show();
        }

    }
}
