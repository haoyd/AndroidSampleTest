package com.sample.mylibs.NetworkTest;

import java.util.Map;

/**
 * Created by haoyundong on 2018/5/14.
 */

public class NetTask {

    private String url;
    private int method;
    private Map<String, String>params;

    private ResponseListener listener;

    public NetTask(String url, int method, Map<String, String> params, ResponseListener listener) {
        this.url = url;
        this.method = method;
        this.params = params;
        this.listener = listener;
    }

    public String getUrl() {
        return url;
    }

    public int getMethod() {
        return method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public ResponseListener getListener() {
        return listener;
    }
}
