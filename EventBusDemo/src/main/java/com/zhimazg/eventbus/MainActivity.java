package com.zhimazg.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView show;
    private Button jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFindView();
        registEvent();
        loadView();
        loadData();
        loadListener();


    }


    private void initFindView() {
        show = (TextView) findViewById(R.id.show);
        jump = (Button) findViewById(R.id.jump);

    }

    private void registEvent() {
        EventBus.getDefault().register(this);
    }


    private void loadView() {

    }

    private void loadData() {

    }


    private void loadListener() {
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onShowMsgEvent(MessageEvent messageEvent) {
        if (messageEvent != null && messageEvent.getMsg().equals("")) {
            Toast.makeText(this, "没有回返实体消息", Toast.LENGTH_SHORT).show();
        } else if (messageEvent != null && !messageEvent.getMsg().equals("")) {
            Toast.makeText(this, "有回返实体消息", Toast.LENGTH_SHORT).show();
            show.setText("Msg from SecondActivity:" + messageEvent.getMsg());

        } else {
            Toast.makeText(this, "实体为空", Toast.LENGTH_SHORT).show();

        }
    }



}
