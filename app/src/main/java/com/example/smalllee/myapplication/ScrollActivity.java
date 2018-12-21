package com.example.smalllee.myapplication;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class ScrollActivity extends AppCompatActivity {
    private static final String TAG = "ScrollActivity";
    private View titleView;
    private MyScrollView scrollView;
    private LinearLayout mParent;
    private View submitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        mParent = findViewById(R.id.llparent);
        titleView = findViewById(R.id.tv_title);
        scrollView = findViewById(R.id.scrollview);
        submitView = findViewById(R.id.view_submit);
        final int topPadding = getScreenHeight() - DensityUtil.dp2px(this,230) - getStatusBarHeight();
        mParent.setPadding(0,topPadding,0,0);
        Log.d(TAG, "onCreate: " + topPadding);
        scrollView.setTopPosition(topPadding);
        scrollView.setOnSrollChangedListener(new MyScrollView.ScrollChangedListener() {
            @Override
            public void onScollChanged(int t) {
                System.out.println("top====="+(float)t/topPadding);
                float result = (float)t/topPadding;
                scrollView.setTopPosition(topPadding - t);
                if (result > 0.8) {
                    titleExit();
                } else {
                    titleEnter();
                }
            }
        });
    }

    private boolean isEnter;
    public void titleEnter() {
        if (isEnter || !isExtiEnd) {
            return;
        }
        isEnter = true;
        scrollView.setBackgroundColor(getResources().getColor(R.color.color_000000));
        isExtiEnd = false;
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_title_enter);
        titleView.startAnimation(animation);
    }
private boolean isExtiEnd;
    public void titleExit() {
        if (isExtiEnd) {
            return;
        }
        scrollView.setBackgroundColor(getResources().getColor(R.color.color_ffff));
        isExtiEnd = true;
        isEnter = false;
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_title_exit);
        titleView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public int getScreenHeight() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public void setMarginOne(View view) {
        ViewGroup.LayoutParams layoutParams = submitView.getLayoutParams();
        layoutParams.height = DensityUtil.dp2px(this,200);
        submitView.setLayoutParams(layoutParams);
        final int topPadding = getScreenHeight() - submitView.getLayoutParams().height - DensityUtil.dp2px(this,30) - getStatusBarHeight();
        Log.d(TAG, "setMarginOne: " + topPadding);
        mParent.setPadding(0,topPadding,0,0);
    }
    public void setMarginTwo(View view) {
        ViewGroup.LayoutParams layoutParams = submitView.getLayoutParams();
        layoutParams.height = DensityUtil.dp2px(this,150);
        submitView.setLayoutParams(layoutParams);
        final int topPadding = getScreenHeight() - submitView.getLayoutParams().height - DensityUtil.dp2px(this,30) -  getStatusBarHeight();
        Log.d(TAG, "setMarginTwo: " + topPadding);
        mParent.setPadding(0,topPadding,0,0);
    }
}
