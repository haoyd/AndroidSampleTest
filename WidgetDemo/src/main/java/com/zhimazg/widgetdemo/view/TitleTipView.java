package com.zhimazg.widgetdemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhimazg.widgetdemo.R;
import com.zhimazg.widgetdemo.model.utils.DisplayUtil;

/**
 * Created by haoyundong on 2017/2/8.
 */

public class TitleTipView extends RelativeLayout {

    private int itemHeiht = 50;

    private int itemCount = 0;

    private LinearLayout mContainer;
    private LinearLayout[] itemContainers;
    private TextView[] itemTexts;
    private View[] itemDividers;
    private View[] itemBottomLines;

    private AdapterView.OnItemClickListener itemClickListener;

    public TitleTipView(Context context) {
        this(context, null);
    }

    public TitleTipView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleTipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_title_tip, this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleTipView, defStyleAttr, 0);
        itemCount = typedArray.getInt(R.styleable.TitleTipView_item_count, 0);
        typedArray.recycle();

        init();
    }

    private void init() {
        mContainer = (LinearLayout) findViewById(R.id.ll_title_tip_container);

        itemContainers = new LinearLayout[itemCount];
        itemTexts = new TextView[itemCount];
        itemDividers = new View[itemCount];
        itemBottomLines = new View[itemCount];

        setTitle(itemCount);

    }

    public void setTitle(int itemCount) {
        if (itemCount > 0) {
            for(int i = 0; i < itemCount; i ++) {
                itemContainers[i] = new LinearLayout(getContext());
                itemTexts[i] = new TextView(getContext());
                itemDividers[i] = new View(getContext());
                itemBottomLines[i] = new View(getContext());

                if (i < itemCount - 1) {
                    if (i == 0) {
                        mContainer.addView(getItemView(i, true));
                    } else {
                        mContainer.addView(getItemView(i, false));
                    }
                    mContainer.addView(getItemDivider(i));
                } else {
                    if (i == 0) {
                        mContainer.addView(getItemView(i, true));
                    } else {
                        mContainer.addView(getItemView(i, false));
                    }
                }

                loadListener(itemContainers[i], i);
            }
        }
    }

    private View getItemDivider(int position) {
        itemDividers[position].setBackgroundColor(getResources().getColor(R.color.dipblue));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.width = DisplayUtil.dip2px(getContext(), 2);
        layoutParams.height = DisplayUtil.dip2px(getContext(), itemHeiht - 20);
        itemDividers[position].setLayoutParams(layoutParams);

        return itemDividers[position];
    }

    private View getItemView(int position, boolean isLineShow) {
        /**
         * ItemLayout
         */
        itemContainers[position].setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.height = DisplayUtil.dip2px(getContext(), itemHeiht);
        layoutParams.width = 0;
        layoutParams.weight = 1;
        itemContainers[position].setLayoutParams(layoutParams);

        /**
         * Item TextView
         */
        itemTexts[position].setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textParams.height = 0;
        textParams.weight = 1;
        itemTexts[position].setLayoutParams(textParams);
        itemTexts[position].setText("测试");

        itemContainers[position].addView(itemTexts[position]);

        /**
         * 添加item下划线
         */
        itemBottomLines[position].setBackgroundColor(getResources().getColor(R.color.seablue));
        LinearLayout.LayoutParams lineParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lineParam.height = DisplayUtil.dip2px(getContext(), 3);

        itemBottomLines[position].setLayoutParams(lineParam);

        if (isLineShow) {
            itemBottomLines[position].setVisibility(VISIBLE);
        } else {
            itemBottomLines[position].setVisibility(INVISIBLE);
        }

        itemContainers[position].addView(itemBottomLines[position]);

        return itemContainers[position];
    }

    private void loadListener(LinearLayout itemView, final int position) {
        itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSelect(position);
//                scrollLine(position);
                itemClickListener.onItemClick(null, itemContainers[position], position, 0);
            }
        });
    }

    private void chooseSelect(int position) {
        for(int i = 0; i < itemCount; i ++) {
            if (i == position) {
                itemBottomLines[i].setVisibility(VISIBLE);
            } else {
                itemBottomLines[i].setVisibility(INVISIBLE);
            }
        }
    }

    private void scrollLine(int position) {
        View line = itemBottomLines[0];

        int currentX = line.getLeft();
        int currentY = line.getBottom();
        int toX = itemBottomLines[position].getLeft();

        ValueAnimator animator = ValueAnimator.ofFloat(toX - currentX, currentY);
        animator.setTarget(line);
        animator.setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        animator.start();


        line.scrollTo(toX, currentY);

    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        itemClickListener = listener;
    }
}
