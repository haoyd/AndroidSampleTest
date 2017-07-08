package com.zhimazg.widgetdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.zhimazg.widgetdemo.R;

/**
 * Created by haoyundong on 2016/12/3.
 */

public class TestView1 extends View {
    private Paint shapePaint;
    private Paint pathPaint;

    public TestView1(Context context) {
        super(context);
        init();
    }

    public TestView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        /**
         * 这部分代码最好在构造函数时就完成，不要写在onDraw中，否则会引起内存抖动
         */
        shapePaint = new Paint();
        shapePaint.setColor(Color.RED);
        shapePaint.setStyle(Paint.Style.FILL);
        shapePaint.setStrokeWidth(10F);


        pathPaint = new Paint();
        pathPaint.setStrokeWidth(10F);
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setColor(Color.BLACK);
        pathPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawPicture(canvas);
        drawPath(canvas);

    }

    /**
     * 绘制形状
     * @param canvas
     */
    private void drawShape(Canvas canvas) {
        // 绘制正方形
        canvas.drawRect(200, 0, 400, 200, shapePaint);

        // 绘制菱形，为了区分，修改下颜色
        shapePaint.setColor(Color.BLUE);
        // 将坐标原点移动到顶点上
        canvas.translate(200, 0);
        // 以坐标原点为中心，进行旋转
        canvas.rotate(45);
        // 绘制菱形
        canvas.drawRect(0, 0, 200, 200, shapePaint);
    }

    /**
     * 绘制图片
     */
    private void drawPicture(Canvas canvas) {
        Bitmap bgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pic);
        canvas.drawBitmap(bgBitmap, new Matrix(), new Paint());
    }

    /**
     * 绘制路径
     * @param canvas
     */
    private void drawPath(Canvas canvas) {
        Path path = new Path();
        path.lineTo(0, 200);
        path.lineTo(200, 200);
        path.close();
        canvas.drawPath(path, pathPaint);
    }
}
