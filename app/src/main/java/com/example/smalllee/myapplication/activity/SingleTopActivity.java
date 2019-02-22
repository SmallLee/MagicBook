package com.example.smalllee.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.smalllee.myapplication.R;

public class SingleTopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
    }

    public void jump(View view) {
        Intent intent = new Intent(this,ArcViewActivity.class);
        startActivity(intent);
    }
}
