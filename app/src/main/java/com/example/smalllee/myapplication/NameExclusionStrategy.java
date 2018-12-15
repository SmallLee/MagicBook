package com.example.smalllee.myapplication;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * 自定义策略
 */

public class NameExclusionStrategy implements ExclusionStrategy {
    @Override // 排除字段
    public boolean shouldSkipField(FieldAttributes f) {
        return false;
    }

    @Override // 排除类
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
