package com.zhimazg.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyService myService;

    private Button button1;
    private Button button2;
    private Button button3;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);


        loadListener();

        //在manifest中注册的service
//        startService(new Intent(MainActivity.this, MyService2.class));
    }


    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TAG, "onServiceConnected()");
            myService = ((MyService.MyBinder) iBinder).getService();
//            myService.executeService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TAG, "onServiceDisconnected()");
            myService = null;
        }
    };


    private void loadListener() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toBind();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUnbind();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "love", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void toBind() {
        Log.i(TAG, "bindService()");
        Intent serviceIntent = new Intent(MainActivity.this, MyService.class);
        bindService(serviceIntent, sc, Context.BIND_AUTO_CREATE);
    }

    private void toUnbind() {
        Log.i(TAG, "unBindService()");
        unbindService(sc);
    }


}
