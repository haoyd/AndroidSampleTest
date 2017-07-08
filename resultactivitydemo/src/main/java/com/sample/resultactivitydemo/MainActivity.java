package com.sample.resultactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView show;
    private Button jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadListener();
    }


    private void loadView() {
        show = (TextView) findViewById(R.id.tv_show);
        jump = (Button) findViewById(R.id.btn_jump);

    }

    private void loadListener(){
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("haha",">>>>>"+"A--onActivityResult");

        if(requestCode ==1 && resultCode == 1){
            String index = data.getStringExtra("index");
            show.setText(index);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("haha",">>>>>"+"A--onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("haha",">>>>>"+"A--onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("haha",">>>>>"+"A--onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("haha",">>>>>"+"A--onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("haha",">>>>>"+"A--onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("haha",">>>>>"+"A--onDestroy");
    }
}
