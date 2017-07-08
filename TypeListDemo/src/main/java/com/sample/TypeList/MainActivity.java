package com.sample.TypeList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> datas = new ArrayList<Integer>();

    private ListView listView;

    private TypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
        loadListener();


    }

    private void loadView() {
        listView = (ListView) findViewById(R.id.lv);
    }

    private void loadData() {

        for(int i = 0; i < 20; i ++){
                datas.add(i % 3);
        }

        adapter = new TypeAdapter(MainActivity.this, datas);
        listView.setAdapter(adapter);
    }

    private void loadListener() {

    }


}
