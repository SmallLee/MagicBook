package com.example.smalllee.myapplication.viewmodel;

import com.example.smalllee.myapplication.base.IBaseView;
import com.example.smalllee.myapplication.pojo.DataBean;

import java.util.List;

/**
 * 描述：
 * @author Create by lxn on 2019/2/25
 */
public interface IDataView extends IBaseView {
    void onGetData(List<DataBean> beanList);
}
