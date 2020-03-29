package com.coolweather.mvptest;

public class MyPresenter extends IPresenter {
    @Override
    IModel createModel() {
        return new Model();
    }

    @Override
    public void doWork1() {
        view.onProgressLoading(0);
        model.getData1(new IModel.ICallback() {
            @Override
            public void onSuccess(String data) {
                view.showText(data);
            }

            @Override
            public void onFailure(String error) {
                view.showText(error);
            }
        });
        view.onProgressLoading(100);
    }

    @Override
    void doWork2() {

    }

    @Override
    public void detachView() {
        view = null;
    }

}
