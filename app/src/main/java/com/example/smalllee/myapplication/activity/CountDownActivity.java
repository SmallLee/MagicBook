package com.example.smalllee.myapplication.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smalllee.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownActivity extends AppCompatActivity {
    private static final String TAG = "CountDownActivity";
    EditText editText;
    TextView textView;
    private Timer timer;
    SimpleDateFormat format = new SimpleDateFormat("mm:ss");
    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long time;
    int mPeriod = 5000;
    private Timer mChangePeriodTimer = new Timer();
    String updateTime = "2019-01-18 17:05:43";
    long endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        editText = findViewById(R.id.et_content);
        textView = findViewById(R.id.tv_result);
        setTakeCarCode("1234");
    }

    public void countdown(View view) {
        try {
            endTime = format2.parse(updateTime).getTime();
            time = System.currentTimeMillis() - endTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String result = showTimeMMssBetween(updateTime, format2.format(new Date()));
                            Log.d(TAG, "run: " + result);
                            textView.setText(result);
                        }
                    });
                }
            }, 0, 1000);
        }
    }

    SpannableStringBuilder sb = new SpannableStringBuilder();
    public void setTakeCarCode(String takeCarCode) {
        sb.clear();
        sb.clearSpans();
        String str = "取车码: " + takeCarCode;
        sb.append(str);
        sb.setSpan(new ForegroundColorSpan(Color.parseColor("#19191A")),4,str.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(new StyleSpan(Typeface.BOLD),4,str.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textView.setText(sb);
    }

    public void five(View view) {
        mPeriod = 5000;
        String s = editText.getText().toString();
        int count = Integer.parseInt(s);
        resetTimer();
        mChangePeriodTimer = new Timer();
        mChangePeriodTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d(TAG, "run: 55555");
            }
        }, 0, count * 1000);
    }

    public void resetTimer() {
        mChangePeriodTimer.cancel();
        mChangePeriodTimer.purge();
        mChangePeriodTimer = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer.purge();
    }

    public String showTimeMMssBetween(String startTime, String endTime) {
        Log.d("showTimeMMssBetween", "startTime: " + startTime + "--endTime  " + endTime);
        try {
            long t1 = format2.parse(startTime).getTime();
            long t2 = format2.parse(endTime).getTime();
            long min = (t2 - t1) / 60000;
            long second = (t2 - t1) % 60000 / 1000;
            return String.format(Locale.getDefault(), "%02d:%02d", min, second);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
