package com.example.smalllee.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.smalllee.myapplication.BR;
import com.example.smalllee.myapplication.R;
import com.example.smalllee.myapplication.databinding.ActivityDataBindingBinding;
import com.example.smalllee.myapplication.pojo.UserBean;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ActivityDataBindingBinding是根据布局文件名称产生的
        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        UserBean userBean = new UserBean("AA",12);
//        binding.setUser(userBean);
        binding.setVariable(BR.user,userBean);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
