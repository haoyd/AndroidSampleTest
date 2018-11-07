package com.sample.debugdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class ProfilerTestActivity extends AppCompatActivity {

    public static final String TAG = "ProfilerTestActivity";

    private List<Integer> data = new ArrayList<>();
    private ImageView imageView;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profiler_test);
        imageView = findViewById(R.id.iv_profiler_test);

        requestQueue = Volley.newRequestQueue(this);
    }

    public void click1(View view) {
        String url = "http://test.api.shop.zhimazg.com/home?density=3.0&app_vercode=30900&os_vercode=26&ppi=1080X2032&channel=0&os_vername=8.0.0&app_vername=3.9.0&operator=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8&token=15514260194e4593f498837b6576891018133b39deuid2203&geo=116.41666422526042%2C40.03319363064236&is_virtual_app=false&sensors_data=%7B%22%24app_version%22%3A%223.9.0%22%2C%22%24lib%22%3A%22Android%22%2C%22%24lib_version%22%3A%222.0.2%22%2C%22%24manufacturer%22%3A%22HUAWEI%22%2C%22%24model%22%3A%22LLD-AL00%22%2C%22%24os%22%3A%22Android%22%2C%22%24os_version%22%3A%228.0.0%22%2C%22%24screen_height%22%3A2160%2C%22%24screen_width%22%3A1080%2C%22%24wifi%22%3Atrue%2C%22%24network_type%22%3A%22WIFI%22%2C%22%24carrier%22%3A%22%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8%22%2C%22%24is_first_day%22%3Atrue%2C%22%24device_id%22%3A%22537ab1bb321e9a4e%22%7D&user_device_id=ffffffff-fada-8851-ffff-ffffd7bd75b9&from=2&model=LLD-AL00&net=wifi&request_id=24d2d1e320be44bb9eca5966d443e013";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (TextUtils.isEmpty(response)) {
                    return;
                }

                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.getMessage());
            }
        });

        requestQueue.add(request);
    }



}
