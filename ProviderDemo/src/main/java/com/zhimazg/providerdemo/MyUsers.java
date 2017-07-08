package com.zhimazg.providerdemo;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by haoyundong on 2016/10/19.
 */

public class MyUsers {
    public static final String AUTHORITY  = "com.zhimazg.providerdemo.MyContentProvider";

    // BaseColumn类中已经包含了 _id字段
    public static final class User implements BaseColumns {
        public static final Uri CONTENT_URI  = Uri.parse("content://com.zhimazg.providerdemo.MyContentProvider");

        // 表数据列
        public static final String  USER_NAME  = "USER_NAME";
    }
}
