package com.example.smalllee.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.smalllee.myapplication.base.BaseView;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.ParameterizedType;

/**
 * Created by smallLee on 2018/12/9.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity{
    private static final String TAG = "BaseMvpActivity";
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = CreateUtl.get(this,0);
        mPresenter.attachView(this);
        EventBus.builder().addIndex(new MyEventBusIndex())
                .installDefaultEventBus()
                .register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
