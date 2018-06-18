package com.zhimazg.webviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomWebView extends WebView {

    public static final String HTML_DATA = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
            "    <title></title>\n" +
            "    <style>\n" +
            "        * {\n" +
            "            margin: 0;\n" +
            "            padding: 0;\n" +
            "            box-sizing: border-box;\n" +
            "        }\n" +
            "\n" +
            "        body {\n" +
            "            -webkit-font-smoothing: antialiased;\n" +
            "            font-family: \"Helvetica Neue\", Helvetica, \"PingFang SC\", \"Hiragino Sans GB\", \"Microsoft YaHei\", \"微软雅黑\", Arial, sans-serif;\n" +
            "            font-size: 16px;\n" +
            "        }\n" +
            "\n" +
            "        .container {\n" +
            "            padding-bottom: 10px;\n" +
            "        }\n" +
            "\n" +
            "        .list {\n" +
            "            color: #33c298;\n" +
            "            padding: 0 10px;\n" +
            "            font-size: 14px;\n" +
            "        }\n" +
            "\n" +
            "        .dot {\n" +
            "            color: #d8d8d8;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "<div class=\"container\">\n" +
            "    <div style=\"height: 40px; line-height: 40px; border-bottom: 1px solid #eee; color: #333; padding: 0 10px;\">没有找到相关信息哦~</div>\n" +
            "    <div style=\"color: #333; margin: 10px 0 7px 0; padding: 0 10px;\">您可以尝试以下方法：</div>\n" +
            "    <div class=\"list\">\n" +
            "        <div><span class=\"dot\">●</span>&nbsp;尽量使用普通话</div>\n" +
            "        <div><span class=\"dot\">●</span>&nbsp;每次说出一个商品信息</div>\n" +
            "        <div><span class=\"dot\">●</span>&nbsp;点击下方键盘，使用文字输入</div>\n" +
            "    </div>\n" +
            "\n" +
            "    <img src=\"http://img.ishequ360.com/images/zg/supply/v2/sesame_120@2x.png\" alt=\"\" style=\"width: 30px; height: 30px;\">\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";


    public CustomWebView(Context context) {
        this(context, null);
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        String encoding = "UTF-8";
        String mimeType = "text/html";
        String pish = "<html><head><style type=\"text/css\">body {color:#818181; font-size: medium;text-align: justify;}</style></head><body>";
        String pas = "</body></html>";
        getSettings().setDefaultFontSize(13);
        getSettings().setBuiltInZoomControls(true);
//        loadDataWithBaseURL("about:blank", pish + "<div style=\"width: 100%; height: 100px; background-color: aqua\"></div>" + pas, mimeType, encoding, "about:blank");
        loadDataWithBaseURL("about:blank", HTML_DATA, mimeType, encoding, "about:blank");
        setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;   // true自身处理，false系统浏览器处理。
            }

        });
    }



}
