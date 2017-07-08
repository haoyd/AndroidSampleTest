package com.sample.seekbarpressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SeekBarPressure seek;

    private List<String> data = Arrays.asList(new String[]{"0", "10", "20", "30",
            "40", "50", "60",
            "70", "80", "90", "100"});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek = (SeekBarPressure) findViewById(R.id.seek);

        seek.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBarPressure seekBar,
                                          double progressLow, double progressHigh, int mprogressLow,
                                          int mprogressHigh, double max, double min) {

            }
        });
        seek.setData(data);
        seek.setProgressLowInt(0);
        seek.setProgressHighInt(data.size() - 1);

//        ViewGroup.LayoutParams.MATCH_PARENT


    }
}
