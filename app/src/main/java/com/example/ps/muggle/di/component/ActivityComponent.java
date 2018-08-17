package com.example.ps.muggle.di.component;

import android.app.Activity;

import com.example.ps.muggle.di.module.ActivityModule;
import com.example.ps.muggle.di.scope.ActivityScope;
import com.example.ps.muggle.ui.main.activity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);
}
