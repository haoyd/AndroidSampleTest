package com.sample.sealdemo.demo1;

import android.graphics.Bitmap;

public class SealView extends CreateSeal {
    /***
     * 
     * @param width
     * @param content
     * @param bitmap
     */
    public SealView(int width, String content, Bitmap bitmap) {
        super(width, content, bitmap);
    }

    /**
     * 绘制印章
     * @param width     边框宽度
     * @param content   印章内容
     * @param diameter  印章位图
     * @return
     */
    public static Bitmap DrawDeal(int width, String content, int diameter) {
        Bitmap bitmap = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.RGB_565);
        SealView s = new SealView(width, content, bitmap);
        return s.getBitmap();
    }

}
