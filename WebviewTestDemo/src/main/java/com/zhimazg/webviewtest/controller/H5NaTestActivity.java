package com.zhimazg.webviewtest.controller;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.zhimazg.webviewtest.R;

public class H5NaTestActivity extends AppCompatActivity {


    private WebView webView;

    private Button button;

    private Handler mHandler = new Handler() {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_na_test);

        webView = (WebView) findViewById(R.id.webview);
        button = (Button) findViewById(R.id.btn);

//        webView.setWebContentsDebuggingEnabled(true);

        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webView.setWebChromeClient(new H5NaTestActivity.MyWebChromeClient());
        webView.setWebViewClient(new MyWebViewClient());
        webView.addJavascriptInterface(new H5NaTestActivity.DemoJavaScriptInterface(), "demo");
        webView.loadUrl("file:///android_asset/index.html");

//        String result = "";
//        result = AssetUtil.file2String(MainActivity.this, "index.html");
//        webView.loadDataWithBaseURL(null, result,  "text/html", "utf-8", null);
//        webView.loadUrl("http://www.baidu.com");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Android调用WebView方法";

//                webView.loadUrl("javascript:wave('你好，我叫安卓')");
                webView.loadUrl("javascript:wave()");
//                webView.loadUrl("javascript:wave2('你好，我叫安卓')");

            }
        });
    }

    final class DemoJavaScriptInterface {
        DemoJavaScriptInterface() {
        }

        /**
         * This is not called on the UI thread. Post a runnable to invoke
         * loadUrl on the UI thread.
         */
        @JavascriptInterface
        public void clickOnAndroid(final String msg) {
            mHandler.post(new Runnable() {
                public void run() {
//                    webView.loadUrl("javascript:wave()");
                    Log.d("tag", "web页面执行了Android回调");
//                    Toast.makeText(MainActivity.this, "Web端点击了页面", Toast.LENGTH_SHORT).show();
                    Toast.makeText(H5NaTestActivity.this, "webView说：" + msg, Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Log.d("onJsAlert", message);
            result.confirm();

            new AlertDialog.Builder(H5NaTestActivity.this)
                    .setTitle("WebAlert")
                    .setMessage(message)
                    .setNegativeButton("确定", null)
                    .show();


            return super.onJsAlert(webView, url, message, result);
        }
    }

    final class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
