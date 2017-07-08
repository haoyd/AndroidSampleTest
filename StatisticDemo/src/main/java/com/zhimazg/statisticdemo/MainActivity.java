package com.zhimazg.statisticdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configStatistic();
        loadView();
        loadListener();

    }

    private void loadView() {
        btn1 = (Button) findViewById(R.id.jump_main1);
        btn2 = (Button) findViewById(R.id.jump_main2);
        btn3 = (Button) findViewById(R.id.jump_main3);
        btn4 = (Button) findViewById(R.id.jump_main4);
    }

    private void loadListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));

                Map<String, String> m = new HashMap<String, String>();
                m.put("a", "1");
                MobclickAgent.onEventValue(MainActivity.this, "event1", m, 1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> m = new HashMap<String, String>();
                m.put("a", "2");
                MobclickAgent.onEventValue(MainActivity.this, "event2", m, 1);
                Toast.makeText(MainActivity.this, "event2", Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> m = new HashMap<String, String>();
                m.put("a", "3");
                MobclickAgent.onEventValue(MainActivity.this, "event1", m, 1);
                Toast.makeText(MainActivity.this, "event3", Toast.LENGTH_SHORT).show();

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> m = new HashMap<String, String>();
                m.put("a", "4");
                MobclickAgent.onEventValue(MainActivity.this, "event2", m, 1);
                Toast.makeText(MainActivity.this, "event4", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void configStatistic() {
        /** 设置是否对日志信息进行加密, 默认false(不加密). */
//        AnalyticsConfig.enableEncrypt(boolean enable);//6.0.0版本以前
//        MobclickAgent.enableEncrypt(boolean enable);//6.0.0版本及以后
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
