package com.example.smalllee.myapplication;

import com.example.smalllee.myapplication.presenter.GetBookListListener;

/**
 * Created by smallLee on 2018/12/9.
 */

public class BookModel {


    public void getBook(GetBookListListener listListener) {
        String result = "Book";
        listListener.onComplete(result);
    }
}
