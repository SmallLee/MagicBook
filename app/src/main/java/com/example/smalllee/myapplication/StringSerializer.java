package com.example.smalllee.myapplication;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * 处理序列化，将所有类型转化为字符串
 */

public class StringSerializer implements JsonSerializer<Number> {
    @Override
    public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(String.valueOf(src));
    }
}
