package com.sample.pop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by haoyundong on 16/9/20.
 */

public class MyPopupWindow extends PopupWindow {
    private Button btn1;
    private Button btn2;
    private Button btn3;

    private View mMenuView;

    public MyPopupWindow(Activity context, OnClickListener itemOnClick){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.layout_pop,null);
        btn1 = (Button) mMenuView.findViewById(R.id.btn_take_photo);
        btn2 = (Button) mMenuView.findViewById(R.id.btn_pick_photo);
        btn3 = (Button) mMenuView.findViewById(R.id.btn_cancel);

        //设置3个按钮的监听
        btn1.setOnClickListener(itemOnClick);
        btn2.setOnClickListener(itemOnClick);
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        //设置PopupWindow的View
        this.setContentView(mMenuView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.inFromBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置PopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y=(int) motionEvent.getY();
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });


    }

}
