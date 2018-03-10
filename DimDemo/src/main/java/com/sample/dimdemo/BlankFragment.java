package com.sample.dimdemo;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends HeaderViewPagerFragment {

    private View rootView;
    private ListView listView;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = container.getContext();

        rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        listView = rootView.findViewById(R.id.lv_fragment);

        listView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, getData()));

        return rootView;
    }

    public List<String> getData() {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            list.add("item  " + i);
        }

        return list;
    }

    @Override
    public View getScrollableView() {
        return listView;
    }
}
