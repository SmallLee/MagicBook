package com.example.smalllee.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

import java.io.Serializable;

/**
 * Created by smallLee on 2018/11/4.
 */

public class Student implements Serializable {
    // alternate制定该字段还可以接受哪些名称，2.4版本后才能使用
    @SerializedName(value = "name",alternate = {"nam","ame"})
    String name;
    @SerializedName("age")
    private int age;
    @SerializedName("email")
    public String email;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
