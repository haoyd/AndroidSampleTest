package com.sample.ListExpand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
    }

    private void loadView() {
        expandableListView = (ExpandableListView) findViewById(R.id.elv);
        //去掉默认的箭头
        expandableListView.setGroupIndicator(null);

        adapter = new MyAdapter(this);
        expandableListView.setAdapter(adapter);

        int groupCount = expandableListView.getCount();
        for(int i = 0; i < groupCount; i++){
            expandableListView.expandGroup(i);
        }


    }

    private void loadData() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                return true;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this,"" + i + ":::" + i1, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
}
