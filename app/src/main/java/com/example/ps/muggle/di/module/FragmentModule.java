package com.example.ps.muggle.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.ps.muggle.di.scope.FragmentScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
