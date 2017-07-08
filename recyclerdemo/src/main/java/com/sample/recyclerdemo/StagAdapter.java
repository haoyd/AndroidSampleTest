package com.sample.recyclerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 16/8/4.
 */

public class StagAdapter extends RecyclerView.Adapter<StagAdapter.MyViewHolder> {

    private List<String> list = new ArrayList<String>();
    private List<Integer> heights = null;
    private List<Integer> widths = null;
    private Context context;
    private LayoutInflater inflater;
    private int orientation = StaggeredGridLayoutManager.VERTICAL;

    private OnClickListener onClickListener = null;
    private OnLongClickListener onLongClickListener = null;

    public StagAdapter(List<String> list, Context context, int orientation) {
        this.list = list;
        this.context = context;
        this.orientation = orientation;
        inflater = LayoutInflater.from(context);

        heights = new ArrayList<Integer>();
        widths = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            heights.add((int)(100+Math.random()*100));
            widths.add((int)(80+Math.random()*100));
        }

    }

    public void insert(String str,int position){
        list.add(position,str);
    }

    public void delete(int position){
        list.remove(position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.onClickListener = listener;
    }

    public void setOnLongClickListener(OnLongClickListener listener){
        this.onLongClickListener = listener;
    }

    @Override
    public StagAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.textView = (TextView) view.findViewById(R.id.tv_item);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ViewGroup.LayoutParams lp = holder.textView.getLayoutParams();
        if(orientation == StaggeredGridLayoutManager.VERTICAL){
            lp.height = heights.get(position);
        }else{
            lp.width = widths.get(position);
        }
        holder.textView.setLayoutParams(lp);

        holder.textView.setText(list.get(position));

        if(onClickListener != null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.click(holder.textView,holder.getPosition());
                }
            });
        }

        if(onLongClickListener != null){
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onLongClickListener.longClick(holder.textView,holder.getPosition());
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public TextView textView;
    }
}
