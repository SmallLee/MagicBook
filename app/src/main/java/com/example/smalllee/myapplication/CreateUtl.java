package com.example.smalllee.myapplication;

import java.lang.reflect.ParameterizedType;

/**
 * Created by smallLee on 2018/12/14.
 */

public class CreateUtl {
    public static <T> T get(Object object, int index){
        try {
            return ((Class<T>) ((ParameterizedType)object.getClass().getGenericSuperclass()).getActualTypeArguments()[index]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
