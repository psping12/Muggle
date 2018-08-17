package com.example.ps.muggle.base;

import android.view.View;
import android.view.ViewGroup;

import com.example.ps.muggle.R;
import com.example.ps.muggle.widget.ProgressImageView;

public abstract class StateFragment<T extends BasePresenter> extends BaseFragment<T> {

    private static final int STATE_MAIN = 1;
    private static final int STATE_LOADING = 2;
    private static final int STATE_ERROR = 3;

    ViewGroup viewMain;
    ViewGroup mParent;
    ProgressImageView ivLoading;
    View viewError;
    View viewLoading;

    private int currentState = STATE_MAIN;
    private int mErrorResource = R.layout.view_error;
    private boolean errorViewAdd = false;


    @Override
    protected void initEventAndData() {
        if (getView() == null)
            return;
        viewMain = getView().findViewById(R.id.view_main);
        if (viewMain == null)
            throw new IllegalStateException("must contain a view named 'view_main'");
        if (!(viewMain.getParent() instanceof ViewGroup))
            throw new IllegalStateException("view_main's parentView should be a ViewGroup");
        mParent = (ViewGroup) viewMain.getParent();
        View.inflate(mContext, R.layout.view_progress, mParent);
        viewLoading = getView().findViewById(R.id.view_loading);
        ivLoading = getView().findViewById(R.id.iv_progress);
        viewLoading.setVisibility(View.GONE);
        viewMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void stateMain() {
        if (currentState == STATE_MAIN) return;
        hideCurrentView();
        viewMain.setVisibility(View.VISIBLE);
        currentState = STATE_MAIN;
    }

    @Override
    public void stateLoading() {
        if (currentState == STATE_LOADING) return;
        hideCurrentView();
        viewLoading.setVisibility(View.VISIBLE);
        currentState = STATE_LOADING;
        ivLoading.start();
    }

    @Override
    public void stateError() {
        if (currentState == STATE_ERROR) return;
        if (!errorViewAdd) {
            errorViewAdd = true;
            View.inflate(mContext, mErrorResource, mParent);
            viewError = mParent.findViewById(R.id.view_error);
            if (viewError == null)
                throw new IllegalStateException("mErrorResource view should have a view with id 'view_error'");
        }
        hideCurrentView();
        currentState = STATE_ERROR;
        viewError.setVisibility(View.VISIBLE);
    }

    private void hideCurrentView() {
        switch (currentState) {
            case STATE_MAIN:
                viewMain.setVisibility(View.GONE);
                break;
            case STATE_LOADING:
                viewLoading.setVisibility(View.GONE);
                ivLoading.stop();
                break;
            case STATE_ERROR:
                if (viewError != null)
                    viewError.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * @param mErrorResource 错误页面Resource
     */
    public void setmErrorResource(int mErrorResource) {
        this.mErrorResource = mErrorResource;
    }
}
