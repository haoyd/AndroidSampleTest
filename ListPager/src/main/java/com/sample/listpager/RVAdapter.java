package com.sample.listpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by haoyundong on 2017/4/7.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private AppCompatActivity mActivity;
    private LayoutInflater inflater;

    public RVAdapter(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
        inflater = LayoutInflater.from(mActivity);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_pager, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.viewPager.setId(position + 5);

        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(mActivity.getSupportFragmentManager());
        holder.viewPager.setAdapter(fragmentPagerAdapter);
        holder.viewPager.setCurrentItem(holder.currentPage);

        holder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                holder.currentPage = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public int currentPage = 0;


        public ViewPager viewPager;


        public ViewHolder(View itemView) {
            super(itemView);

            viewPager = (ViewPager) itemView.findViewById(R.id.vp);
        }
    }
}
