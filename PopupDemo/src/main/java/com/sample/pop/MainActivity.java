package com.sample.pop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    MyPopupWindow popupWindow;
    MyPopupWindow2 popupWindow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
        loadListener();
    }

    private void loadView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

    }

    private void loadData() {

    }

    private void loadListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化popWindow
                popupWindow = new MyPopupWindow(MainActivity.this, itemsOnClick);
                //显示窗口
                popupWindow.showAtLocation(MainActivity.this.findViewById(R.id.activity_main),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);//设置layout在PopupWindow中显示的位置

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化popWindow
                popupWindow2 = new MyPopupWindow2(MainActivity.this, null);
                //显示窗口
                popupWindow2.showAsDropDown(view);
//                popupWindow2.showAtLocation(MainActivity.this.findViewById(R.id.btn2),
//                        Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);//设置layout在PopupWindow中显示的位置
            }
        });

    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.dismiss();
            switch (view.getId()) {
                case R.id.btn_take_photo:

                    break;
                case R.id.btn_pick_photo:

                    break;
            }
        }
    };
}
