package com.zhimazg.UnitTesst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int tag = 0;

    private EditText et1;
    private EditText et2;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void btnTest2(View view) {
        switch (tag) {
            case 0:
                toast("0");
                break;
            case 1:
                toast("1");
                break;
            case 2:
                toast("2");
                break;
            case 3:
                toast("3");
                break;
            default:
                toast("other");
        }
    }

    public void btnTest(View view) {
        try {
            int num1 = Integer.parseInt(et1.getText() + "");
            int num2 = Integer.parseInt(et2.getText() + "");
            int total = num1 + num2;
            tv.setText(total + "");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }

    public void setTag(int i) {
        tag = i;
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
