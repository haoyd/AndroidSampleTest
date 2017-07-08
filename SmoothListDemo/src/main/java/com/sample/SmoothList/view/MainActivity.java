package com.sample.SmoothList.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sample.SmoothList.R;
import com.sample.SmoothList.controller.MyAdapter;
import com.sample.SmoothList.model.bean.ProductInfo;
import com.sample.SmoothList.model.constant.NetWork;
import com.zhimadj.utils.ImageCache;

public class MainActivity extends Activity {
    private ListView listView;

    private MyAdapter adapter;

    private Response.Listener<ProductInfo> successListener;
    private Response.ErrorListener errorListener;

    private NetWork netWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadView();
        loadListener();
        loadData();
    }

    private void loadView() {
        listView = (ListView) findViewById(R.id.list);


    }

    private void loadData() {
//        netWork = NetWork.getInstance();
//        netWork.getData(MainActivity.this, null, successListener, errorListener);


        adapter = new MyAdapter(MainActivity.this, null, listView);
        listView.setAdapter(adapter);
    }

    private void loadListener() {
        successListener = new Response.Listener<ProductInfo>() {
            @Override
            public void onResponse(ProductInfo response) {
                if(response != null){
                    adapter = new MyAdapter(MainActivity.this, response,listView);
                }
            }
        };

        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };

    }


}
