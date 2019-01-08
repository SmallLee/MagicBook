package com.example.smalllee.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.smalllee.myapplication.R;

public class OkHttpActivity extends AppCompatActivity {
    public static final String URL = "https://www.baidu.com";
    private static final String TAG = "OkHttpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }

    public void syncRequest(View view) {
//        String result = StringUtil.toDBC("\u00a0");
        String result ="\u00a0";
        Log.d(TAG, "syncRequest:" + result.replace("\u00a0","") + "--");
//        OkHttpClient client = new OkHttpClient.Builder().build();
//        Request request = new Request.Builder()
//                .url(URL).build();
//        Call call = client.newCall(request);
//        try {
//            Response response = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
