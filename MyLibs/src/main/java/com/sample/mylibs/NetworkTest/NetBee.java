package com.sample.mylibs.NetworkTest;

import java.util.Map;

/**
 * Created by haoyundong on 2018/5/14.
 */

public class NetBee {

    private static TaskQueue queue;

    static {
        BaseNetRequest net = new HurlNetRequest();
        queue = new TaskQueue(net);
    }

    public static void get(String url, Map<String, String> params, ResponseListener listener) {
        NetTask task = new NetTask(url, Method.GET, params, listener);
        queue.add(task);
    }

    public static void post(String url, Map<String, String> params, ResponseListener listener) {
        NetTask task = new NetTask(url, Method.POST, params, listener);
        queue.add(task);
    }

    public static String doSyncGet(String url, Map<String, String> params) {
        BaseNetRequest net = new HurlNetRequest();
        String result = net.get(url, params);
        return result;
    }

    public static String doSyncPost(String url, Map<String, String> params) {
        BaseNetRequest net = new HurlNetRequest();
        String result = net.post(url, params);
        return result;
    }
}
