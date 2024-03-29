package com.sample.slidingdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by haoyundong on 16/8/4.
 */

public class ShowFragment extends Fragment {
    WebView webview=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_show, container, false);
        webview=(WebView) view.findViewById(R.id.webview);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public WebView getWebView()
    {
        return webview;
    }
}
