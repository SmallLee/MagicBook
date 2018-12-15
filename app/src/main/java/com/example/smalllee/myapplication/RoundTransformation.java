package com.example.smalllee.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by smallLee on 2018/12/15.
 * 转化圆角的Transfromation
 */

public class RoundTransformation extends BitmapTransformation {
    private int radius;
    public RoundTransformation(Context context) {
        this(context,10);
    }

    public RoundTransformation(Context context,int radius) {
        super(context);
        this.radius = radius;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool,toTransform);
    }

    private Bitmap roundCrop(BitmapPool pool, Bitmap source){
        if (source == null) {
            return null;
        }
        Bitmap bitmap = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0,0,source.getWidth(),source.getHeight());
        canvas.drawRoundRect(rectF,radius,radius,paint);
        return bitmap;
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }
}
