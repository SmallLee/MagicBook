package com.example.smalllee.myapplication.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Method;

/**
 * 描述：屏幕适配工具类
 * @author Create by lxn on 2019/1/28
 */
public class UIUtil {
    private static final String TAG = "UIUtil";
    private static UIUtil mInstance;
    private Context mContext;
    private static final int STANDARD_WIDTH = 1080;
    private static final int STANDARD_HEIGHT = 1920;
    private static final int DEFAULT_STATUS_BAR_HEIGHT = 60;
    private int mWidthDisplayMetrics;
    private int mHeightDisplayMetrics;

    private UIUtil(Context context) {
        this.mContext = context;
        initSetting();
    }

    public static UIUtil getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UIUtil(context);
        }
        return mInstance;
    }

    private void initSetting() {
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (mWidthDisplayMetrics == 0 || mHeightDisplayMetrics == 0) {
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    Toast.makeText(mContext,"横屏",Toast.LENGTH_LONG).show();
                    // 横屏
                    mWidthDisplayMetrics = displayMetrics.heightPixels;
                    mHeightDisplayMetrics = displayMetrics.widthPixels;
                } else {
                    mWidthDisplayMetrics = displayMetrics.widthPixels;
                    mHeightDisplayMetrics = displayMetrics.heightPixels;
                }
            }
        }
        boolean hasNaviBar = checkHasNavigationBar(mContext);
        Log.d(TAG, "checkDeviceHasNavigationBar: " + hasNaviBar);
        if (hasNaviBar) {
            Log.d(TAG, "getNaviBarHeight: " + getNaviBarHeight());
        }
    }

    public float getWidthRatio() {
        return (float) mWidthDisplayMetrics / STANDARD_WIDTH;
    }

    public float getHeightRatio() {
        Log.d(TAG, "getHeightRatio: " + mHeightDisplayMetrics + "getNaviBarHeight" + getNaviBarHeight());
        return (float) mHeightDisplayMetrics / (STANDARD_HEIGHT - getNaviBarHeight());
    }

    // 获取状态栏高度
    private int getStatusBarHeight() {
        int result = DEFAULT_STATUS_BAR_HEIGHT;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    // 是否有虚拟按键
    private static boolean checkHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            @SuppressWarnings("unchecked")
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasNavigationBar;
    }

    // 虚拟按键高度
    private int getNaviBarHeight() {
        int vh = 0;
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null) {
            return 0;
        }
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        try {
            @SuppressWarnings("rawtypes")
            Class c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            vh = dm.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vh;
    }
}
