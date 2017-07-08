package com.zhimazg.webupload;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by haoyundong on 2016/10/27.
 */

public class PrefrenceUtil {

    private Context mContext;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor = null;

    public PrefrenceUtil(Context context) {
        mContext = context;
        preferences = context.getSharedPreferences("aaa", 0);
        editor = preferences.edit();
    }

    public void setString(String key, String value) {
        editor.putString(key, value).apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }


}
