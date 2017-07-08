package com.zhimazg.flipdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity {

    private FlipView flipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
        loadListener();
    }

    private void loadView() {


        flipView = (FlipView) findViewById(R.id.flip_view);
        flipView.setAdapter(getAdapter());
    }

    private void loadData() {

    }

    private void loadListener() {

    }

    private MyAdapter getAdapter() {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            list.add(""+i);
        }

        return new MyAdapter(MainActivity.this,list);
    }
}
