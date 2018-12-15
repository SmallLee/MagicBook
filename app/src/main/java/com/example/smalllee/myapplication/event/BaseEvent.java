package com.example.smalllee.myapplication.event;

/**
 * Created by smallLee on 2018/12/14.
 */

public class BaseEvent<T> {
    private T data;
    BaseEvent(){}
    BaseEvent(T data){
        this.data = data;
    }
    public T getData() {
        return data;
    }
}
