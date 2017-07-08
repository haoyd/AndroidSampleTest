package com.sample.seekbarpressure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SeekBarPressure extends View {
	
    private static final String TAG = "SeekBarPressure";
    
    private static final int CLICK_INVAILD = 0;
    private static final int CLICK_ON_LOW = 1;
    private static final int CLICK_ON_HIGH = 2;
    private static final int CLICK_IN_LOW_AREA = 3;
    private static final int CLICK_IN_HIGH_AREA = 4;
    private static final int CLICK_OUT_AREA = 5;
    
	private List<String> data = new ArrayList<String>();
	
    private static final int[] STATE_NORMAL = {};
    
    private static final int[] STATE_PRESSED = {
            android.R.attr.state_pressed, android.R.attr.state_window_focused,
    };
    
    /**
     * 黑色背景�?
     */
    private Drawable mScrollBarBgNormal;
    /**
     * 蓝色背景�?
     */
    private Drawable mScrollBarProgress;
    /**
     * 前滑�?
     */
    private Drawable mThumbLow;
    /**
     * 后滑�?
     */
    private Drawable mThumbHigh;
    /**
     * 滑动条宽�?
     */
    private int mScollBarWidth;
    /**
     * 滑动条高�?
     */
    private int mScollBarHeight;
    /**
     * 滑动球宽�?
     */
    private int mThumbWidth;
    /**
     * 滑动球高�?
     */
    private int mThumbHeight;
    /**
     * 滑动条高度的�?��
     */
    private int mHalfScollBarHeight;
    /**
     * 滑块高度的一�?
     */
    private int mHalfThumbHeight;
    /**
     * 前滑块所在的刻度
     */
    private int mprogressLow;
    /**
     * 后滑块所在的刻度
     */
    private int mprogressHigh;
    /**
     * 前滑块的偏移
     */
    private int mOffsetLow = 0;
    /**
     * 后滑块的偏移
     */
    private int mOffsetHigh = 0;
    /**
     * 滑动区域
     */
    private int mDistance = 0;
    /**
     * �?���?
     */
    private float mMin = 1.0f;
    /**
     * �?���?
     */
    private float mMax = 5.0f;

    private int mDuration = 0;
    /**
     * 滑块的状�?
     */
    private int mFlag = CLICK_INVAILD;
    /**
     * 监听
     */
    private OnSeekBarChangeListener mBarChangeListener;

    public SeekBarPressure(Context context) {
        this(context, null);
    }

    public SeekBarPressure(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SeekBarPressure(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SeeBarPressure, defStyle,  0);
        mMin = a.getFloat(R.styleable.SeeBarPressure_minValue, mMin);
        mMax = a.getFloat(R.styleable.SeeBarPressure_maxValue, mMax);
        mScollBarWidth = a.getLayoutDimension(R.styleable.SeeBarPressure_width, -1);
//        mScollBarWidth = 700;
        mScollBarHeight = a.getLayoutDimension(R.styleable.SeeBarPressure_height, -2);
        mDistance = mScollBarWidth - mThumbWidth;
        mDuration = (int) Math.rint(a.getFloat(R.styleable.SeeBarPressure_duration, mDuration) * mDistance / (mMax - mMin));
        mOffsetHigh = (data.size()-1)* ((mScollBarWidth-mThumbWidth) / (data.size()-1));
        if (mMin == 0) {
            throw new RuntimeException(a.getPositionDescription()  + ": You must supply a minValue attribute.");
        }
        if (mMax == 0) {
            throw new RuntimeException(a.getPositionDescription()   + ": You must supply a maxValue attribute.");
        }
        if (mMin > mMax) {
            throw new RuntimeException(a.getPositionDescription()  + ": The minValue attribute must be smaller than the maxValue attribute.");
        }
        if (mDuration == 0) {
            throw new RuntimeException(a.getPositionDescription()  + ": You must supply a duration attribute.");
        }
        if (mScollBarWidth == 0 || mScollBarWidth == -1 || mScollBarWidth == -2) {
            throw new RuntimeException(a.getPositionDescription()  + ": You must supply a width attribute.");
        }
        if (mScollBarHeight == 0 || mScollBarHeight == -1 || mScollBarHeight == -2) {
            throw new RuntimeException(a.getPositionDescription()  + ": You must supply a height attribute.");
        }
        a.recycle();
    }

    public void init(Context context) {
        Resources resources = getResources();
        // 获取黑色背景资源
        mScrollBarBgNormal = resources.getDrawable(R.mipmap.progress_bg);
        // 获取蓝色背景资源
        mScrollBarProgress = resources.getDrawable(R.mipmap.area);
        // 获取前滑�?
        mThumbLow = resources.getDrawable(R.mipmap.heidian);
        // 获取后滑�?
        mThumbHigh = resources.getDrawable(R.mipmap.landian);
        // 设置前滑块的状�?
        mThumbLow.setState(STATE_NORMAL);
        // 设置后滑块的状�?
        mThumbHigh.setState(STATE_NORMAL);
        // 获取滑块的宽�?
        mThumbWidth = mThumbLow.getIntrinsicWidth();
        // 获取滑块的高�?
        mThumbHeight = mThumbLow.getIntrinsicHeight();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int width = mScollBarWidth + 70;
//        int height = mThumbHeight + 70;
//        setMeasuredDimension(width, height);

        int desiredWidth = 100;
        int desiredHeight = 100;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }


        //MUST CALL THIS
        setMeasuredDimension(width, height);



    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mHalfScollBarHeight = mScollBarHeight >> 1;
        mHalfThumbHeight = mThumbHeight >> 1;

        // 竖线的画�?
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);

        // 刻度值的画笔
        Paint text_Paint = new Paint();
        text_Paint.setTextAlign(Paint.Align.CENTER);
        text_Paint.setColor(Color.BLUE);
        text_Paint.setAntiAlias(true);
        text_Paint.setTextSize(35);

        FontMetrics fontMetrics = text_Paint.getFontMetrics();
        float fontTotalHeight = fontMetrics.bottom - fontMetrics.top;
        float offY = fontTotalHeight / 2 - fontMetrics.bottom;
        float newY = 13 + offY;

        int dis = (mScollBarWidth - mThumbWidth) / (data.size() - 1);

        float maxX = 0f;

        for(int i=0; i<data.size(); i++) {
    		maxX = mThumbWidth/2+i*dis;
        	canvas.drawLine(mThumbWidth/2+i*dis, mThumbHeight + 5, mThumbWidth/2+i*dis, mThumbHeight + 25, paint);
		}

        maxX += mThumbWidth/2;

