package com.coolweather.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolweather.mvptest.IView;

public class ViewActivity extends AppCompatActivity implements IView {

    private ProgressBar progressBar;
    private TextView infoText;
    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // 初始化Presenter
        mPresenter = new MyPresenter();
        mPresenter.attachView(this);
        // 实现仅仅通过Presenter来处理业务逻辑
        mPresenter.doWork1();
    }

    @Override
    public void onProgressLoading(int progress){
        // UI展示 业务处理完成结果
        progressBar.setProgress(progress);
    }
    @Override
    public void showText(String data){
       infoText.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
