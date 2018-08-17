package com.example.ps.muggle.widget;

import android.text.TextUtils;

import com.example.ps.muggle.base.BaseContract;
import com.example.ps.muggle.http.exception.ApiException;
import com.example.ps.muggle.model.bean.RootBean;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

public abstract class FkCommonSubscriber<T> extends ResourceSubscriber<T> {

    private BaseContract.BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected FkCommonSubscriber(BaseContract.BaseView view) {
        this.mView = view;
    }

    protected FkCommonSubscriber(BaseContract.BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected FkCommonSubscriber(BaseContract.BaseView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected FkCommonSubscriber(BaseContract.BaseView view, String errorMsg, boolean isShowErrorState) {
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
            mView.showMsg(((ApiException) e).getCode() + e.getMessage());
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            try {
                String content = httpException.response().errorBody().string();
                Gson gson = new Gson();
                RootBean rootBean = gson.fromJson(content, RootBean.class);
                ApiException apiException = new ApiException(rootBean.getMsg(), rootBean.getCode());
                mView.showMsg(rootBean.getMsg());
                onError(apiException);
            } catch (IOException e1) {
                e1.printStackTrace();
                ApiException apiException = new ApiException("未知错误", -666);
                mView.showMsg("未知错误");
                onError(apiException);
            }
        } else {
            mView.showMsg("未知错误ヽ(≧Д≦)ノ");
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }


}
