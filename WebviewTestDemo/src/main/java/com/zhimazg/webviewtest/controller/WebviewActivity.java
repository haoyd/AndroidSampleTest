package com.zhimazg.webviewtest.controller;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebviewActivity extends Activity {

    private WebView webView;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;

        loadView();
        loadData();
    }

    private void loadView() {
        webView = new WebView(this);
        setContentView(webView);
    }

    private void loadData() {
//        loadHtmlText();
        loadCompanyUrl();

    }

    /**
     * 通过加载超文本来加载页面
     */
    private void loadHtmlText() {
        String summary = "<html><body>You scored <b>192</b> points.</body></html>";
        webView.loadData(summary, "text/html", "UTF-8");
    }

    private void loadCompanyUrl() {
        webView.loadUrl("http://api.supply.zhimazg.com/home");
    }
}
