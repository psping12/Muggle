package com.example.ps.muggle.di.module;

import android.app.Activity;

import com.example.ps.muggle.di.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }
}
