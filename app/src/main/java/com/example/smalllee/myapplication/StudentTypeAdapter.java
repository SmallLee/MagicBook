package com.example.smalllee.myapplication;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by smallLee on 2018/11/11.
 */

public class StudentTypeAdapter extends TypeAdapter<Student> {
    @Override // 把Json数据的值写入到对象的value中
    public void write(JsonWriter out, Student value) throws IOException {

    }

    @Override // 读取json的值并且转化为对象
    public Student read(JsonReader in) throws IOException {
        return null;
    }
}
