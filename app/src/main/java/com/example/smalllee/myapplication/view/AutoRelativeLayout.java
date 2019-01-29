package com.example.smalllee.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.smalllee.myapplication.util.UIUtil;

/**
 * 描述：自适应的相对布局
 * @author Create by lxn on 2019/1/28
 */
public class AutoRelativeLayout extends RelativeLayout {
    private boolean flag;
    public AutoRelativeLayout(Context context) {
        super(context);
    }

    public AutoRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!flag) {
            float widthRatio = UIUtil.getInstance(getContext()).getWidthRatio();
            float heightRatio = UIUtil.getInstance(getContext()).getHeightRatio();
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
                layoutParams.width = (int) (layoutParams.width * widthRatio);
                layoutParams.height = (int) (layoutParams.height * heightRatio);
                layoutParams.leftMargin = (int) (layoutParams.leftMargin * widthRatio);
                layoutParams.rightMargin = (int) (layoutParams.rightMargin * widthRatio);
                layoutParams.topMargin = (int) (layoutParams.topMargin * heightRatio);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * heightRatio);
            }
            flag = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
