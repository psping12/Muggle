package com.example.ps.muggle.base;


import com.example.ps.muggle.app.MyApp;
import com.example.ps.muggle.di.component.ActivityComponent;
import com.example.ps.muggle.di.component.DaggerActivityComponent;
import com.example.ps.muggle.di.module.ActivityModule;
import com.example.ps.muggle.utils.ToastUtil;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.Observable;

import javax.inject.Inject;

import io.reactivex.Flowable;

public abstract class BaseActivity<T extends BasePresenter> extends SampleActivity implements BaseContract.BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApp.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        mPresenter.attachView(this);
    }

    @Override
    public <T> LifecycleTransformer<T> bindLifeCycle() {
        return super.bindLifeCycle();
    }

    @Override
    protected void onDestroy() {
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
