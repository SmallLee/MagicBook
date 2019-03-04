package com.example.smalllee.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.ViewGroup;

import com.example.smalllee.myapplication.BR;
import com.example.smalllee.myapplication.R;
import com.example.smalllee.myapplication.base.BaseViewHolder;
import com.example.smalllee.myapplication.pojo.DataBean;

/**
 * 描述：
 */
public class BindAdapter extends BaseAdapter<DataBean,BaseViewHolder>{
    private static final String TAG = "BindAdapter";
    public BindAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(mInflater,R.layout.item_databinding,parent,false);
        return new BaseViewHolder<>(dataBinding);
    }

    @Override
    public void onBindVH(BaseViewHolder holder, int position) {
        ViewDataBinding binding = holder.getBinding();
        binding.setVariable(BR.dataBean, mList.get(position));
        binding.setVariable(BR.position,position);
        binding.setVariable(BR.adater,this);
        binding.executePendingBindings();
    }

    public void click(DataBean bean,int position) {
        Log.d(TAG, "click: " + bean + " position " + position);
    }
}
