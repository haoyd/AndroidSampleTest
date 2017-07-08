package com.zhimazg.widgetdemo.controller.activity;

import android.app.Activity;
import android.os.Bundle;

import com.zhimazg.widgetdemo.R;
import com.zhimazg.widgetdemo.model.libs.niceSpinner.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpinnerActivity extends Activity {

    private NiceSpinner niceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        niceSpinner = (NiceSpinner) findViewById(R.id.spinner_spinner_nice);
        List<String> datas = new LinkedList<String>(Arrays.asList("one","two"));
        niceSpinner.attachDataSource(datas);
    }
}
