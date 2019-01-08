package com.example.smalllee.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smalllee.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownActivity extends AppCompatActivity {
    private static final String TAG = "CountDownActivity";
    EditText editText;
    TextView textView;
    private Timer timer;
    SimpleDateFormat format = new SimpleDateFormat("mm:ss");
    int time = 900 * 1000;
    int mPeriod = 5000;
    private Timer mChangePeriodTimer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        editText = findViewById(R.id.et_content);
        textView = findViewById(R.id.tv_result);
    }

    public void countdown(View view) {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String result = format.format(new Date(time));
                            Log.d(TAG, "run: " + result);
                            time -= 1000;
                            textView.setText(result);
                        }
                    });
                }
            },0,1000);
        }
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
        },0,count * 1000);
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
}
