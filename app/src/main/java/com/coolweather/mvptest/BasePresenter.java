package com.coolweather.mvptest;

import androidx.annotation.UiThread;

public abstract class BasePresenter <V extends IView, M extends IModel>{
    protected V view;
    protected M model;

    public BasePresenter() {
        model = createModel();
    }
    @UiThread
    void attachView(V view) {
        this.view = view;
    }

    @UiThread
    void detachView() {
        this.view = null;
    }

    abstract M createModel();

}
