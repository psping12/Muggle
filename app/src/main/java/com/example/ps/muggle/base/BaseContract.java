package com.example.ps.muggle.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

public interface BaseContract {

    interface BasePresenter<T extends BaseView> {

        void attachView(T view);

        void detachView();

    }

    interface BaseView {

        void showMsg(String msg);

        void useNightMode(boolean isNight);

        //=======  State  =======
        void stateError();

        void stateEmpty();

        void stateLoading();

        void stateMain();

        <T> LifecycleTransformer<T> bindLifeCycle();
    }


}
