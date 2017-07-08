package com.sample.listpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private PagerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        loadView();
    }

    private void loadView() {
        listView = (ListView) findViewById(R.id.lv);

        adapter = new PagerListAdapter(this);

        listView.setAdapter(adapter);
    }
}
