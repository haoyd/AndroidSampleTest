package com.zhimazg.timertask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;

    private Timer timer;
    private boolean goState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
        loadListener();
    }

    private void loadView() {
        progressBar = (ProgressBar) findViewById(R.id.pro_show);
        button = (Button) findViewById(R.id.btn_start);
    }

    private void loadData() {

    }

    private void loadListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = null;
                timer = new Timer();

                timer.schedule(new MyTimerTask(), 0, 14);
            }
        });
    }

    class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            if (goState) {
                int progress = progressBar.getProgress();
                progress --;
                progressBar.setProgress(progress);

                if(progress == 0){
                    goState = false;
                }

            } else {
                int progress = progressBar.getProgress();
                progress ++;
                progressBar.setProgress(progress);

                if(progress == 90){
                    goState = true;
                    timer.cancel();
                }
            }
        }
    }

}
