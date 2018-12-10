package com.zhimazg.webviewtest.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.zhimadj.utils.ToastBox;
import com.zhimazg.webviewtest.R;

import wendu.dsbridge.CompletionHandler;
import wendu.dsbridge.DWebView;
import wendu.dsbridge.OnReturnValue;

public class DSActivity extends AppCompatActivity {

    private JsApi jsApi;
    private DWebView webView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds);

        context = this;

        webView = findViewById(R.id.dwebview);
        jsApi = new JsApi();
        webView.addJavascriptObject(jsApi, null);
        DWebView.setWebContentsDebuggingEnabled(true);

        webView.loadUrl("file:///android_asset/dsweb.html");
    }

    public void buttonClick(View view) {
        webView.callHandler("addValue", new Object[]{3, 4}, new OnReturnValue<Integer>() {
            @Override
            public void onValue(Integer retValue) {
                ToastBox.showBottom(context, "结果为：" + retValue);
            }
        });
    }

    public void 检测是否存在方法(View view) {
        webView.hasJavascriptMethod("addValue", new OnReturnValue<Boolean>() {
            @Override
            public void onValue(Boolean retValue) {
                ToastBox.showBottom(context, "结果为：" + retValue);
            }
        });
    }

    public void 异步回调(View view) {
        webView.callHandler("append",new Object[]{"I","love","you"},new OnReturnValue<String>(){
            @Override
            public void onValue(String retValue) {
                ToastBox.showBottom(context, "结果为：" + retValue);

            }
        });
    }

    public class JsApi {
        //同步API
        @JavascriptInterface
        public String testSyn(Object msg) {
            return msg + "同步调用";
        }

        //异步API
        @JavascriptInterface
        public void testAsyn(Object msg, CompletionHandler<String> handler) {
            handler.complete(msg + "异步回调");
        }

        @JavascriptInterface
        public void callProgress(Object args, final CompletionHandler<Integer> handler) {
            new CountDownTimer(11000, 1000) {

                int i = 10;

                @Override
                public void onTick(long millisUntilFinished) {
                    //setProgressData can be called many times util complete be called.
                    handler.setProgressData((i--));
                }

                @Override
                public void onFinish() {
                    //complete the js invocation with data;
                    //handler will invalid when complete is called
                    handler.complete(0);
                }
            }.start();
        }
    }


}
