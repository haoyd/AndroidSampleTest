package com.zhimazg.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView count;
    private TextView show;
    private Button start;
    private Button stop;

    private MyAsyncTask asyncTask;

    protected boolean isGoing = true;
    protected int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
        loadListener();
    }

    private void loadView() {
        count = (TextView) findViewById(R.id.tv_count);
        show = (TextView) findViewById(R.id.tv_show);
        start = (Button) findViewById(R.id.btn_start);
        stop = (Button) findViewById(R.id.btn_stop);

    }

    private void loadData() {

    }

    private void loadListener(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGoing = true;
                asyncTask = null;
                asyncTask = new MyAsyncTask();
                asyncTask.execute(1);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGoing = false;
            }
        });
    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {
        private int direction = 1;
        @Override
        protected Integer doInBackground(Integer... integers) {
            while (isGoing) {
                if(direction == 1){
                    for(int i = 10; i > -1; i --){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        publishProgress(i);
                    }
                    direction = 2;
                }else {
                    for(int i = 0; i < 11; i ++){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        publishProgress(i);
                    }
                    direction = 1;
                }
            }
            return 1;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            show.setText("记时(" + values[0] + ")");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            count.setText("跑了" + (num + integer) + "趟");
            num ++;
            super.onPostExecute(integer);
        }
    }
}
