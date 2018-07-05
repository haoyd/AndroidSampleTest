package com.zhimazg.testdemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.zhimazg.testdemo.view.CustomVideoView;

public class GifActivity extends Activity {

    private CustomVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        videoView = findViewById(R.id.vv_gif);


        int index = getIntent().getIntExtra("index", 1);
        Uri uri = null;
        switch (index) {
            case 1:
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.guide_1);
                break;
            case 2:
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.guide_2);
                break;
            case 3:
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.guide_3);
                break;
        }


        if (uri != null) {
            videoView.playVideo(uri);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }
}
