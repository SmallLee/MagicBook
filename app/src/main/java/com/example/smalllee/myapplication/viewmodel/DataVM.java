package com.example.smalllee.myapplication.viewmodel;

import com.example.smalllee.myapplication.model.DataModel;
import com.example.smalllee.myapplication.pojo.DataBean;

import java.util.List;

/**
 * 描述：ViewModel
 * @author Create by lxn on 2019/2/25
 */
public class DataVM implements DataListener<DataBean>{
    private DataModel mModel;
    private IDataView view;
    public DataVM(IDataView dataView) {
        view = dataView;
        mModel = new DataModel();
    }

    public void requestData() {
        mModel.getData(this);
    }

    @Override
    public void onGetData(List<DataBean> beanList) {
        view.onGetData(beanList);
    }

    @Override
    public void onLoadStart() {
        view.loadStart();
    }

    @Override
    public void onLoadComplete() {
        view.loadComplete();
    }
}
