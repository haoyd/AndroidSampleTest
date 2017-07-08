package com.zhimazg.widgetdemo.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhimazg.widgetdemo.R;

import java.util.List;

/**
 * Created by haoyundong on 2016/11/17.
 */

public class StatePop extends PopupWindow {

    private View mView;

    private ListView listView;
    private TextView darkPart;

    private Context mContext;

    public StatePop(Context context) {
        super(context);

        mContext = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.layout_pop_state,null);

        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.inFromTop);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
//        设置PopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

        listView = (ListView) mView.findViewById(R.id.lv_pop_state);
        darkPart = (TextView) mView.findViewById(R.id.tv_pop_state_dark);

        setListener();


        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int height = mView.findViewById(R.id.ll_pop_state).getTop();
                int y=(int) motionEvent.getY();
                if(motionEvent.getAction()== MotionEvent.ACTION_UP){
                    if(y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    private void setListener() {
        darkPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


    public void setAdapter(List<String> list, AdapterView.OnItemClickListener listener) {
        listView.setAdapter(new ArrayAdapter<String>(mContext, R.layout.item_pop_state, list));
        listView.setOnItemClickListener(listener);
    }
}
