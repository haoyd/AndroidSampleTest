package com.zhimazg.UnitTesst;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by haoyundong on 2016/11/1.
 */

@RunWith(AndroidJUnit4.class)
public class TestActivity extends ActivityInstrumentationTestCase2<MainActivity> {
    private Activity mActivity;

    private TextView textView;
    private EditText et1;
    private EditText et2;
    private Button button;

    public TestActivity() {
        super(MainActivity.class);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    @Test
    public void testMainActivity() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        et1 = (EditText) mActivity.findViewById(R.id.et1);
        et2 = (EditText) mActivity.findViewById(R.id.et2);
        textView = (TextView) mActivity.findViewById(R.id.tv);
        button = (Button) mActivity.findViewById(R.id.show);

//        et1.setText("123");
//        et2.setText("123");

//        Toast.makeText(mActivity, "111", Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString());
                textView.setText(result + "");
                Toast.makeText(mActivity, result + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
