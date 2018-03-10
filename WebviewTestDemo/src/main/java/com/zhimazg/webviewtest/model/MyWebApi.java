package com.zhimazg.webviewtest.model;

import android.app.Activity;

import com.zhimadj.utils.ToastBox;
import com.zhimadj.utils.webview.WVAObject;
import com.zhimadj.utils.webview.WebViewApi;
import com.zhimadj.utils.webview.ZmdjWebView;

/**
 * Created by haoyundong on 2016/11/2.
 */

public class MyWebApi implements WebViewApi {

    private Activity activity;
    private ZmdjWebView webView;

    public MyWebApi(Activity activity, ZmdjWebView webView) {
        this.activity = activity;
        this.webView = webView;
    }



    @Override
    public String exec(WVAObject wvaObject, org.codehaus.jackson.JsonNode jsonNode) {
        switch (wvaObject.type) {
            case "aaa":
                ToastBox.showBottom(activity, jsonNode.asText());
                break;
            case "bbb":
                ToastBox.showBottom(activity, (jsonNode.get("message") + "").replace("\"",""));
                break;

        }
        return null;
    }
}
