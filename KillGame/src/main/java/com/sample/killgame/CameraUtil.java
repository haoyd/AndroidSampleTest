package com.sample.killgame;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.sample.killgame.permission.PermissionUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraUtil {

    private Activity activity;

    // 拍照
    private static final int PHOTO_REQUEST_TAKEPHOTO = 101;
    // 从相册中选择
    private static final int PHOTO_REQUEST_GALLERY = 102;
    // 结果
    private static final int PHOTO_REQUEST_CUT = 103;
    // 裁剪图片尺寸
    private int CROP_IMAGE_SIZE = 700;

    // 临时存放图片
    private File tempFile = new File(Environment.getExternalStorageDirectory(), "temp.jpg");

    // 存放图片的临时uri
    private Uri tempUri = null;

    private PhotoResponse mPhotoResponse = null;
    private UploadListener mUploadListener = null;

    private int askWhich = 0;

    public interface PhotoResponse {
        void success(Bitmap bitmap);
        void fail(String msg);
    }

    public interface UploadListener {
        void success();

        void error();
    }

    public CameraUtil(Activity activity) {
        this.activity = activity;
    }

    public void askCamera(PhotoResponse response) {
        if (PermissionUtil.isNeedAskCamera(activity)) {
            PermissionUtil.askCamera(activity);
            ToastBox.showBottom(activity, "该功能需要授权您的相机权限");
            return;
        }

        if (PermissionUtil.isNeedAskStorage(activity)) {
            PermissionUtil.askStorage(activity);
            ToastBox.showBottom(activity, "该功能需要授权您的存储权限");
            return;
        }

        mPhotoResponse = response;
        askWhich = 1;

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 指定调用相机拍照后照片的储存路径
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        try {
            activity.startActivityForResult(cameraIntent, PHOTO_REQUEST_TAKEPHOTO);
        } catch (ActivityNotFoundException e) {
            ToastBox.showBottom(activity, "操作异常");
            e.printStackTrace();
        }
    }

    public void askPhoto(PhotoResponse response) {
        if (PermissionUtil.isNeedAskCamera(activity)) {
            PermissionUtil.askCamera(activity);
            ToastBox.showBottom(activity, "该功能需要授权您的相机权限");
            return;
        }

        if (PermissionUtil.isNeedAskStorage(activity)) {
            PermissionUtil.askStorage(activity);
            ToastBox.showBottom(activity, "该功能需要授权您的存储权限");
            return;
        }

        mPhotoResponse = response;
        askWhich = 2;

        Intent pickIntent = new Intent(Intent.ACTION_PICK);
        pickIntent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        try {
            activity.startActivityForResult(pickIntent, PHOTO_REQUEST_GALLERY);
        } catch (ActivityNotFoundException e) {
            ToastBox.showBottom(activity, "操作异常");
            e.printStackTrace();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PHOTO_REQUEST_TAKEPHOTO:
                if (tempFile != null && tempFile.exists()) {
                    Uri uri = Uri.fromFile(tempFile);
                    tempUri = uri;
                    startPhotoZoom(tempUri);
                } else {
                    if (mPhotoResponse != null) {
                        mPhotoResponse.fail("照片获取失败~");
                    } else {
                        ToastBox.showBottom(activity, "照片获取失败~");
                    }
                }
                break;
            case PHOTO_REQUEST_GALLERY:
                if (data != null) {
                    Uri uri = data.getData();
                    if (uri != null && uri.toString().contains("com.miui.gallery.open")) {
                        uri = getImageContentUri(new File(getRealFilePath(uri)));
                    }
                    try {
                        saveFile(getCompressedBitmapFromUri(uri));
                        tempUri = Uri.fromFile(tempFile);
                        startPhotoZoom(tempUri);
                    } catch (IOException e) {
                        ToastBox.showBottom(activity, "保存失败");
                        e.printStackTrace();
                    }
                } else {
                    if (mPhotoResponse != null) {
                        mPhotoResponse.fail("照片获取失败~");
                    } else {
                        ToastBox.showBottom(activity, "照片获取失败~");
                    }
                }
                break;
            case PHOTO_REQUEST_CUT:
                Bitmap bitmap = null;
                if (askWhich == 1) {
                    bitmap = getCompressedBitmapFromUri(tempUri);
                } else {
                    bitmap = getBitmapFromUri(tempUri);
                }
                if (mPhotoResponse != null) {
                    if (bitmap != null) {
                        if (data != null) {
                            mPhotoResponse.success(bitmap);
                        } else {
                            mPhotoResponse.fail("未获取到照片~");
                        }
                    } else {
                        mPhotoResponse.fail("照片获取失败~");
                    }
                } else {
                    ToastBox.showBottom(activity, "照片获取失败~");
                }
                //删除已拍的商品照片
                if (tempFile.exists()) {
                    tempFile.delete();
                }
                break;
        }
    }

    /**
     * 缩放裁剪图片
     *
     * @param uri 图片Uri地址
     */
    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", CROP_IMAGE_SIZE);
        intent.putExtra("outputY", CROP_IMAGE_SIZE);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra("noFaceDetection", true);
        try {
            activity.startActivityForResult(intent, PHOTO_REQUEST_CUT);
        } catch (Exception e) {
            //img.setImageURI(uri);
        }
    }

    /**
     * 通过uri获取bitmap
     *
     * @return
     */
    private Bitmap getBitmapFromUri(Uri uri) {
        Bitmap bitmap = null;

        try {
            // 读取uri所在的图片
            bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri);
//            bitmap = CameBitmapUtil.getBitmapFormUri(activity, uri);


            if (bitmap != null) {
                float a = bitmap.getByteCount();
            }
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取压缩后的图片
     * @param uri
     * @return
     */
    private Bitmap getCompressedBitmapFromUri(Uri uri) {
        Bitmap bitmap = null;
        File file = null;

        try {
            file = CameBitmapUtil.getFileFromMediaUri(activity, uri);
            bitmap = CameBitmapUtil.getBitmapFormUri(activity, uri, 200);

            int degree = CameBitmapUtil.getBitmapDegree(file.getAbsolutePath());
            Bitmap newBitmap = CameBitmapUtil.rotateBitmapByDegree(bitmap, degree);
            return newBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    /**
     * 保存文件
     * @param bm
     * @throws IOException
     */
    public void saveFile(Bitmap bm) throws IOException {
        if (bm == null) {
            return;
        }

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tempFile));
            bm.compress(Bitmap.CompressFormat.JPEG, 90, bos);
            bos.flush();
            bos.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将URI转为图片的路径
     *
     * @param uri
     * @return
     */
    private String getRealFilePath(final Uri uri) {
        if (null == uri)
            return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = activity.getContentResolver().query(uri,
                    new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    private Uri getImageContentUri(File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = activity.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return activity.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }
}