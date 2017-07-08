package com.zhimazg.widgetdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhimazg.widgetdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyundong on 2017/2/15.
 */

public class MySpinner extends RelativeLayout {

    private LinearLayout container;
    private View arrow;
    private TextView name;
    private View bottomLine;

    private StatePop popWindow;

    private static final boolean useFalseData = true;

    private int currentposition = 0;

    private boolean isPopShow = false;

    private List<String> datas;

    private AdapterView.OnItemClickListener onItemClickListener;


    public MySpinner(Context context) {
        this(context, null);
    }

    public MySpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_spinner, this);
        init(context);
    }

    private void init(Context context) {
        datas = new ArrayList<String>();
        datas.add("one");
        datas.add("two");
        datas.add("three");

        container = (LinearLayout) findViewById(R.id.ll_spinner_container);
        arrow = findViewById(R.id.view_spinner_arrow);
        name = (TextView) findViewById(R.id.tv_spinner_state);
        bottomLine = findViewById(R.id.line_spinner);

        popWindow = new StatePop(getContext());

        loadListener();
        setList(null);

    }

    private void loadListener() {
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setShowState(false);
            }
        });


        onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setState(position);
                setShowState(false);
            }
        };

        container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPopShow) {
                    setShowState(false);
                } else {
                    setShowState(true);
                }
            }
        });

    }

    public void setList(List<String> datas) {
        if (!useFalseData) {
            this.datas = datas;
        }
        popWindow.setAdapter(this.datas, onItemClickListener);
    }

    protected void setState(int position) {
        currentposition = position;
        name.setText(datas.get(position));
        arrow.setBackground(getResources().getDrawable(R.mipmap.ic_task_pulldown));

    }

    private void setShowState(boolean show) {
        if (show) {
            popWindow.showAsDropDown(container);
            arrow.setBackground(getResources().getDrawable(R.mipmap.ic_task_pickup));
        } else {
            popWindow.dismiss();
            arrow.setBackground(getResources().getDrawable(R.mipmap.ic_task_pulldown));
        }
        isPopShow = show;
    }
}
