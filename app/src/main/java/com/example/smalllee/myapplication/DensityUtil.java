package com.example.smalllee.myapplication;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by smallLee on 2018/12/8.
 */

public class DensityUtil {
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }
}
