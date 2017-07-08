package com.zhimazg.statisticdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends BaseActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loadView();
        loadListener();
    }

    private void loadView() {
        button = (Button) findViewById(R.id.btn_main2);
    }

    private void loadListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
