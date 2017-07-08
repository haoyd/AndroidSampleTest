package com.sample.ListExpand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by haoyundong on 16/9/28.
 */

public class MyAdapter extends BaseExpandableListAdapter {

    private Context context;
    private LayoutInflater inflater;

    private String[] groupTypes;
    private String[][] childTypes;

    public MyAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);

        groupTypes = new String[]{"神族兵种",
                "虫族兵种",
                "人族兵种"};

        childTypes = new String[][]{
                {"狂战士","龙骑士","黑暗圣堂","电兵"},
                {"小狗","刺蛇","飞龙","自爆飞机"},
                {"机枪兵","护士MM","幽灵"}};


        }


    @Override
    public int getGroupCount() {
        return groupTypes.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return childTypes[i].length;
    }

    @Override
    public String getGroup(int i) {
        return groupTypes[i];
    }

    @Override
    public String getChild(int i, int i1) {
        return childTypes[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        //是否指定分组视图及其子视图的ID对应的后台数据改变也会保持该ID
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item1, null);

        TextView textView = (TextView) view.findViewById(R.id.tv_item1);
        textView.setText(groupTypes[i]);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item2, null);

        TextView textView = (TextView) view.findViewById(R.id.tv_item2);
        textView.setText(getChild(i,i1).toString());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        //指定位置的子视图是否可选择
        return true;
    }


}
