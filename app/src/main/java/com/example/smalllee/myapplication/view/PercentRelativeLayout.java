package com.example.smalllee.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.smalllee.myapplication.R;

/**
 * 描述：百分比相对布局
 * @author Create by lxn on 2019/1/28
 */
public class PercentRelativeLayout extends RelativeLayout {
    private static final String TAG = "PercentRelativeLayout";
    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            layoutParams.width = (int) (widthSize * layoutParams.getPercentWidth());
            layoutParams.height= (int) (heightSize * layoutParams.getPercentHeight());
            Log.d(TAG, "LayoutParams onMeasure: " + layoutParams.width + "" + layoutParams.height);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    class LayoutParams extends RelativeLayout.LayoutParams{
        private float percentWidth;
        private float percentHeight;

        float getPercentWidth() {
            return percentWidth;
        }

        float getPercentHeight() {
            return percentHeight;
        }

        LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs,R.styleable.PercentRelativeLayout);
            percentWidth = typedArray.getFloat(R.styleable.PercentRelativeLayout_layoutPercentWidth,0);
            percentHeight = typedArray.getFloat(R.styleable.PercentRelativeLayout_layoutPercentHeight,0);
            Log.d(TAG, "LayoutParams: percentWidth" + percentWidth + "---" +  percentHeight);
        }
    }

    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
    }
}
