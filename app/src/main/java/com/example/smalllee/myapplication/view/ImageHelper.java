package com.example.smalllee.myapplication.view;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * 描述：通过BindAdapter实现自定义属性
 * @author Create by lxn on 2019/2/25
 */
public class ImageHelper {
    @BindingAdapter("resId")
    public static void loadImage(ImageView imageView,int resId) {
        imageView.setImageResource(resId);
    }
}
