package com.sample.dimdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventConflictActivity extends AppCompatActivity {

    private CustomScrollView scrollView;
    private MyListView listView1;
    private MyListView listView2;

    private List<String> datas;

    private int scrollViewCurrentY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_conflict);

        datas = getData();

        scrollView = (CustomScrollView) findViewById(R.id.scroll_event_conflict);
        scrollView.requestDisallowInterceptTouchEvent(false);


        listView1 = (MyListView) findViewById(R.id.lv_event_conflict1);
        listView2 = (MyListView) findViewById(R.id.lv_event_conflict2);
        listView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));
        listView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));

        listView1.setScrollView(scrollView);
        listView2.setScrollView(scrollView);

        scrollView.setScrollViewListener(new CustomScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                scrollViewCurrentY = y;

                if (y == 0) {
                    scrollView.isTop = true;
                    scrollView.isBottom = false;
                } else if (y == 270) {
                    scrollView.isBottom = true;
                    scrollView.isTop = false;
                } else {
                    scrollView.isTop = false;
                    scrollView.isBottom = false;
                }
                Log.d("aa", ">>>>  y=" + y + "  oldy=" + oldy);

//                if (y == 0 || y == 270) {
//                    listView1.eventByMe();
//                    listView2.eventByMe();
//                } else {
//                    listView1.eventByParent();
//                    listView2.eventByParent();
//                }
            }
        });

//        listView1.setOnScrollListener(onScrollListener);
//        listView2.setOnScrollListener(onScrollListener);

    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            data.add("item " + i);
        }
        return data;
    }

    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {

        private SparseArray recordSp = new SparseArray(0);
        private int mCurrentfirstVisibleItem = 0;

        private int oldY = 0;
        private int newY = 0;
        private int temp = 0;

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            switch (scrollState) {
                case SCROLL_STATE_TOUCH_SCROLL:
                    newY = getScrollY();

                    int scrollViewPostion = scrollViewCurrentY - oldY + newY;
                    if (scrollViewPostion < 0) {
                        scrollViewPostion = 0;
                    }

                    temp++;
                    scrollView.scrollTo(0, temp);
                    break;
                case SCROLL_STATE_IDLE:
                    oldY = getScrollY();
                    break;
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            mCurrentfirstVisibleItem = firstVisibleItem;
            View firstView = view.getChildAt(0);
            if (null != firstView) {
                ItemRecod itemRecord = (ItemRecod) recordSp.get(firstVisibleItem);
                if (null == itemRecord) {
                    itemRecord = new ItemRecod();
                }
                itemRecord.height = firstView.getHeight();
                itemRecord.top = firstView.getTop();
                recordSp.append(firstVisibleItem, itemRecord);
            }

            Log.d("aa", ">>>>  listView移动的距离为：" + getScrollY());
        }

        private int getScrollY() {
            int height = 0;
            for (int i = 0; i < mCurrentfirstVisibleItem; i++) {
                ItemRecod itemRecod = (ItemRecod) recordSp.get(i);
                height += itemRecod.height;
            }
            ItemRecod itemRecod = (ItemRecod) recordSp.get(mCurrentfirstVisibleItem);
            if (null == itemRecod) {
                itemRecod = new ItemRecod();
            }
            return height - itemRecod.top;
        }

        class ItemRecod {
            int height = 0;
            int top = 0;
        }
    };
}
