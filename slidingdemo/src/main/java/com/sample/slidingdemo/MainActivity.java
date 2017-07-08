package com.sample.slidingdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity implements BookMarkerFragment.BookmarkListener {

    Fragment bookmarkerFragment;
    Fragment showFragment;
    SlidingPaneLayout spl = null;
//    ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        actionBar = this.getActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        spl = (SlidingPaneLayout) this.findViewById(R.id.activity_main);
//        spl.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
//            @Override
//            public void onPanelClosed(View view) {
//                MainActivity.this.getFragmentManager()
//                        .findFragmentById(R.id.leftfragment)
//                        .setHasOptionsMenu(false);
//            }
//
//            @Override
//            public void onPanelOpened(View viw) {
//                MainActivity.this.getFragmentManager()
//                        .findFragmentById(R.id.leftfragment)
//                        .setHasOptionsMenu(true);
//            }
//
//            @Override
//            public void onPanelSlide(View arg0, float arg1) {
//
//            }
//        });
    }

    @Override
    public void onChangeBookmark(String bookmark) {
        ShowFragment sf = (ShowFragment) MainActivity.this.getFragmentManager()
                .findFragmentById(R.id.rightfragment);
        WebView webView = sf.getWebView();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.loadUrl(bookmark);

    }
}
