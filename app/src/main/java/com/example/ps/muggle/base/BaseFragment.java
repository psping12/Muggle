package com.example.ps.muggle.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ps.muggle.app.MyApp;
import com.example.ps.muggle.di.component.DaggerFragmentComponent;
import com.example.ps.muggle.di.component.FragmentComponent;
import com.example.ps.muggle.di.module.FragmentModule;
import com.example.ps.muggle.utils.ToastUtil;

public abstract class BaseFragment<T extends BasePresenter> extends SampleFragment implements BaseContract.BaseView {

    protected T mPresenter;

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApp.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter.attachView(this);
        initInject();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    protected abstract void initInject();

    @Override
    public void showMsg(String msg) {
        ToastUtil.shortShow(msg);
    }
}
