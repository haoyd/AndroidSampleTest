package com.sample.TypeList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 16/9/28.
 */

public class TypeAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Integer> datas = new ArrayList<Integer>();

    public TypeAdapter(Context context, List<Integer> datas ){
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Integer getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;

        int type = getItemViewType(i);

        if(view == null){
            switch (type){
                case 0:
                    holder1 = new ViewHolder1();
                    view = inflater.inflate(R.layout.item1,null);
                    holder1.textView = (TextView) view.findViewById(R.id.tv_item1);
                    view.setTag(holder1);
                    break;
                case 1:
                    holder2 = new ViewHolder2();
                    view = inflater.inflate(R.layout.item2,null);
                    holder2.textView = (TextView) view.findViewById(R.id.tv_item2);
                    view.setTag(holder2);
                    break;
                case 2:
                    holder3 = new ViewHolder3();
                    view = inflater.inflate(R.layout.item3,null);
                    holder3.textView = (TextView) view.findViewById(R.id.tv_item3);
                    view.setTag(holder3);
                    break;

            }
        }else {
            switch (type){
                case 0:
                    holder1 = (ViewHolder1) view.getTag();
                    break;
                case 1:
                    holder2 = (ViewHolder2) view.getTag();
                    break;
                case 2:
                    holder3 = (ViewHolder3) view.getTag();
                    break;

            }
        }

        switch (type){
            case 0:
                holder1.textView.setText(datas.get(i) + "");
                break;
            case 1:
                holder2.textView.setText(datas.get(i) + "");
                break;
            case 2:
                holder3.textView.setText(datas.get(i) + "");

                break;
        }





        return view;
    }

    class ViewHolder1{
        TextView textView;
    }

    class ViewHolder2{
        TextView textView;
    }

    class ViewHolder3{
        TextView textView;
    }



}
