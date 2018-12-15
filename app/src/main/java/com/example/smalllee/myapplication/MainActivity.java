package com.example.smalllee.myapplication;

import android.app.ListActivity;
import android.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.LoaderTestCase;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.smalllee.myapplication.base.BaseActivity;
import com.example.smalllee.myapplication.event.TokenChangeEvent;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.StringReader;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        slidingTabLayout = findViewById(R.id.tablayout);
        initTab();
    }
    public void initTab() {
        String titles[] = {"代驾","车生活","代泊车"};
        slidingTabLayout.setViewPager(viewPager,titles);
    }

    class HomeAdapter extends PagerAdapter{
        List<String> dataList = new ArrayList<>();

        public void update(List<String> list) {

            dataList.clear();
            dataList.addAll(list);
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
