package com.sample.listpager;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public static final String STRING_KEY_FRAGMENT = "STRING_KEY_FRAGMENT";

    private String showMsg = "";
    private Activity mActivity;

    private TextView textView;

    public BlankFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mActivity = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        loadView(rootView);
        return rootView;
    }

    private void loadView(View v) {
        textView = (TextView) v.findViewById(R.id.tv_fragment);

        showMsg = getArguments().getString(STRING_KEY_FRAGMENT);

        if (!TextUtils.isEmpty(showMsg)) {
            textView.setText("当前页为：" + showMsg);
        } else {
            textView.setText("未获取到信息");
        }


    }

}
