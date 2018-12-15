package com.example.smalllee.myapplication;

import java.lang.ref.WeakReference;

/**
 * Created by smallLee on 2018/12/9.
 * 弱引用解决内存泄漏问题
 */

public abstract class BasePresenter<V>  {
    private WeakReference<V> weakReference;
    // P层和View层关联
    void attachView(V view){
        weakReference = new WeakReference<V>(view);
    }

    // 页面销毁的时候清除对象
    void detachView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
