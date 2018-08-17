package com.example.ps.muggle.component;


import android.text.TextUtils;

import com.example.ps.muggle.base.BaseContract;
import com.example.ps.muggle.http.exception.ApiException;
import com.example.ps.muggle.model.bean.RootBean;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseContract.BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseContract.BaseView view){
        this.mView = view;
    }

    protected CommonSubscriber(BaseContract.BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseContract.BaseView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseContract.BaseView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showMsg(mErrorMsg);
        } else if (e instanceof ApiException) {
            mView.showMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showMsg("数据加载失败ヽ(≧Д≦)ノ");
        } else {
            mView.showMsg("未知错误ヽ(≧Д≦)ノ");
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }
}
