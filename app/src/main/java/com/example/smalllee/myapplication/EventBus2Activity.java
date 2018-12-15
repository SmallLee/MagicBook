package com.example.smalllee.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smalllee.myapplication.base.BaseActivity;
import com.example.smalllee.myapplication.event.TokenChangeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBus2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        EventBus.builder().addIndex(new MyEventBusIndex()).build();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent2(TokenChangeEvent event){
        Toast.makeText(this,"收到消息了2",Toast.LENGTH_SHORT).show();
    }

    public void postEvent(View view) {
        EventBus.getDefault().post(new TokenChangeEvent());
    }
}
