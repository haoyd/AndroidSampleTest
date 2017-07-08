package com.sample.SmoothList.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.sample.SmoothList.R;
import com.sample.SmoothList.model.bean.ProductInfo;
import com.zhimadj.utils.ImageCache;

/**
 * Created by haoyundong on 16/9/26.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ProductInfo productInfo;

    private boolean isVisible = true;

    public MyAdapter(Context context, ProductInfo productInfo, AbsListView listView){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.productInfo = productInfo;


        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // TODO Auto-generated method stub
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING)
                    //惯性滑动时调用
                    isVisible = false;

                else if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    //滑动停止时调用
                    isVisible = true;
                    notifyDataSetChanged();

                } else if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    //用手滑动时调用
                    isVisible = false;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // TODO Auto-generated method stub
                isVisible = false;

            }
        });


    }

    @Override
    public int getCount() {
        return 300;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.item_list,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.iv_item);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        String url = "http://img.ishequ360.com/160807/5c03b1085d9985a0ab895627a65af549.jpg?imageView2/0/w/120/h/120";
//        ImageCache.loadImage(url, holder.imageView,R.mipmap.ic_launcher);

        if(isVisible){
            ImageCache.loadImage(url, holder.imageView,R.mipmap.ic_launcher);
//            if(i >= first && i < (first + visibleItemCounts)){
//            }
        }

        return view;
    }

    class ViewHolder{
        public ImageView imageView;
    }
}
