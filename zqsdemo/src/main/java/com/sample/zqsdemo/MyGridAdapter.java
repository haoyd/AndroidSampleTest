package com.sample.zqsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 16/9/4.
 */

public class MyGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> list = new ArrayList<String>();

    public MyGridAdapter(Context context,List<String> list){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
    }




    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_grid,null);


        return view;
    }
}
