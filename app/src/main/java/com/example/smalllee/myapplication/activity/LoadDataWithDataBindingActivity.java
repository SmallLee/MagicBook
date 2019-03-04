package com.example.smalllee.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.smalllee.myapplication.R;
import com.example.smalllee.myapplication.adapter.BindAdapter;
import com.example.smalllee.myapplication.databinding.ActivityLoadDataWithDataBindingBinding;
import com.example.smalllee.myapplication.pojo.DataBean;
import com.example.smalllee.myapplication.viewmodel.DataVM;
import com.example.smalllee.myapplication.viewmodel.IDataView;

import java.util.List;

public class LoadDataWithDataBindingActivity extends AppCompatActivity implements IDataView {
    ActivityLoadDataWithDataBindingBinding binding;
    private BindAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_data_with_data_binding);
        initRecycleView();
        DataVM dataVM = new DataVM(this);
        dataVM.requestData();
        loadDataAsync();
    }

    public void loadDataAsync() {
        // 异步加载数据完成
        reportFullyDrawn();
    }

    public void initRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recView.setLayoutManager(layoutManager);
        adapter = new BindAdapter(this);
        binding.recView.setAdapter(adapter);
    }

    @Override
    public void loadStart() {
        Toast.makeText(this,"加载开始",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadComplete() {
        Toast.makeText(this,"加载结束",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetData(List<DataBean> beanList) {
        adapter.refreshData(beanList);
    }
}
