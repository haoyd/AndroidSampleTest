package com.sample.preventcheatdemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheatManager {

    private Context mContext;

    public CheatManager(Context context) {
        this.mContext = context;
    }

    /**
     * 是克隆体
     * @return
     */
    public boolean isCloneBody() {


        return false;
    }

    /**
     * 文件路径包名是否合格
     * @return
     */
    public boolean isFireDirQualified() {
        String fileDir = mContext.getFilesDir().getAbsolutePath();

        // 防止异常情况获取不到路径
        if (TextUtils.isEmpty(fileDir)) {
            return true;
        }

        // 多开一般路径会包含该选项
        if (fileDir.contains("virtual")) {
            return false;
        }

        // 多开路径包含dkplugin
        if (fileDir.contains("dkplugin")) {
            return false;
        }

        if (appearNumber(fileDir, "/") > 6) {
            return false;
        }

        return true;
    }

    /**
     * 应用中是否存在同我们的App相同包名的App
     * @return
     */
    public boolean isMutiPkg() {
        try {
            if (mContext == null) {
                return false;
            }
            int count = 0;
            String packageName = mContext.getPackageName();
            PackageManager pm = mContext.getPackageManager();
            List<PackageInfo> pkgs = pm.getInstalledPackages(0);
            for (PackageInfo info : pkgs) {
                if (packageName.equals(info.packageName)) {
                    count++;
                }
            }
            return count > 1;
        } catch (Exception ignore) {}

        return false;
    }

    /**
     * 获取指定字符串出现的次数
     *
     * @param srcText 源字符串
     * @param findText 要查找的字符串
     * @return
     */
    public int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }
}
