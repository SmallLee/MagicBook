package com.example.smalllee.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by smallLee on 2018/12/8.
 */

public class MyScrollView extends ScrollView {
    private static final String TAG = "MyScrollView";
    public MyScrollView(Context context) {
        this(context,null);
    }
    private int topPosition;
    public ScrollChangedListener mListener;
    public interface ScrollChangedListener{
        void onScollChanged(int t);
    }

    public void setOnSrollChangedListener(ScrollChangedListener listener) {
        this.mListener = listener;
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mListener.onScollChanged(t);
    }

    public void setTopPosition(int topPosition) {
        this.topPosition = topPosition;
        Log.d(TAG, "setTopPosition: " + topPosition);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float y = ev.getY();
        Log.d(TAG, "dispatchTouchEvent: " + y);
        if (y < topPosition) {
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }
}
