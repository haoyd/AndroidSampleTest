package com.zhimazg.shareddemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView show;
    private Button put;
    private Button pop;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferences = getSharedPreferences("abcd", MODE_PRIVATE);
        editor = preferences.edit();


        input = (EditText) findViewById(R.id.input);
        show = (TextView) findViewById(R.id.show);
        put = (Button) findViewById(R.id.put);
        pop = (Button) findViewById(R.id.get);

        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("tag", input.getText() + "").apply();
            }
        });


        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setText(show.getText() + preferences.getString("tag", ""));
            }
        });

    }
}
