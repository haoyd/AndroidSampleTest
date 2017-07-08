package com.sample.listmixdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listView;
    private List<String> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
    }

    private void loadView() {
        listView = (ListView) findViewById(R.id.list);

        list = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            list.add(""+i);
        }

        adapter = new MyAdapter(MainActivity.this,list);

        listView.setAdapter(adapter);

    }
}
