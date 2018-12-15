package com.example.smalllee.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smalllee.myapplication.contact.BookContact;
import com.example.smalllee.myapplication.event.TokenChangeEvent;
import com.example.smalllee.myapplication.presenter.BookPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MVPActivity extends BaseMvpActivity<BookPresenter> implements BookContact.BookView{
    private static final String TAG = "MVPActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        // 获取数据
        mPresenter.getBook();
    }


    @Override
    public void showLoading() {
        Log.d(TAG, "showLoading: ");
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showBookData(String data) {
        Log.d(TAG, "showBookData: " + data);
    }
}
