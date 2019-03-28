package com.example.smalllee.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.smalllee.myapplication.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {
    public static final String URL = "https://www.baidu.com";
    private static final String TAG = "OkHttpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }

    public void syncRequest(View view) {
      Thread thread = new Thread(new CallRunnable());
      thread.start();
    }
    class CallRunnable implements Runnable{
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient.Builder().build();
            Request request = new Request.Builder()
                    .url(URL).build();
            Call call = client.newCall(request);
            try {
                Response response = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
