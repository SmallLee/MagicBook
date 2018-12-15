package com.example.smalllee.myapplication;

import com.example.smalllee.myapplication.presenter.GetBookListListener;

/**
 * Created by smallLee on 2018/12/9.
 */

public class BookPresenterImpl extends BasePresenter<IBookView> implements IBookPresenter ,GetBookListListener {
    private IBookView iBookView;
    // P层持有Model层引用
    private BookModel bookModel = new BookModel();

    // 数据获取完毕，回调给View层
    @Override
    public void onComplete(String result) {
        if (iBookView != null) {
            iBookView.showBookData(result);
        }
    }

    // P层和View层关联起来
    BookPresenterImpl(IBookView iBookView) {
        this.iBookView = iBookView;
    }
    // P层调用Model层获取数据
    @Override
    public void getBookList() {
        iBookView.showLoading();
        bookModel.getBook(this);
    }

}
