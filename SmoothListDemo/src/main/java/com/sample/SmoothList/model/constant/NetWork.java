package com.sample.SmoothList.model.constant;

import android.content.Context;
import android.net.NetworkRequest;

import com.android.volley.Request;
import com.android.volley.Response;
import com.sample.SmoothList.model.bean.ProductInfo;
import com.zhimadj.net.NetRequest;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by haoyundong on 16/9/26.
 */

public class NetWork {
    private static NetWork netWork;


    private NetWork(){}

    public static NetWork getInstance(){

        if(netWork == null){
            synchronized (NetWork.class){
                if(netWork == null){
                    netWork = new NetWork();
                }
            }
        }

        return netWork;

    }


    public void getData(Context context, Map<String, String> params, Response.Listener<ProductInfo> listener, Response.ErrorListener errorListener){
        NetRequest.doRequest(context,NetConstant.URL, params, null, Request.Method.GET, ProductInfo.class, listener, errorListener);
    }

}
