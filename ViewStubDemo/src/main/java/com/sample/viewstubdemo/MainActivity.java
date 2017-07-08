package com.sample.viewstubdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ViewStub viewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        loadView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                stubShow();
                break;
            case R.id.action_settings2:
                Button btn1 = (Button) findViewById(R.id.btn1);
                btn1.setText("哈哈");
                break;
            case R.id.action_settings3:
                Button btn2 = (Button) findViewById(R.id.btn2);
                btn2.setText("呵呵");
                break;
            case R.id.action_settings4:
                Log.i("MainActivity", "点击了第三个控件");
                break;
            case R.id.action_settings5:
                Log.i("MainActivity", "点击了第四个控件");
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void loadView(){
        viewStub = (ViewStub) findViewById(R.id.stub_view1);
    }


    private void stubShow(){
        viewStub.inflate();
    }


}
