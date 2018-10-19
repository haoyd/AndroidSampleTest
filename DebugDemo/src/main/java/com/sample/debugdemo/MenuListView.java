package com.sample.debugdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuListView extends ListView {

    private Context mContext;
    private ArrayAdapter<String> adapter;

    public MenuListView(Context context) {
        this(context, null);
    }

    public MenuListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void bindData(String[] dataArray) {
        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, dataArray);
        setAdapter(adapter);
    }

}