//        for(int i=0; i<data.size(); i++) {
//        		canvas.drawText(data.get(i), mThumbWidth/2+i*dis, mThumbHeight + 60, text_Paint);
//        }

        mScrollBarBgNormal.setBounds(0, 0, (int) maxX, mThumbHeight);
        mScrollBarBgNormal.draw(canvas);

        mScrollBarProgress.setBounds(mOffsetLow + 20, 0, mOffsetHigh + mThumbWidth - 20, mThumbHeight);
        mScrollBarProgress.draw(canvas);

        mThumbLow.setBounds(mOffsetLow, 0 , mOffsetLow  + mThumbWidth,   mThumbHeight);
        mThumbLow.draw(canvas);

        mThumbHigh.setBounds(mOffsetHigh, 0 , mOffsetHigh  + mThumbWidth, mThumbHeight);
        mThumbHigh.draw(canvas);

        int low_position = (mOffsetLow / dis);
        int high_position = (mOffsetHigh / dis);
        canvas.drawText(data.get(low_position), mThumbWidth/2+low_position*dis, mThumbHeight + 60, text_Paint);
        canvas.drawText(data.get(high_position), mThumbWidth/2+high_position*dis, mThumbHeight + 60, text_Paint);

        if (mBarChangeListener != null) {
            double progressLow = formatDouble(mOffsetLow * (mMax - mMin) / mDistance + mMin);
            double progressHigh = formatDouble(mOffsetHigh * (mMax - mMin) / mDistance + mMin);
            mBarChangeListener.onProgressChanged(this, progressLow, progressHigh, mprogressLow,
            		mprogressHigh, mMax, mMin);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            mFlag = getAreaFlag(e);
            if (mFlag == CLICK_ON_LOW) {
                mThumbLow.setState(STATE_PRESSED);
            } else if (mFlag == CLICK_ON_HIGH) {
                mThumbHigh.setState(STATE_PRESSED);
            } else if (mFlag == CLICK_IN_LOW_AREA) {
                mThumbLow.setState(STATE_PRESSED);
                if (e.getX() < 0 || e.getX() <= mThumbWidth) {
                    mOffsetLow = 0;
                } else if (e.getX() > mScollBarWidth - mThumbWidth) {
                    mOffsetLow = mDistance - mDuration;
                } else {
                    mOffsetLow = formatInt(e.getX() - (double)mThumbWidth / 2);
                    if (mOffsetHigh - mDuration <= mOffsetLow) {
                        mOffsetHigh = (mOffsetLow + mDuration <= mDistance) ? (mOffsetLow + mDuration)
                                : mDistance;
                        mOffsetLow = mOffsetHigh - mDuration;
                    }
                }
            } else if (mFlag == CLICK_IN_HIGH_AREA) {
                mThumbHigh.setState(STATE_PRESSED);
                if (e.getX() < mDuration) {
                    mOffsetHigh = mDuration;
                    mOffsetLow = mOffsetHigh - mDuration;
                } else if (e.getX() >= mScollBarWidth - mThumbWidth) {
                    mOffsetHigh = mDistance;
                } else {
                    mOffsetHigh = formatInt(e.getX() - (double)mThumbWidth / 2);
                    if (mOffsetHigh - mDuration <= mOffsetLow) {
                        mOffsetLow = (mOffsetHigh - mDuration >= 0) ? (mOffsetHigh - mDuration) : 0;
                        mOffsetHigh = mOffsetLow + mDuration;
                    }
                }
            }
        } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
        	getParent().requestDisallowInterceptTouchEvent(true);
            if (mFlag == CLICK_ON_LOW) {
                if (e.getX() < 0 || e.getX() <= mThumbWidth) {
                    mOffsetLow = 0;
                } else if (e.getX() > mScollBarWidth - mThumbWidth - mDuration) {
                    mOffsetLow = mDistance - mDuration;
                    mOffsetHigh = mOffsetLow + mDuration;
                } else {
                    mOffsetLow = formatInt(e.getX() - (double)mThumbWidth / 2);
                    if (mOffsetHigh - mOffsetLow <= mDuration) {
                        mOffsetHigh = (mOffsetLow + mDuration <= mDistance) ? (mOffsetLow + mDuration) : mDistance;
                    }
                }
            } else if (mFlag == CLICK_ON_HIGH) {
                if (e.getX() < mDuration + mThumbWidth) {
                    mOffsetHigh = mDuration;
                    mOffsetLow = 0;
                } else if (e.getX() > mScollBarWidth - mThumbWidth) {
                    mOffsetHigh = mDistance;
                } else {
                    mOffsetHigh = formatInt(e.getX() - (double)mThumbWidth / 2);
                    if (mOffsetHigh - mOffsetLow <= mDuration) {
                        mOffsetLow = (mOffsetHigh - mDuration >= 0) ? (mOffsetHigh - mDuration) : 0;
                    }
                }
            }
        } else if (e.getAction() == MotionEvent.ACTION_UP) {
            mThumbLow.setState(STATE_NORMAL);
            mThumbHigh.setState(STATE_NORMAL);

            //这两个for循环 是用来自动对齐刻度的，注释后，就可以自由滑动到任意位�?
            for (int i = 0; i < data.size(); i++) {
            	 if(Math.abs(mOffsetLow-i* ((mScollBarWidth-mThumbWidth)/ (data.size()-1)))<=(mScollBarWidth-mThumbWidth)/(data.size()-1)/2){
            		 mprogressLow=i;
                     mOffsetLow =i* ((mScollBarWidth-mThumbWidth)/(data.size()-1));
                     invalidate();
                     break;
                }
			}
            
            for (int i = 0; i < data.size(); i++) {
            	  if(Math.abs(mOffsetHigh-i* ((mScollBarWidth-mThumbWidth)/(data.size()-1) ))<(mScollBarWidth-mThumbWidth)/(data.size()-1)/2){
            		  mprogressHigh=i;
                	   mOffsetHigh =i* ((mScollBarWidth-mThumbWidth)/(data.size()-1));
                       invalidate();
                       break;
                }
			}
        }
        setProgressLow(formatDouble(mOffsetLow * (mMax - mMin) / mDistance + mMin));
        setProgressHigh(formatDouble(mOffsetHigh * (mMax - mMin) / mDistance + mMin));
        return true;
    }
    
    public int getAreaFlag(MotionEvent e) {
    	int top = 0;
    	int bottom = mThumbHeight;
        if (e.getY() >= top && e.getY() <= bottom && e.getX() >= mOffsetLow && e.getX() <= mOffsetLow + mThumbWidth) {
            return CLICK_ON_LOW;
        } else if (e.getY() >= top && e.getY() <= bottom && e.getX() >= mOffsetHigh && e.getX() <= mOffsetHigh + mThumbWidth) {
            return CLICK_ON_HIGH;
        } else if (e.getY() >= top
                && e.getY() <= bottom
                && ((e.getX() >= 0 && e.getX() < mOffsetLow) || ((e.getX() > mOffsetLow
                        + mThumbWidth) && e.getX() <= ((double)mOffsetHigh + mOffsetLow + mThumbWidth) / 2))) {
            return CLICK_IN_LOW_AREA;
        } else if (e.getY() >= top
                && e.getY() <= bottom
                && (((e.getX() > ((double)mOffsetHigh + mOffsetLow + mThumbWidth) / 2) && e.getX() < mOffsetHigh) || (e
                        .getX() > mOffsetHigh + mThumbWidth && e.getX() <= mScollBarWidth))) {
            return CLICK_IN_HIGH_AREA;
        } else if (!(e.getX() >= 0 && e.getX() <= mScollBarWidth && e.getY() >= top && e.getY() <= bottom)) {
            return CLICK_OUT_AREA;
        } else {
            return CLICK_INVAILD;
        }
    }

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public void setMax(double max) {
        this.mMax = (float) max;
    }
    
    public double getMax() {
        return mMax;
    }
    
    public void setMin(double min) {
        this.mMin = (float) min;
    }
    
    public double getMin() {
        return mMin;
    }
    
    public void setProgressLow(double progressLow) {
        mOffsetLow = formatInt((progressLow - mMin) / (mMax - mMin) * mDistance);
        invalidate();
    }
    
    public void setProgressHigh(double progressHigh) {
        mOffsetHigh = formatInt((progressHigh - mMin) / (mMax - mMin) * mDistance);
        invalidate();
    }
    
    public void setProgressLowInt(int progressLow) {
    	  this.mprogressLow = progressLow;
    	  mOffsetLow = progressLow * ((mScollBarWidth - mThumbWidth) / (data.size() - 1));
    }

	public void setProgressHighInt(int progressHigh) {
		   this.mprogressHigh = progressHigh;
		   mOffsetHigh = progressHigh * ((mScollBarWidth-mThumbWidth) / (data.size()-1));
	}
    
    public double getProgressLow() {
        return formatDouble(mOffsetLow * (mMax - mMin) / mDistance + mMin);
    }
    
    public double getProgressHigh() {
        return formatDouble(mOffsetHigh * (mMax - mMin) / mDistance + mMin);
    }
    
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener mListener) {
        this.mBarChangeListener = mListener;
    }
    
    public interface OnSeekBarChangeListener {
        public void onProgressChanged(SeekBarPressure seekBar, double progressLow,
                                      double progressHigh, int mprogressLow, int mprogressHigh, double max, double min);
    }
    
    public static double formatDouble(double pDouble) {
        BigDecimal bd = new BigDecimal(pDouble);
        BigDecimal bd1 = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
        pDouble = bd1.doubleValue();
        return pDouble;
    }
    
    private int formatInt(double value) {
        BigDecimal bd = new BigDecimal(value);
        BigDecimal bd1 = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
        return bd1.intValue();
    }
    
}
