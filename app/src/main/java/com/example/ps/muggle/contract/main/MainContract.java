package com.example.ps.muggle.contract.main;

import com.example.ps.muggle.base.BaseContract;
import com.example.ps.muggle.model.bean.RootBean;

public interface MainContract {

    interface View extends BaseContract.BaseView {
        void showAppUpdate();

        void setVideoInfo(RootBean rootBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void checkVersion();

        void getVideoInfo();
    }

}
