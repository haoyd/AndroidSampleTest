package com.sample.killgame;

import android.content.Context;
import android.widget.Toast;

public class ToastBox {
    public static void showBottom(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
