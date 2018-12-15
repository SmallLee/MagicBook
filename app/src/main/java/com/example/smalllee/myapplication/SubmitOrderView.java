package com.example.smalllee.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by smallLee on 2018/10/21.
 */

public class SubmitOrderView extends FrameLayout{

    public SubmitOrderView(@NonNull Context context) {
        this(context, null);
    }

    public SubmitOrderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    public void initView(Context context) {
        View mViewSubmitOrder = LayoutInflater.from(context).inflate(R.layout.view_submit_order, this);
    }
}
