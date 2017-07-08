package com.zhimazg.webviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;

import com.zhimadj.utils.Jackson;
import com.zhimadj.utils.ToastBox;
import com.zhimadj.utils.webview.WVAObject;
import com.zhimadj.utils.webview.WebViewCallback;
import com.zhimadj.utils.webview.ZmdjWebView;

import org.codehaus.jackson.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private ZmdjWebView webView;
    private MyWebApi myWebApi;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        loadView();
        initWeb();
        loadData();
        loadListener();


    }

    private void loadView() {
        webView = (ZmdjWebView) findViewById(R.id.webview_second);
        button = (Button) findViewById(R.id.button);
    }

    private void initWeb() {
        myWebApi = new MyWebApi(this, webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);

        webView.init(myWebApi, new ZmdjWebView.ISetting() {
            @Override
            public void setTitle(String s) {

            }

            @Override
            public void showErrorTitle() {

            }

            @Override
            public void hideErrorTitle() {

            }
        }, null);


    }

    private void loadData() {
        webView.loadUrl("file:///android_asset/js-na-test.html");
    }

    private void loadListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WVAObject wvaObject = new WVAObject();
                wvaObject.type = "bbb";
                webView.getData(wvaObject, Jackson.toJsonNode("{}"), new WebViewCallback(){
                    @Override
                    public void exec(JsonNode jsonNode) {
                        try {
                            ToastBox.showBottom(SecondActivity.this, new JSONObject(jsonNode.asText()).optString("msg"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}




































