package com.example.smalllee.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.smalllee.myapplication.BaseMvpActivity;
import com.example.smalllee.myapplication.EventBus2Activity;
import com.example.smalllee.myapplication.MainActivity;
import com.example.smalllee.myapplication.MyEventBusIndex;
import com.example.smalllee.myapplication.R;
import com.example.smalllee.myapplication.base.BaseActivity;
import com.example.smalllee.myapplication.event.TokenChangeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class EventBusActivity extends BaseActivity {
    private static final String TAG = "EventBusActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        EventBus.builder().addIndex(new MyEventBusIndex()).build();
        EventBus.getDefault().register(this);

    }

    public void postEvent(View view) {
        EventBus.getDefault().post(new TokenChangeEvent());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(TokenChangeEvent event){
        Toast.makeText(this,"收到消息了",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().removeAllStickyEvents();
    }

    public void startmain(View view) {
        Intent intent = new Intent(this, EventBus2Activity.class);
        startActivity(intent);
    }
}
