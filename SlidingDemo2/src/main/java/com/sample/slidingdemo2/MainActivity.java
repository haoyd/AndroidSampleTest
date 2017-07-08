package com.sample.slidingdemo2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;


public class MainActivity extends Activity {

    private BlankFragment fragment;

    private SlidingPaneLayout menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
    }

    private void loadView() {
        fragment = new BlankFragment();

        menu = (SlidingPaneLayout) findViewById(R.id.sliding);


    }


}
