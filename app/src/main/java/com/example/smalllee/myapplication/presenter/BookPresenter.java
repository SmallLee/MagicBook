package com.example.smalllee.myapplication.presenter;

import com.example.smalllee.myapplication.BookModel;
import com.example.smalllee.myapplication.contact.BookContact;

/**
 * Created by smallLee on 2018/12/14.
 */

public  class BookPresenter extends BookContact.BookPresenter implements GetBookListListener {
    private BookModel mBookModel = new BookModel();
    private BookContact.BookView bookView;

    @Override
    public void getBook() {
        bookView = getView();
        bookView.showLoading();
        mBookModel.getBook(this);
    }

    @Override
    public void onComplete(String result) {
        bookView.showBookData(result);
    }
}
