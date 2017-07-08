package com.zhimazg.listlocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list;
    private MyAdapter adapter;

    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
    }

    private void loadView() {
        listView = (ListView) findViewById(R.id.list);
        refresh = (Button) findViewById(R.id.btn_refresh);

        list = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            list.add(""+i);
        }

        adapter = new MyAdapter(MainActivity.this,list);

        listView.setAdapter(adapter);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add("1000");
                adapter.notifyDataSetChanged();
            }
        });

    }
}
