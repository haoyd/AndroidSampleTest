package com.sample.PluginsDemo.ButterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sample.PluginsDemo.R;

public class BTActivity extends Activity {



    private android.widget.TextView tv;
    private android.widget.EditText et;
    private android.widget.Button btn;
    private android.widget.ImageView iv;
    private android.widget.LinearLayout activitybt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);
        this.activitybt = (LinearLayout) findViewById(R.id.activity_bt);
        this.iv = (ImageView) findViewById(R.id.iv);
        this.btn = (Button) findViewById(R.id.btn);
        this.et = (EditText) findViewById(R.id.et);
        this.tv = (TextView) findViewById(R.id.tv);

        String a = getString(R.string.testString);
        String b = "";



    }
}
