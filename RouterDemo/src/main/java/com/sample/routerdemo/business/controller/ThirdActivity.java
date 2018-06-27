package com.sample.routerdemo.business.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sample.routerdemo.R;
import com.sample.routerdemo.business.model.Person;
import com.sample.routerdemo.router.RouterManager;

@Route(path = RouterManager.PAGE_THIRD)
public class ThirdActivity extends AppCompatActivity {

    @Autowired
    public Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ARouter.getInstance().inject(this);
    }

    public void showMsg(View view) {
        if (person != null) {
            Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "信息为空", Toast.LENGTH_SHORT).show();
        }
    }
}
