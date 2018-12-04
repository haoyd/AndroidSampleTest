package com.sample.sealdemo.demo1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;

public class CreateSeal {
    private static final float SMALL_CHAR_ANGLE = 15;
    private static final float BIG_CHAR_ANGLE = 20;

    private int roundWidth = 10; // 边框宽度
    float charAngle = SMALL_CHAR_ANGLE; // 文字所占角度
    float textSize;
    private String content;

    private Canvas canvas;
    private Paint paint;
    private Bitmap bitmap;
    private int centre;
    private int radius;

    /***
     * 
     * @param width
     * @param content
     * @param bitmap
     */
    public CreateSeal(int width, String content, Bitmap bitmap) {
        this.roundWidth = width;
        this.content = content;
        this.bitmap = bitmap;
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        paint = new Paint();

        centre = canvas.getWidth() / 2; // 获取圆心的x坐标
        radius = (int) (centre - roundWidth / 2); // 半径

        if (TextUtils.isEmpty(content)) {
            return;
        }

        if (content.length() > 10) {
            charAngle = SMALL_CHAR_ANGLE;
            textSize = radius / 6 + 5;
        } else {
            charAngle = BIG_CHAR_ANGLE;
            textSize = radius / 5 + 5;
        }
    }

    private void getSeal() {
        getRing();
        drawStar();
        drawText();
        drawBottomText();
    }


    // 绘制圆环
    private void getRing() {
        paint.setColor(Color.BLACK); // 设置圆环的颜色
        paint.setStyle(Paint.Style.STROKE); // 设置空心
        paint.setStrokeWidth(roundWidth); // 设置圆环的宽度
        paint.setAntiAlias(true); // 消除锯齿
        canvas.drawCircle(centre, centre, radius, paint); // 画出圆环
    }


    // 绘制五角星
    private void drawStar() {
        float start_radius = (float) ((radius / 2) * 0.5);
        int x = centre, y = centre;
        float x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;


        float r72 = (float) Math.toRadians(72);
        float r36 = (float) Math.toRadians(36);
        // 顶点
        x1 = x;
        y1 = y - start_radius;
        // 左1
        x2 = (float) (x - start_radius * Math.sin(r72));
        y2 = (float) (y - start_radius * Math.cos(r72));
        // 右1
        x3 = (float) (x + start_radius * Math.sin(r72));
        y3 = (float) (y - start_radius * Math.cos(r72));
        // 左2
        x4 = (float) (x - start_radius * Math.sin(r36));
        y4 = (float) (y + start_radius * Math.cos(r36));
        // 右2
        x5 = (float) (x + start_radius * Math.sin(r36));
        y5 = (float) (y + start_radius * Math.cos(r36));


        // 连接各个节点，绘制五角星
        Path path = new Path();
        path.moveTo(x1, y1);
        path.lineTo(x5, y5);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x4, y4);
        path.close();

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        canvas.drawPath(path, paint);
    }

    private void drawText() {
        // 设置文字属性
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);

        // 圆弧文字所在矩形范围
        RectF oval = new RectF(0, 0, 2 * radius, (float) (2 * radius));

        // 首个文字所在角度
        float firstAngle = -90 - charAngle * content.length() / 2;
        for (int i = 0; i < content.length(); i++) {
            Path path = new Path();
            float startAngle = firstAngle + charAngle * i;
            path.addArc(oval, startAngle, charAngle);
            canvas.drawTextOnPath(String.valueOf(content.charAt(i)), path, 0, radius / 4, paint);
        }
    }

    private void drawBottomText() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);

        float startXPosition = radius;
        float startYPosition = radius * 2 - textSize;
        canvas.drawText("财务专用章", startXPosition, startYPosition, paint);
    }

    public Bitmap getBitmap() {
        getSeal();
        return bitmap;
    }


    public int getRoundWidth() {
        return roundWidth;
    }
}
