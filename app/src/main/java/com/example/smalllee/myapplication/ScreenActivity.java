package com.example.smalllee.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ScreenActivity extends AppCompatActivity {
    private static final String TAG = "ScreenActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        final View view = findViewById(R.id.tv);
                view.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + view.getHeight());
            }
        });
    }
}
