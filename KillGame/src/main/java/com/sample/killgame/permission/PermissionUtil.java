package com.sample.killgame.permission;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.lwkandroid.rtpermission.listener.OnPermissionResultListener;

/**
 * Created by haoyundong on 2017/5/27.
 */

public class PermissionUtil extends BasePermission{

    private static final String[] launchPermissions = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    /**
     * 请求位置权限
     * @param activity
     */
    public static void askLocation(final Activity activity) {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                boolean permission1 = isGranted(activity, Manifest.permission.ACCESS_FINE_LOCATION);
                boolean permission2 = isGranted(activity, Manifest.permission.ACCESS_COARSE_LOCATION);

                if (!permission1 || !permission2) {
                    new AlertDialog.Builder(activity)
                            .setTitle("定位服务已关闭")
                            .setMessage("请开启【芝麻司机】定位,以便正常使用！")
                            .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Uri packageURI = Uri.parse("package:" + "com.zhimazg.driver");
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                    activity.startActivity(intent);
                                }
                            }).show();
                }
            } else {
                askPermissions(activity, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 请求相机权限
     * @param activity
     */
    public static void askCamera(final Activity activity){
        try {
            if (!isGranted(activity, Manifest.permission.CAMERA)) {
                if (Build.VERSION.SDK_INT < 23) {
                    showDefaultDialog(activity);
                } else {
                    askPermissions(activity, new String[]{Manifest.permission.CAMERA});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /**
     * 请求播打电话权限
     * @param activity
     */
    public static void askDial(final Activity activity){
        if (!isGranted(activity, Manifest.permission.CALL_PHONE)) {
            if (Build.VERSION.SDK_INT < 23) {
                showDefaultDialog(activity);
            } else {
                askPermissions(activity, new String[]{Manifest.permission.CALL_PHONE});
            }
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /**
     * 请求读写存储权限
     * @param activity
     */
    public static void askStorage(final Activity activity){
        try {
            if (!isGranted(activity, Manifest.permission.READ_EXTERNAL_STORAGE) || !isGranted(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (Build.VERSION.SDK_INT < 23) {
                    showDefaultDialog(activity);
                } else {
                    askPermissions(activity, new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求指定权限
     * @param activity
     * @param permissions
     */
    public static void askThePermissions(Activity activity, String[] permissions) {
        askPermissions(activity, permissions);
    }

    /**
     * 请求麦克风权限
     * @param activity
     * @param listener
     */
    public static void askAudio(Activity activity, OnPermissionResultListener listener) {
        askPermission(activity, Manifest.permission.RECORD_AUDIO, listener);
    }

    /**
     * 应用的必要权限是否有必要申请
     *
     * @param activity
     * @return
     */
    public static boolean isNeedAskLaunchPermissions(Activity activity) {
        boolean result = false;

        if (isVersionNeedAsk()) {
            for (String permission : launchPermissions) {
                if (!isGranted(activity, permission)) {
                    result = true;
                }
            }
        }
        return result;
    }


    /**
     * 请求应用必要权限
     *
     * @param activity
     */
    public static void askLaunchPermissions(Activity activity, OnPermissionResultListener listener) {
        askPermissions(activity, launchPermissions, listener);
    }

    /**
     * 是否需要获取位置权限
     *
     * @param activity
     * @return
     */
    public static boolean isNeedAskLocation(Activity activity) {
        return isVersionNeedAsk() && !isGranted(activity, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    /**
     * 是否需要获取设备信息权限
     * @param activity
     * @return
     */
    public static boolean isNeedAskDeviceInfo(Activity activity) {
        return isVersionNeedAsk() && !isGranted(activity, Manifest.permission.READ_PHONE_STATE);
    }

    /**
     * 是否需要获取相机权限
     *
     * @param activity
     * @return
     */
    public static boolean isNeedAskCamera(Activity activity) {
        return isVersionNeedAsk() && !isGranted(activity, Manifest.permission.CAMERA);
    }

    /**
     * 是否需要获取读写存储权限
     *
     * @param activity
     * @return
     */
    public static boolean isNeedAskStorage(Activity activity) {
        return isVersionNeedAsk() && !isGranted(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    /**
     * 是否需要获取语音权限
     * @param activity
     * @return
     */
    public static boolean isNeedAskAudio(Activity activity) {
        return isVersionNeedAsk() && !isGranted(activity, Manifest.permission.RECORD_AUDIO);
    }


    //****************************************************************************************************************************************************************
    //****************************************************************************************************************************************************************
    //****************************************************************************************************************************************************************
    //****************************************************************************************************************************************************************


    /**
     * 显示默认提示
     * @param activity
     */
    private static void showDefaultDialog(final Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("提示")
                .setMessage("您的权限未开启，请前往设置！")
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri packageURI = Uri.parse("package:" + "com.zhimazg.driver");
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        activity.startActivity(intent);
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    /**
     * 显示
     * @param activity
     * @param listener
     */
    public static void showLaunchPermissionAlert(Activity activity, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(activity)
                .setTitle("提示")
                .setMessage("为了更好的使用芝麻司机功能，需要获取您的部分权限~")
                .setPositiveButton("下一步", listener)
                .setCancelable(false)
                .show();
    }


}
