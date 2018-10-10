package com.sample.killgame.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;

import com.lwkandroid.rtpermission.RTPermission;
import com.lwkandroid.rtpermission.listener.OnPermissionResultListener;

/**
 * Created by haoyundong on 2017/6/26.
 */

class BasePermission {

    /**
     * 该权限是否已经授权允许
     * @param activity
     * @param permission
     * @return
     */
    protected static boolean isGranted(Activity activity, String permission) {
        PackageManager pm = activity.getPackageManager();
        return (PackageManager.PERMISSION_GRANTED == pm.checkPermission(permission, activity.getPackageName()));
    }

    /**
     * 该Android版本是否需要需要请求权限
     * @return
     */
    protected static boolean isVersionNeedAsk() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 请求单个权限
     * @param activity
     * @param permission
     */
    protected static void askPermission(Activity activity, String permission) {
        if (permission != null) {
            new RTPermission.Builder()
                    .permissions(permission)
                    .start(activity, new OnPermissionResultListener() {
                        @Override
                        public void onAllGranted(String[] allPermissions) {
                            //所有权限都已获得使用权后的回调

                        }

                        @Override
                        public void onDeined(String[] dinedPermissions) {
                            //有权限未获得使用权的回调

                        }
                    });
        }
    }

    /**
     * 请求单个权限
     * @param activity
     * @param permission
     */
    protected static void askPermission(Activity activity, String permission, OnPermissionResultListener listener) {
        if (permission != null) {
            new RTPermission.Builder()
                    .permissions(permission)
                    .start(activity, listener);
        }
    }



    /**
     * 请求多个权限
     * @param activity
     * @param permissions
     */
    protected static void askPermissions(Activity activity, String[] permissions) {
        if (permissions != null && permissions.length > 0) {
            new RTPermission.Builder()
                    .permissions(permissions)
                    .start(activity, new OnPermissionResultListener() {
                        @Override
                        public void onAllGranted(String[] allPermissions) {
                            //所有权限都已获得使用权后的回调

                        }

                        @Override
                        public void onDeined(String[] dinedPermissions) {
                            //有权限未获得使用权的回调

                        }
                    });
        }
    }

    /**
     * 请求多个权限
     * @param activity
     * @param permissions
     */
    protected static void askPermissions(Activity activity, String[] permissions, OnPermissionResultListener listener) {
        if (permissions != null && permissions.length > 0) {
            new RTPermission.Builder()
                    .permissions(permissions)
                    .start(activity, listener);
        }
    }

    public static void showPermissionAlert(Activity activity, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(activity)
                .setTitle("提示")
                .setMessage("权限未开启，需要获取您对应用的授权~")
                .setPositiveButton("下一步", listener)
                .setCancelable(false)
                .show();
    }

}
