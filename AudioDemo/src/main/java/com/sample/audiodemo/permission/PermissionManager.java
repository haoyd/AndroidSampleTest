package com.sample.audiodemo.permission;

import android.Manifest;
import android.app.Activity;

import com.lwkandroid.rtpermission.listener.OnPermissionResultListener;

/**
 * Created by haoyundong on 2017/6/26.
 *
 * 用于对该应用进行一些有关动态权限获取的操作
 */

public class PermissionManager extends BasePermission {

    private static final String[] launchPermissions = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };


    //------------------------------------------------------------------------------------------------------------------
    //
    //判断是否需要获取某项权限
    //
    //------------------------------------------------------------------------------------------------------------------

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

    public static boolean isNeedAskAudio(Activity activity) {
        return isVersionNeedAsk() && !isGranted(activity, Manifest.permission.RECORD_AUDIO);
    }


    //------------------------------------------------------------------------------------------------------------------
    //
    //对具体权限进行申请
    //
    //------------------------------------------------------------------------------------------------------------------




    /**
     * 请求应用必要权限
     *
     * @param activity
     */
    public static void askLaunchPermissions(Activity activity, OnPermissionResultListener listener) {
        askPermissions(activity, launchPermissions, listener);
    }

    /**
     * 请求应用必要权限
     *
     * @param activity
     */
    public static void askLaunchPermissions(Activity activity) {
        askPermissions(activity, launchPermissions);
    }



    /**
     * 请求位置权限
     *
     * @param activity
     */
    public static void askLocation(Activity activity) {
        askPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    /**
     * 请求位置权限
     *
     * @param activity
     * @param listener
     */
    public static void askLocation(Activity activity, OnPermissionResultListener listener) {
        askPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION, listener);
    }

    /**
     * 请求设备信息权限
     *
     * @param activity
     */
    public static void askDeviceInfo(Activity activity) {
        askPermission(activity, Manifest.permission.READ_PHONE_STATE);
    }

    /**
     * 请求设备信息权限
     *
     * @param activity
     * @param listener
     */
    public static void askDeviceInfo(Activity activity, OnPermissionResultListener listener) {
        askPermission(activity, Manifest.permission.READ_PHONE_STATE, listener);
    }

    /**
     * 请求相机权限
     *
     * @param activity
     */
    public static void askCamera(Activity activity) {
        askPermission(activity, Manifest.permission.CAMERA);
    }

    /**
     * 请求相机权限
     *
     * @param activity
     * @param listener
     */
    public static void askCamera(Activity activity, OnPermissionResultListener listener) {
        askPermission(activity, Manifest.permission.CAMERA, listener);
    }

    /**
     * 请求存储权限
     *
     * @param activity
     */
    public static void askStorage(Activity activity) {
        askPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    /**
     * 请求存储权限
     *
     * @param activity
     * @param listener
     */
    public static void askStorage(Activity activity, OnPermissionResultListener listener) {
        askPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE, listener);
    }

    /**
     * 请求麦克风权限
     * @param activity
     */
    public static void askAudio(Activity activity) {
        askPermission(activity, Manifest.permission.RECORD_AUDIO);
    }

    /**
     * 请求麦克风权限
     * @param activity
     * @param listener
     */
    public static void askAudio(Activity activity, OnPermissionResultListener listener) {
        askPermission(activity, Manifest.permission.RECORD_AUDIO, listener);
    }


}

