package com.example.smalllee.myapplication;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by smallLee on 2018/11/11.
 */

public class IntTypeAdapter extends TypeAdapter<Integer> {
    @Override // 把Json数据的值写入到对象的value中,序列化过程
    public void write(JsonWriter out, Integer value) throws IOException {
        out.value(String.valueOf(value));
    }

    @Override // 读取json的值并且转化为对象。反序列化过程
    public Integer read(JsonReader in) throws IOException {
        try {
            return Integer.parseInt(in.nextString());
        } catch (Exception e) {
            return -1;
        }
    }
}
