package com.example.smalllee.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.smalllee.myapplication.R;

/**
 * 描述：百分比相对布局
 * @author Create by lxn on 2019/1/28
 */
public class PercentRelativeLayout extends RelativeLayout {
    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            layoutParams.width = (int) (layoutParams.width * layoutParams.getPercentWidth());
            layoutParams.height= (int) (layoutParams.height* layoutParams.getPercentHeight());
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

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs,R.styleable.Percent);
            percentWidth = typedArray.getFloat(R.styleable.Percent_layoutPercentWidth,0);
            percentHeight = typedArray.getFloat(R.styleable.Percent_layoutPercentWidth,0);
        }
    }
}
