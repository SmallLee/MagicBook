package com.example.smalllee.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * 描述：弧线
 * @author Create by lxn on 2019/1/5
 */
public class ArcView extends View {
    private Paint mPaint;
    public ArcView(Context context) {
        this(context,null);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#3b414d"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        super.onDraw(canvas);
        RectF rectF = new RectF(0,0,width,height * 0.5f);
        canvas.drawArc(rectF,0,180,true,mPaint);
    }
}
