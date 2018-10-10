package com.sample.audiodemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sample.audiodemo.permission.PermissionManager;

import java.io.IOException;

/**
 MediaPlayer的常用方法：
 start();//开始播放
 pause();//暂停播放
 reset()//清空MediaPlayer中的数据
 setLooping(boolean);//设置是否循环播放
 seekTo(msec)//定位到音频数据的位置，单位毫秒
 stop();//停止播放
 relase();//释放资源


 */

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;

    private boolean isStartMediaPlayer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void MediaPlayer播放音频(View view) {

    }

    public void Raw文件播放音频(View view) {
        mediaPlayer1.start();
    }

    public void SD卡音频文件播放音频(View view) {
        mediaPlayer2.start();
    }

    public void 网络资源播放音频(View view) {
//        //1 初始化mediaplayer
//        final MediaPlayer mediaPlayer = new MediaPlayer();
//        //2 设置到播放的资源位置 path 可以是网络 路径 也可以是本地路径
//
//        try {
//            mediaPlayer.setDataSource("http://img.ishequ360.com/audio/quick_order_tip_20180801.mp3");
//            //3 准备播放
//            mediaPlayer.prepareAsync();
//            //3.1 设置一个准备完成的监听
//            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    // 4 开始播放
//                    mediaPlayer.start();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        mediaPlayer3.start();

    }

    public void Assets文件播放音频(View view) {
    }

    public void SoundPool播放音频(View view) {
    }

    public void AudioTrace播放音频(View view) {
    }

    private void init() {
        setupAppPermission();

        mediaPlayer1 = MediaPlayer.create(this, R.raw.order);
        mediaPlayer2 = new MediaPlayer();

        mediaPlayer3 = new MediaPlayer();
        mediaPlayer3.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri uri = Uri.parse("http://img.ishequ360.com/audio/quick_order_tip_20180801.mp3");
        try {
            mediaPlayer3.reset();
            mediaPlayer3.setDataSource(this, uri);
            mediaPlayer3.prepare();
            mediaPlayer3.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String path = Environment.getExternalStorageDirectory() + "/temp/FlashOrder.mp3";
            mediaPlayer2.setDataSource(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupAppPermission() {
        if (!PermissionManager.isNeedAskAudio(this)) {
            PermissionManager.askAudio(this);
        }

        if (!PermissionManager.isNeedAskStorage(this)) {
            PermissionManager.askStorage(this);
        }
    }
}
