package com.example.ps.muggle.ui.main.activity;

import android.view.View;

import com.example.ps.muggle.R;
import com.example.ps.muggle.base.BaseActivity;
import com.example.ps.muggle.contract.main.MainContract;
import com.example.ps.muggle.model.bean.RootBean;
import com.example.ps.muggle.presenter.main.MainPresenter;
import com.example.ps.muggle.utils.ToastUtil;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, View.OnClickListener {

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showAppUpdate() {
        ToastUtil.shortShow("更新");
    }

    @Override
    public void setVideoInfo(RootBean rootBean) {

    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    @Override
    protected void beforeSetContentView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }
}
