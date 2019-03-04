package com.example.smalllee.myapplication.pojo;

/**
 * 描述：
 * @author Create by lxn on 2019/2/25
 */
public class DataBean {
    public String address;
    public int height;
    public boolean isCat;

    public DataBean(String address, int height,boolean isCat) {
        this.address = address;
        this.height = height;
        this.isCat = isCat;
    }

//    public boolean isCat() {
//        return isCat;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public int getHeight() {
//        return height;
//    }
}
