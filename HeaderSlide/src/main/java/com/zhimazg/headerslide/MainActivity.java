package com.zhimazg.headerslide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip header;
    private ViewPager viewPager;

    private TestPagerAdapter adapter;

    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadData();
        loadListener();
    }

    private void loadView() {
        header = (PagerSlidingTabStrip) findViewById(R.id.header);
        viewPager = (ViewPager) findViewById(R.id.pager);

        for(int i = 0; i < 10; i++) {
            fragments.add(new TestFragment());
        }

        adapter = new TestPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        header.setViewPager(viewPager);

        header.setTextSize(30);
        //标签下划线的颜色
        header.setIndicatorHeight(5);
        //均匀平分整个屏幕
        header.setShouldExpand(true);

        //将ViewPager与PagerSlidingTabStrip匹配连接
        header.setBackgroundColor(getResources().getColor(R.color.white));
//        header.setTextColor(getResources().getColor(R.color.black));
        header.setIndicatorColor(getResources().getColor(R.color.green));


    }

    private void loadData() {

    }

    private void loadListener() {

        header.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
                ((TestFragment)fragments.get(position)).changeTitle(position + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
