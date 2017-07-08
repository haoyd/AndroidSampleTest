package com.sample.listpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 2017/4/7.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<Fragment>();
        for(int i = 0; i < 4; i++) {
            BlankFragment blankFragment = new BlankFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BlankFragment.STRING_KEY_FRAGMENT, i + "");

            blankFragment.setArguments(bundle);

            fragments.add(blankFragment);
        }
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
