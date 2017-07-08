package com.sample.recyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    private StagAdapter stagAdapter;
    List<String> list = null;

    private OnClickListener onClickListener = null;
    private OnLongClickListener onLongClickListener = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadListener();
        initData();
    }

    private void initData() {
        list = new ArrayList<String>();
        for(int i ='A';i<='Z';i++){
            list.add(""+(char)i);
            Log.d(">>>",""+(char)i);
        }

        int index = getIntent().getExtras().getInt("index",-1);




        if(index != -1){

            if(index<5){
                recyclerView.setAdapter(recyclerAdapter);
            }else{
                if(index == 5){
                    stagAdapter = new StagAdapter(list,MainActivity.this,StaggeredGridLayoutManager.VERTICAL);
                }else{
                    stagAdapter = new StagAdapter(list,MainActivity.this,StaggeredGridLayoutManager.HORIZONTAL);
                }
                stagAdapter.setOnClickListener(onClickListener);
                recyclerView.setAdapter(stagAdapter);
            }


            switch (index){
                case 1:
                    setVerticalList();
                    break;
                case 2:
                    setHorizontalList();
                    break;
                case 3:
                    setVerticalGrid();
                    break;
                case 4:
                    setHorizontalGrid();
                    break;
                case 5:
                    setVerticalWaterFall();
                    break;
                case 6:
                    setHorizontalWaterFall();
                    break;
            }
        }


    }

    private void loadListener(){
        onClickListener = new OnClickListener() {
            @Override
            public void click(View view, int position) {
                String a = ((TextView)view).getText()+"";
                list.add(position,a);
                stagAdapter.notifyItemInserted(position);
            }
        };
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyler);

        recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
    }

    private void setVerticalList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,VERTICAL));
    }

    private void setHorizontalList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setVerticalGrid(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,4,VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setHorizontalGrid(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,4, HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setVerticalWaterFall(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

    private void setHorizontalWaterFall(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }


}
