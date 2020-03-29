package com.coolweather.mvptest;

public class Model implements IModel {
    @Override
    public void getData1(final ICallback callback){
        new Thread(){
            @Override
            public void run(){
                super.run();
                try {
                    Thread.sleep(5000);
                    callback.onSuccess("获取数据成功");
                }catch (InterruptedException e){
                    e.printStackTrace();
                    callback.onFailure("获取数据失败");
                }
            }
        }.start();
    }
    public void getData2(final ICallback callback){

    }
}

