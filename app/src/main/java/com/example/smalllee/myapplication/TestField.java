package com.example.smalllee.myapplication;

import java.lang.reflect.Field;

/**
 * 描述：测试获取父类私有字段
 * @author Create by lxn on 2019/2/25
 */
public class TestField {
    public static void main(String[] args) {
        try {
            ChildClass childClass = ChildClass.class.newInstance();
            Class<?> parentClass = Class.forName("com.example.smalllee.myapplication.ParentClass");
            Field field = parentClass.getDeclaredField("age");
            field.setAccessible(true);
            Object value = field.get(childClass);
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
