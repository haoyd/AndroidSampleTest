package com.zhimazg.receiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private DynamicBroadcast dynamicBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
        loadData();
        loadListener();

    }

    private void loadView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
    }

    private void loadData() {
        dynamicBroadcast = new DynamicBroadcast(MainActivity.this);

    }

    private void loadListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendStaticBroadcast();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dynamicBroadcast();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rderedBroadcast();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stickBroadcast();
            }
        });


    }

    /**
     * 发送静态广播
     */
    private void sendStaticBroadcast() {
        Log.i(TAG, "sendStaticBroadcast");
        String action = "a.b.c.d";
        Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    /**
     * 发送动态广播
     */
    private void dynamicBroadcast() {
        Log.i(TAG, "dynamicBroadcast");
        //动态广播一般在onStart中注册,在onStop中解注册
        String action = "e.f.g.h";
        dynamicBroadcast.registAction(action);


        Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    /**
     * 发送有有序广播
     */
    private void rderedBroadcast() {
        Log.i(TAG, "OrderedBroadcast");
        String action = "i.j.k.l";
        Intent intent = new Intent(action);
        Bundle bundle = new Bundle();
        bundle.putString("a", "aaa");
        intent.putExtras(bundle);
        sendOrderedBroadcast(intent, null);
    }

    /**
     * 发送粘性广播
     */
    private void stickBroadcast() {


        //这种广播可以通过以下方式移除
//        removeStickyBroadcast(intent);


        //3秒后发送
        getWindow().getDecorView().postDelayed(new Runnable() {

            @Override
            public void run()
            {
                Intent intent = new Intent();
                intent.setAction(MyStickyBroadcast.ACTION);
                intent.putExtra("aa", "hahaha");
                sendStickyBroadcast(intent);
            }
        }, 1*1000);

//15秒后就收
        getWindow().getDecorView().postDelayed(new Runnable() {

            @Override
            public void run()
            {
                IntentFilter intentFilter = new IntentFilter(MyStickyBroadcast.ACTION);
                //通过这个方式获取到粘性广播的值
                Intent data = registerReceiver(null, intentFilter);
                if(data!=null && MyStickyBroadcast.ACTION.equals(data.getAction()))
                {
                    Toast.makeText(MainActivity.this, data.getStringExtra("aa"), Toast.LENGTH_SHORT).show();
                }

            }
        }, 6*1000);
    }



}
