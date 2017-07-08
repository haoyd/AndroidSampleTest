package com.sample.draglist;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sample.draglist.libs.dslv.DragSortController;
import com.sample.draglist.libs.dslv.DragSortListView;
import com.sample.draglist.views.MySwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private DragSortListView listView;
    private List<String> list;
    private MyAdapter adapter;
    private DragSortController dragSortController;

    private MySwipeRefreshLayout refreshLayout;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refreshLayout.setRefreshing(true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        loadListener();
    }

    private void loadView() {
        refreshLayout = (MySwipeRefreshLayout) findViewById(R.id.refresh_view);

        refreshLayout.setEnabled(true);
        refreshLayout.setColorSchemeColors(0xff008cee);
        refreshLayout.setSize(SwipeRefreshLayout.LARGE);


        listView = (DragSortListView) findViewById(R.id.listview);
        dragSortController = buildController(listView);
        listView.setFloatViewManager(dragSortController);
        listView.setOnTouchListener(dragSortController);
        listView.setDragEnabled(false);


        list = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            list.add(""+i);
        }

        adapter = new MyAdapter(MainActivity.this,list);

        listView.setAdapter(adapter);

    }

    private void loadListener(){
        listView.setDropListener(new DragSortListView.DropListener() {
            @Override
            public void drop(int from, int to) {
                if (from != to) {
                    list.add(to, list.remove(from));

                }
                adapter.notifyDataSetChanged();
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(-1,1000);
            }
        });
    }

    public DragSortController buildController(DragSortListView dslv) {
        DragSortController controller = new DragSortController(dslv);
        controller.setDragHandleId(R.id.tv_item);
        controller.setRemoveEnabled(false);
        controller.setSortEnabled(true);
        controller.setDragInitMode(DragSortController.ON_DOWN);
        return controller;
    }
}
