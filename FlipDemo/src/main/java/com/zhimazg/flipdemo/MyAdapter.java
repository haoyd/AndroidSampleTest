package com.zhimazg.flipdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

        Drawable drawable = null;
        switch (i % 3) {
            case 0:
                drawable = context.getResources().getDrawable(R.mipmap.pic1);
                break;
            case 1:
                drawable = context.getResources().getDrawable(R.mipmap.pic2);
                break;
            case 2:
                drawable = context.getResources().getDrawable(R.mipmap.pic3);
                break;
        }
        holder.textView.setBackground(drawable);

        return view;
    }

    public class ViewHolder{
        public TextView textView;
    }

}
