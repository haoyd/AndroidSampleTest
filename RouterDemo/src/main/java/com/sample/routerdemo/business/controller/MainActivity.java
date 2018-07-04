package com.sample.routerdemo.business.controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sample.routerdemo.R;
import com.sample.routerdemo.business.model.TestParcelable;
import com.sample.routerdemo.router.RouterManager;

@Route(path = RouterManager.PAGE_MAIN)
public class MainActivity extends BaseActivity {

    @Autowired
    String msg;

    private TestParcelable testParcelable = new TestParcelable() {
        @Override
        public void onResult() {
            super.onResult();
            Log.d("MainActivity", ">>>>>>>>>>   回调成功");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(msg)) {
            Log.d("MainActivity", ">>>>>>>>>>   " + msg);
        } else {
            Log.d("MainActivity", ">>>>>>>>>>   没有获取到传递信息");
        }
    }

    public void FirstActivity(View view) {
        RouterManager.startFirstPage();
    }

    public void SecondActivity(View view) {
        RouterManager.startSecondPage();
    }

    public void ThirdActivity(View view) {
        RouterManager.startThirdPage();
    }

    public void fourthActivity(View view) {
        RouterManager.startFourthPage();
    }


    public void fifthActivity(View view) {
        RouterManager.startFifthPage(testParcelable);
    }
}
