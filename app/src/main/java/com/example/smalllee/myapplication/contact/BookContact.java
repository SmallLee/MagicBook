package com.example.smalllee.myapplication.contact;

import com.example.smalllee.myapplication.BasePresenter;
import com.example.smalllee.myapplication.base.BaseModel;
import com.example.smalllee.myapplication.base.BaseView;

/**
 * Created by smallLee on 2018/12/14.
 */

public interface BookContact {
    interface BookView extends BaseView {
        void showBookData(String book);
    }
    interface BookModel extends BaseModel{

    }
    abstract class BookPresenter extends BasePresenter<BookView>{
        public abstract void getBook();
    }
}
