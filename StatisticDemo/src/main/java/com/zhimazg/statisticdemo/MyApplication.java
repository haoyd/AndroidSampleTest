package com.zhimazg.statisticdemo;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by haoyundong on 2016/11/28.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


    }

    private void initStatistic() {
        MobclickAgent.UMAnalyticsConfig config = new MobclickAgent.UMAnalyticsConfig(this, getResources().getString(R.string.UMENG_APPKEY),
                getResources().getString(R.string.UMENG_CHANNEL), MobclickAgent.EScenarioType. E_UM_NORMAL, true);

        //当应用在后台运行超过30秒（默认）再回到前端，将被认为是两个独立的session(启动)
        MobclickAgent.setSessionContinueMillis(100000);
        MobclickAgent.setDebugMode( true );

        MobclickAgent.onProfileSignIn("hao");
    }
}
