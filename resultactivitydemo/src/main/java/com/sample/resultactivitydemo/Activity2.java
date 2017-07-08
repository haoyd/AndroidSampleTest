package com.sample.resultactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity2 extends Activity {

    private ListView listView;
    private SimpleAdapter adapter;
    private ArrayAdapter<String> arrayAdapter;

    List<Map<String, String>> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        loadView();
        loadListener();
    }

    private void loadView(){
        datas = new ArrayList<Map<String, String>>();
        for(int i = 0; i < 10; i++){
            Map<String, String> listem = new HashMap<String, String>();
            listem.put("a",""+i);
            datas.add(listem);
        }



        listView = (ListView) findViewById(R.id.list);
        adapter = new SimpleAdapter(Activity2.this, datas,
                R.layout.item_list,new String[] { "a"}, new int[] {R.id.tv_item});
        listView.setAdapter(adapter);


    }

    private void loadListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void goBack(int i){
        Intent intent = new Intent();
        intent.putExtra("index", ""+i);
        setResult(1,intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            goBack(5);
//        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("haha",">>>>>"+"B--onPause");
        goBack(5);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("haha",">>>>>"+"B--onStop");
//        goBack(6);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("haha",">>>>>"+"B--onDestroy");
//        goBack(7);
    }
}
