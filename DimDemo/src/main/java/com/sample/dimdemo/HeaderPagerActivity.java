package com.sample.dimdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HeaderPagerActivity extends AppCompatActivity {

    private ListView listView;
    private ViewPager viewPager;

    public List<HeaderViewPagerFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_pager);

        fragments.add(new BlankFragment());

        viewPager = (ViewPager) findViewById(R.id.pager);

//        listView = (ListView) findViewById(R.id.lv_header_pager);

//        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData()));
    }

    public List<String> getData() {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            list.add("item  " + i);
        }

        return list;
    }

    /**
     * 内容页的适配器
     */
    private class ContentAdapter extends FragmentPagerAdapter {

        public ContentAdapter(FragmentManager fm) {
            super(fm);
        }

        public String[] titles = new String[]{"ListView"};

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
