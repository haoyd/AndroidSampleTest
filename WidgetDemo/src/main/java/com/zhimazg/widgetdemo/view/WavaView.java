package com.zhimazg.widgetdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by haoyundong on 2016/12/4.
 */

public class WavaView extends View {

    private static final int STEP = 8;
    private static final int COUNT = 5;
    private static final int WAVE_LENGTH = 200;
    private static final int MAX_OFFSET = 200;
    private int offset = 0;

    public WavaView(Context context) {
        this(context, null);
    }

    public WavaView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WavaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        if (offset > MAX_OFFSET) {
                            offset = 0;
                        }
                        offset += STEP;
                        invalidate();
                    }
                });
            }
        }, 300, 200, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setStrokeWidth(5F);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);

        Path path = new Path();
        path.moveTo(offset, 200);
        for (int i = 0; i < COUNT; i++) {
            int randomHeight = new Random().nextInt(50) + 50;
            path.cubicTo(
                    (i + 1F / 3) * WAVE_LENGTH + offset, 200 - randomHeight,
                    (i + 2F / 3) * WAVE_LENGTH + offset, 200 + randomHeight,
                    (i + 1) * WAVE_LENGTH + offset, 200);
        }

        canvas.drawPath(path, paint);

        super.onDraw(canvas);
    }

}
