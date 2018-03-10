package com.sample.dimdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by haoyundong on 2017/11/27.
 */

public class MyListView extends ListView {
    private static final String TAG = "MyListView";

    private boolean isAcceptEvent = false;
    private CustomScrollView scrollView;

    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollView(CustomScrollView scrollView) {
        this.scrollView = scrollView;
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int defaultsize=measureHight(Integer.MAX_VALUE >> 2, heightMeasureSpec);
        int expandSpec = MeasureSpec.makeMeasureSpec(defaultsize, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }


    private int measureHight(int size, int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            Log.i(TAG, "exactly" );

            result = specSize;
        } else {

            result = size;//最小值是200px ，自己设定
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
            Log.i(TAG, "specMode:"+specMode+"--result:"+result );
        }
        return result;
    }


    /**
     * 改listview滑到底端了
     *
     * @return
     */
    public boolean isBottom() {
        int firstVisibleItem = getFirstVisiblePosition();//屏幕上显示的第一条是list中的第几条
        int childcount = getChildCount();//屏幕上显示多少条item
        int totalItemCount = getCount();//一共有多少条
        if ((firstVisibleItem + childcount) >=totalItemCount) {
            return true;
        }
        return false;
    }

    /**
     * 改listview在顶端
     *
     * @return
     */
    public boolean isTop() {
        int firstVisibleItem = getFirstVisiblePosition();
        if (firstVisibleItem == 0) {
            return true;
        }
        return false;
    }

    /**
     * 交给ListView来响应事件
     */
    public void eventByMe() {
        if (!isAcceptEvent) {
            getParent().requestDisallowInterceptTouchEvent(true);
            isAcceptEvent = true;
        }
    }

    /**
     * 交给上一级View来响应事件
     */
    public void eventByParent() {
        if (isAcceptEvent) {
            getParent().requestDisallowInterceptTouchEvent(false);
            isAcceptEvent = false;
        }
    }

    float down = 0;
    float y;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down = event.getRawY();

                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                y = event.getRawY();
                if (isTop()) {
                    if (y - down > 1) {
                        // 到顶端,向下滑动 把事件教给父类
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        // 到顶端,向上滑动 把事件拦截 由自己处理
                        if (scrollView != null && !scrollView.isBottom) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }
}
