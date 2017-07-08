package com.sample.pulltorereshdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshListView listView;

    private SimpleAdapter adapter;
    List<Map<String, String>> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (PullToRefreshListView) findViewById(R.id.pull_to_refresh);
        loadView();
        loadListener();
    }



    private void loadView(){
        listView.setMode(PullToRefreshBase.Mode.BOTH);

        datas = new ArrayList<Map<String, String>>();
        for(int i = 0; i < 10; i++){
            Map<String, String> listem = new HashMap<String, String>();
            listem.put("a",""+i);
            datas.add(listem);
        }

        adapter = new SimpleAdapter(MainActivity.this, datas,
                R.layout.item_list,new String[] { "a"}, new int[] {R.id.tv_item});
        listView.setAdapter(adapter);
    }

    private void loadListener() {
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listView.onRefreshComplete();
                    }
                },1600);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listView.onRefreshComplete();
                    }
                },1600);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
