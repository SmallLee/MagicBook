package com.example.smalllee.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * @author Create by lxn on 2019/2/25
 */
public abstract class BaseAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    List<T> mList;
    LayoutInflater mInflater;
    BaseAdapter(Context context) {
        mList = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateVH(parent,viewType);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindVH(holder,position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void refreshData(List<T> data) {
        mList.clear();
        mList.addAll(data);
        notifyDataSetChanged();
    }

    public abstract VH onCreateVH(ViewGroup parent, int viewType);
    public abstract void onBindVH(VH holder, int position);
}
