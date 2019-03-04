package com.example.smalllee.myapplication.aop;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.smalllee.myapplication.R;
import com.example.smalllee.myapplication.aop.anotation.BehaviorTrace;

import java.text.SimpleDateFormat;

public class AOPActivity extends AppCompatActivity {
    private static final String TAG = "AOPActivity";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);
    }

   /* public void audio(View view) {
        Log.d(TAG, "语音通话: " + sdf.format(new Date()));
        long begin = System.currentTimeMillis();
        SystemClock.sleep(3000);
        Log.d(TAG, "开始语音: ");
        Log.d(TAG, "耗时: " + (System.currentTimeMillis() - begin));
    }

    public void shake(View view) {
        Log.d(TAG, "摇一摇: " + sdf.format(new Date()));
        long begin = System.currentTimeMillis();
        SystemClock.sleep(3000);
        Log.d(TAG, "摇到一个: ");
        Log.d(TAG, "耗时: " + (System.currentTimeMillis() - begin));
    }

    public void video(View view) {
        Log.d(TAG, "视频通话: " + sdf.format(new Date()));
        long begin = System.currentTimeMillis();
        SystemClock.sleep(3000);
        Log.d(TAG, "正在视频: ");
        Log.d(TAG, "耗时: " + (System.currentTimeMillis() - begin));
    }*/
   @BehaviorTrace("语音通话")
    public void audio(View view) {
        SystemClock.sleep(3000);
        Log.d(TAG, "开始语音: ");
    }
    @BehaviorTrace("摇一摇")
    public void shake(View view) {
        SystemClock.sleep(3000);
        Log.d(TAG, "摇到一个: ");
    }
}
