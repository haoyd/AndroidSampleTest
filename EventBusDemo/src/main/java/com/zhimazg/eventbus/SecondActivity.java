package com.zhimazg.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class SecondActivity extends AppCompatActivity {

    private EditText input;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EventBus.getDefault().register(this);

        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.btn_give);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (true) {
//                    MessageEvent messageEvent = new MessageEvent(input.getText() + "");
//                    messageEvent.setMsg("你好吗");

//                    EventBus.getDefault().post(messageEvent);
//                    finish();

                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.PostThread)
    public void onShowMsgEvent(MessageEvent messageEvent) {
//        Toast.makeText(this, "SecondActivity", Toast.LENGTH_SHORT).show();
        input.setText(messageEvent.getMsg());
    }
}
