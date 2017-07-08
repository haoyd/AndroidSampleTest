package com.zhimazg.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class ThirdActivity extends Activity {

    private EditText editText;
    private Button sendMsg;
    private EditText inputthird;
    private Button btnthird;
    private android.widget.RelativeLayout activitythird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        EventBus.getDefault().register(this);

        loadView();
    }

    private void loadView(){
        this.activitythird = (RelativeLayout) findViewById(R.id.activity_third);
        this.btnthird = (Button) findViewById(R.id.btn_third);
        this.inputthird = (EditText) findViewById(R.id.input_third);

        btnthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageEvent messageEvent = new MessageEvent(inputthird.getText() + "");

                EventBus.getDefault().post(messageEvent);
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.PostThread)
    public void onShowMsgEvent(MessageEvent messageEvent) {
    }
}
