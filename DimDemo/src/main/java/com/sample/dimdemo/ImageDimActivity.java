package com.sample.dimdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import net.qiujuer.genius.blur.StackBlur;

public class ImageDimActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private SeekBar seekBar;

    private Bitmap resourceBitmap;
    private Bitmap dimedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_dim);
        initData();
        initView();
        bindListener();
    }

    private void initData() {
        resourceBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.aa);
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
    }

    private void bindListener() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("模糊值为：" + progress);

                if (progress == 0) {
                    imageView.setImageBitmap(resourceBitmap);
                } else {
                    dimedBitmap = StackBlur.blurNatively(resourceBitmap, progress, false);
                    imageView.setImageBitmap(dimedBitmap);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
