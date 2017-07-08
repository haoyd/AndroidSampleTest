package com.ryantang.picture;

import java.io.File;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	private static final int TAKE_PICTURE = 0;
	private static final int CHOOSE_PICTURE = 1;
	
	private static final int SCALE = 5;		// 照片缩小比例
	private CircleImageView iv_image = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv_image = (CircleImageView) this.findViewById(R.id.img);
		
		this.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showPicturePicker(MainActivity.this);
			}
		});
		
		this.findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
				case TAKE_PICTURE:
					// 将保存在本地的图片取出并缩小后显示在界面上
					Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/image.jpg");
					Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
					bitmap.recycle();
					iv_image.setImageBitmap(newBitmap);
					ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));
					break;
				case CHOOSE_PICTURE:
					ContentResolver resolver = getContentResolver();
					// 照片的原始资源地址
					Uri originalUri = data.getData(); 
		            try {
		            	// 使用ContentProvider通过URI获取原始图片
						Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
						if (photo != null) {
							Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
							photo.recycle();
							iv_image.setImageBitmap(smallBitmap);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}  
					break;
				default:
					break;
			}
		}
	}
	
	public void showPicturePicker(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("图片来源");
		builder.setNegativeButton("取消", null);
		builder.setItems(new String[]{"拍照","相册"}, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
					case TAKE_PICTURE:
						Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
						Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "image.jpg"));
						//指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
						openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
						startActivityForResult(openCameraIntent, TAKE_PICTURE);
						break;
					case CHOOSE_PICTURE:
						Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
						openAlbumIntent.setType("image/*");
						startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
						break;
					default:
						break;
				}
			}
		});
		builder.create().show();
	}
	
}
