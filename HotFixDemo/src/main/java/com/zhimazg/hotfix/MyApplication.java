package com.zhimazg.hotfix;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.taobao.hotfix.HotFixManager;
import com.taobao.hotfix.NewPatchListener;

/**
 * Created by haoyundong on 2016/10/10.
 */

public class MyApplication extends Application {
    private static final String TAG = "hotfix.MainApplication";
    String appVersion;
    String appId;
    Application application;

    @Override
    public void onCreate() {
        super.onCreate();


        initApp();
        initHotfix();
    }

    private void initApp() {
        this.appId = "74763-1";
        this.application = this;
        try {
            this.appVersion = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (Exception e) {
            this.appVersion = "1.1.0";
        }
        Log.i(TAG, "initApp called.");
    }

    private void initHotfix() {
        Log.i(TAG, "initHotfix called.");
        //初始化
        HotFixManager hotFixManager = HotFixManager.getInstance().initialize(application, appVersion, appId, mNewPatchListener);
        //查询最新patch
        hotFixManager.queryNewHotPatch();
    }

    NewPatchListener mNewPatchListener = new NewPatchListener() {
        @Override
        public void handlePatch(int patchVersion) {
            // TODO do something
            Toast.makeText(MyApplication.this, "请重启应用进行更新", Toast.LENGTH_SHORT).show();
        }
    };
}
