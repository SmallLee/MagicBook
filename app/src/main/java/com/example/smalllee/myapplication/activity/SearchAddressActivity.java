package com.example.smalllee.myapplication.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smalllee.myapplication.R;

import java.util.Timer;

// 延迟搜索功能
public class SearchAddressActivity extends AppCompatActivity implements TextWatcher{
    private static final String TAG = "SearchAddressActivity";
    EditText etcontent;
    TextView tvresult;
    public static final int MSG_SEARCH = 0;
    public static final int DELAY = 2000;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            tvresult.setText("正在搜索...");
            Log.d(TAG, "handleMessage: ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tvresult.setText("得到结果");
            Log.d(TAG, "handleMessage: result");
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);
        etcontent = findViewById(R.id.etcontent);
        tvresult = findViewById(R.id.tvresult);
        etcontent.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mHandler.hasMessages(MSG_SEARCH)) {
            mHandler.removeMessages(MSG_SEARCH);
        }
        mHandler.sendEmptyMessageDelayed(MSG_SEARCH,DELAY);
    }
}
