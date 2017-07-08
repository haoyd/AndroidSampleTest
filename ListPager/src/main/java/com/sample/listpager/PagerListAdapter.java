package com.sample.listpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by haoyundong on 2017/4/7.
 */

public class PagerListAdapter extends BaseAdapter {


    private AppCompatActivity context;

    public PagerListAdapter(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_pager, null);

        ViewPager viewPager = (ViewPager) convertView.findViewById(R.id.vp);

        viewPager.setId(position + getCount());

        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(context.getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(0);

        return convertView;
    }
}
