package com.example.smalllee.myapplication.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.integration.okhttp.OkHttpGlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.smalllee.myapplication.CustomView;
import com.example.smalllee.myapplication.R;
import com.example.smalllee.myapplication.RoundTransformation;

public class GlideActivity extends AppCompatActivity {
    ImageView imageView;
    public static final String URL = "http://guolin.tech/book.png";
    public static final String PLACE = "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg";
    public static final String GIF = "http://wx4.sinaimg.cn/mw690/006duL7rgy1fy0b9qrtdhg30ax05ke83.gif";
    public volatile int inc = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView = findViewById(R.id.image);
    }

    public void loadImage(View view) {
//        Glide.with(this).load(URL)
//                .animate(R.anim.image_load) //指定加载动画，只在第一次加载的时候有效果
//                .into(imageView);
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    inc ++;
                }
            }.start();
        }
        while(Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(inc);
    }
}
