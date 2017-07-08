package com.sample.zqsdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	private Context context;
	boolean isCheck;
	Boolean boo[] = { true, true, true, true };

	private Integer ids[] = { R.mipmap.ic_launcher, R.mipmap.ic_launcher,
			R.mipmap.ic_launcher, R.mipmap.ic_launcher };

	public ImageAdapter(Context context) {
		this.context = context;
		isCheck = true;

	}

	@Override
	public int getCount() {
		return ids.length;
	}

	@Override
	public Object getItem(int position) {
		return ids[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));// ����ͼƬ��С
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);// ����ͼƬ����ģʽ
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(ids[position]);
		return imageView;
	}

	
	public void changeState(int position) {

		if (isCheck == false) {
			if (position < boo.length) {
				boo[position] = !boo[position];
				isCheck = !isCheck;
			}
		} else {
			if (position < boo.length) {
				boo[position] = !boo[position];
				isCheck = !isCheck;
			}
		}
		notifyDataSetChanged();
	}
}
