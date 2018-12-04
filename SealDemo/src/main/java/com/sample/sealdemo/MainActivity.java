package com.sample.sealdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.sample.sealdemo.demo1.SealView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_main);
        imageView = findViewById(R.id.iv_main);
    }

    public void setupSeal(View view) {
        String companyName = editText.getText().toString();
        if (!TextUtils.isEmpty(companyName)) {
            imageView.setImageBitmap(SealView.DrawDeal(5, companyName, 400));
        }
    }
}
