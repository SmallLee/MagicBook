package com.example.smalllee.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.smalllee.myapplication.R;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {
    private static final String TAG = "OkhttpActivity";
    String url = "https://www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
    }
    public void get(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: threadname ");
                Log.d(TAG, "onResponse: " + response.body().string() + "---\n" + call.toString());
            }
        });
    }
    public void postStr(View view) {
        // Post提交字符串
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        String content = "{\"name\":\"张三\"}";
        RequestBody requestBody = RequestBody.create(mediaType,content);
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + request.body().toString());
            }
        });
    }
    // Post提交键值对
    public void postKeyValue(View view) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("name","张三")
                .add("age","12").build();
        final Request request = new Request.Builder().url(url)
                .post(requestBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onResponse: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                RequestBody body = call.request().body();
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }

    public void getHeader(View view) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url)
                .addHeader("User-Agent","androidstudio").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onResponse: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String header = response.header("Cache-Control");
                Log.d(TAG, "onResponse: header" + header);
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }

    public void multipart(View view) {
        MediaType mediaType = MediaType.parse("image/png");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                // 每个都是一个单独的请求体
                .addFormDataPart("image","hal.jpg",
                        RequestBody.create(mediaType,new File("website/static/logo-square.png")))
                .build();
    }

    public void cache(View view) {

        int cacheSize = 10 * 1024 * 1024;
        File cacheFile = new File(getExternalCacheDir(), "okhttpCache");
        Log.d(TAG, "cache: " + getExternalCacheDir());
        Cache cache = new Cache(cacheFile,cacheSize);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();
        final Request request = new Request.Builder()
                .tag("tag")
                .url(url).build();
        Call call = client.newCall(request);
        client.dispatcher().cancelAll();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.networkResponse());
                Log.d(TAG, "onResponse: ca" + response.cacheResponse());
            }
        });
        Call call2 = client.newCall(request);
        call2.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse2: " + response.networkResponse());
                Log.d(TAG, "onResponse2: ca" + response.cacheResponse());
            }
        });
    }

}
