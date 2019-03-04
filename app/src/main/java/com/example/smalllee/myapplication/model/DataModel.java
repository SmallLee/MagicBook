package com.example.smalllee.myapplication.model;

import com.example.smalllee.myapplication.pojo.DataBean;
import com.example.smalllee.myapplication.viewmodel.DataListener;

import java.util.ArrayList;

/**
 * 描述：Model层，获取数据
 * @author Create by lxn on 2019/2/25
 */
public class DataModel {
    public void getData(DataListener<DataBean> listener) {
        ArrayList<DataBean> beanArrayList = new ArrayList<>();
        DataBean dataBean = new DataBean("AA",1,false);
        DataBean dataBean2 = new DataBean("BB",1,true);
        DataBean dataBean3 = new DataBean("AA",1,true);
        beanArrayList.add(dataBean);
        beanArrayList.add(dataBean2);
        beanArrayList.add(dataBean3);
        listener.onLoadStart();
        listener.onGetData(beanArrayList);
        listener.onLoadComplete();
    }
}
