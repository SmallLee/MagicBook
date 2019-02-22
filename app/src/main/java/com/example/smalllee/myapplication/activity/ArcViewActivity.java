package com.example.smalllee.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

import com.example.smalllee.myapplication.R;

import java.util.Locale;

public class ArcViewActivity extends AppCompatActivity {
    private static final String TAG = "ArcViewActivity";
    private TextView tvResult;
    SpannableStringBuilder textStr = new SpannableStringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_view);
        tvResult = findViewById(R.id.tv_result);
    }

    public void time(View view) {
        Intent intent = new Intent(this,SingleTopActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
//        String time1 = "2019-01-15 20:35:53";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time2 = format.format(new Date());
//        try {
//            textStr.clear();
//            textStr.clearSpans();
//            long t1 = format.parse(time1).getTime();
//            long t2 = format.parse(time2).getTime();
//            Log.d(TAG, "time: " + getFormatTime(t2-t1));
//            String text = "已行驶" + getFormatTime(t2-t1);
//            textStr.append(text);
//            textStr.setSpan(new ForegroundColorSpan(Color.parseColor("#09a6ed")),3,text.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//            tvResult.setText(textStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    private String getFormatTime(long orderAcceptTime) {
        long min = orderAcceptTime/60000;
        long second = orderAcceptTime % 60000 / 1000;
        return String.format(Locale.getDefault(), "%2d分钟", min);
    }



}
