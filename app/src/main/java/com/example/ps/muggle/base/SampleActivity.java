package com.example.ps.muggle.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.LifecycleTransformer;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportHelper;

public abstract class SampleActivity extends MySupportActivity {
    Activity mContext;
    Unbinder unbinder;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getLayout());
        mContext = this;
        unbinder = ButterKnife.bind(this);
        onViewCreated();
        initEventAndData();
    }

    protected abstract void beforeSetContentView();

    protected abstract int getLayout();

    protected void onViewCreated() {

    }

    protected abstract void initEventAndData();


    public <T> LifecycleTransformer<T> bindLifeCycle() {
        return this.<T>bindToLifecycle();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    /**
     * 获取栈内的fragment对象
     */
    public <T extends ISupportFragment> T findFragment(Class<T> fragmentClass) {
        return SupportHelper.findFragment(getSupportFragmentManager(), fragmentClass);
    }
}
