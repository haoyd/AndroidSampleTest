package com.sample.routerdemo.business.controller;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sample.routerdemo.R;
import com.sample.routerdemo.router.RouterManager;


@Route(path = RouterManager.PAGE_FIFTH)
public class FifthActivity extends AppCompatActivity {

    private ResultReceiver mResultReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        ARouter.getInstance().inject(this);

        setup();
    }

    private void setup() {

//        Parcelable objResultReceiver = getIntent().getParcelableExtra("result_receiver");
//        if (objResultReceiver != null) {
//            mResultReceiver = (ResultReceiver) objResultReceiver;
//        }

    }

    public void callback(View view) {
        if (mResultReceiver == null) {
            Toast.makeText(FifthActivity.this, "没有获取到信息", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(FifthActivity.this, "回调", Toast.LENGTH_SHORT).show();
            mResultReceiver.send(Activity.RESULT_OK, null);
        }

    }
}
