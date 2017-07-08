package com.zhimazg.widgetdemo.model.libs.niceSpinner;

import android.content.Context;
import android.widget.ListAdapter;

/**
 * @author angelo.marchesin
 */

public class NiceSpinnerAdapterWrapper extends NiceSpinnerBaseAdapter {

    private final ListAdapter mBaseAdapter;

    public NiceSpinnerAdapterWrapper(Context context, ListAdapter toWrap, int textColor, int backgroundSelector) {
        super(context, textColor, backgroundSelector);
        mBaseAdapter = toWrap;
    }

    @Override
    public int getCount() {
        return mBaseAdapter.getCount() ;
    }

    @Override
    public Object getItem(int position) {
        if (position >= mSelectedIndex) {
            return mBaseAdapter.getItem(position );
        } else {
            return mBaseAdapter.getItem(position);
        }
    }

    @Override
    public Object getItemInDataset(int position) {
        return mBaseAdapter.getItem(position);
    }
}