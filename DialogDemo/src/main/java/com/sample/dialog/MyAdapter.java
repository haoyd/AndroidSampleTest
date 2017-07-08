package com.sample.dialog;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 16/9/11.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> list = new ArrayList<String>();

    public MyAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void resetData(List<String> list){
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
        ViewHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.textView = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.textView.setText(list.get(i));
        if(list.get(i).equals("5")){
            holder.textView.setBackgroundColor(Color.RED);
        }else {
            holder.textView.setBackgroundColor(Color.BLUE);
        }



        return view;
    }

    public class ViewHolder{
        public TextView textView;
    }

}
