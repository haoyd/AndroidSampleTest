package com.zhimazg.spinner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        spinner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_spinner, list);

        adapter.setDropDownViewResource(R.layout.item_spinner2);

        spinner.setAdapter(adapter);
//
//        WindowManager wm = this.getWindowManager();
//
//        spinner.setDropDownWidth(wm.getDefaultDisplay().getWidth() - 10);
//        spinner.setDropDownVerticalOffset(120);
    }

    public class MyAdapter extends BaseAdapter {
        private List<String> mList;
        private Context mContext;

        public MyAdapter() {
            mList = new ArrayList<String>();
            mList.add("未开始");
            mList.add("已开始");
            mList.add("未完成");
            mList.add("已完成");
            mList.add("已结束");
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public String getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * 下面是重要代码
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater _LayoutInflater = LayoutInflater.from(MainActivity.this);
            convertView = _LayoutInflater.inflate(R.layout.item_spinner3, null);
            if (convertView != null) {
                TextView textView = (TextView) convertView.findViewById(R.id.tv_aa);
                textView.setText(getItem(position));
                TextView point = (TextView) convertView.findViewById(R.id.tv_point);
            }
            return convertView;
        }
    }


}
