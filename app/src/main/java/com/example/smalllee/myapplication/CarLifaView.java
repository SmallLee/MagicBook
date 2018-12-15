package com.example.smalllee.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by smallLee on 2018/11/14.
 */

public class CarLifaView extends FrameLayout {
    public CarLifaView(@NonNull Context context) {
        this(context,null);
    }

    public CarLifaView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_carlife, this);
    }
}
