package com.example.smalllee.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.smalllee.myapplication.R;

public class GlideActivity extends AppCompatActivity {
    private static final String TAG = "GlideActivity";
    ImageView imageView;
    public static final String URL = "http://guolin.tech/book.png";
    public static final String PLACE = "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg";
    public static final String GIF = "http://wx4.sinaimg.cn/mw690/006duL7rgy1fy0b9qrtdhg30ax05ke83.gif";
    public volatile int age = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView = findViewById(R.id.image);
    }

    public void loadImage(View view) {
        Glide.with(this).load(URL)
                .animate(R.anim.image_load) //指定加载动画，只在第一次加载的时候有效果
                .into(imageView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
