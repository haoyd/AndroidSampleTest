package com.sample.killgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText totalEdit;
    private EditText badEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalEdit = findViewById(R.id.total);
        badEdit = findViewById(R.id.bad_nums);
    }

    public void startGame(View view) {
        if (TextUtils.isEmpty(totalEdit.getText().toString())) {
            ToastBox.showBottom(this, "请输入总人数");
            return;
        }

//        if (!TextUtils.isEmpty(badEdit.getText().toString())) {
//            ToastBox.showBottom(this, "请杀手人数");
//        }

        int totalNum = Integer.parseInt(totalEdit.getText().toString());
        Intent intent = GameActivity.getGameIntent(this, totalNum, 1);
        startActivity(intent);
    }
}
