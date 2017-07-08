package com.zhimazg.hotfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.tv_show1);
        textView2 = (TextView) findViewById(R.id.tv_show2);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "未修复。。。", Toast.LENGTH_SHORT).show();
//                command1();
//                command2();

            }
        });
    }

    private void command1(){
        textView1.setText("这是第一个text的显示效果");
    }

    private void command2(){
        textView2.setText("这是第二个text的显示效果");
    }
}
