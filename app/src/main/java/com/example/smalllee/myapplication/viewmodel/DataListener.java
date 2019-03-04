package com.example.smalllee.myapplication.viewmodel;

import java.util.List;

/**
 * 描述：
 * @author Create by lxn on 2019/2/25
 */
public interface DataListener<T> {
    void onGetData(List<T> beanList);
    void onLoadStart();
    void onLoadComplete();
}
