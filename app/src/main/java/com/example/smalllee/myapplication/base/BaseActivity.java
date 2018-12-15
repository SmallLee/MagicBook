package com.example.smalllee.myapplication.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.smalllee.myapplication.MyEventBusIndex;
import com.example.smalllee.myapplication.R;

import org.greenrobot.eventbus.EventBus;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
