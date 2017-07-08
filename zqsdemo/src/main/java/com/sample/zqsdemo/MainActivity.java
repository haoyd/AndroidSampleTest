package com.sample.zqsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ImageAdapter imageadapter;

    MyGridAdapter adapter1;
    MyGridAdapter adapter2;

    private GridView gridView1;
    private GridView gridView2;

    List<String> list1;
    List<String> list2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        for(int i = 0; i < 5;i++){
            list1.add(i + "");
        }

        adapter1 = new MyGridAdapter(MainActivity.this,list1);
        adapter2 = new MyGridAdapter(MainActivity.this,list2);



        gridView1 = (GridView) findViewById(R.id.gridView1);
        gridView2 = (GridView) findViewById(R.id.gridView2);

        gridView1.setAdapter(adapter1);
        gridView2.setAdapter(adapter2);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                list2.add(list1.get(position));
                list1.remove(position);
                adapter1.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
            }
        });

    }

    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {

            }
            super.handleMessage(msg);
        }
    };

}
