package com.example.ps.muggle.presenter.main;

import com.example.ps.muggle.base.BasePresenter;
import com.example.ps.muggle.contract.main.MainContract;
import com.example.ps.muggle.model.DataManager;
import com.example.ps.muggle.model.bean.RootBean;
import com.example.ps.muggle.model.bean.VersionBean;
import com.example.ps.muggle.utils.RxUtils;
import com.example.ps.muggle.widget.FkCommonSubscriber;
import com.google.gson.JsonObject;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    @Override
    public void checkVersion() {
        dataManager.fetchVersion()
                .compose(RxUtils.<RootBean<VersionBean>>applyScheduler())
                .compose(mView.<RootBean<VersionBean>>bindLifeCycle())
                .compose(RxUtils.<VersionBean>handleFKResult())
                .subscribe(new FkCommonSubscriber<RootBean<VersionBean>>(mView) {
                    @Override
                    public void onNext(RootBean<VersionBean> versionBeanRootBean) {
                        if (versionBeanRootBean.isOk())
                            mView.showAppUpdate();
                        else
                            mView.showAppUpdate();
                    }
                });


    }

    @Override
    public void getVideoInfo() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", "12172");
        dataManager.fetchVideoInfo(new JsonObject())
                .compose(RxUtils.<RootBean>applyScheduler())
                .compose(mView.<RootBean>bindLifeCycle())
                .compose(RxUtils.<RootBean>handleFKResultRootBean())
                .subscribe(new FkCommonSubscriber<RootBean>(mView) {
                    @Override
                    public void onNext(RootBean rootBean) {
                        mView.showMsg(rootBean.getMsg());
                    }
                });
    }

}
