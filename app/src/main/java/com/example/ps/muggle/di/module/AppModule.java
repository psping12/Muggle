package com.example.ps.muggle.di.module;

import com.example.ps.muggle.app.MyApp;
import com.example.ps.muggle.http.HttpHelper;
import com.example.ps.muggle.http.RetrofitHelper;
import com.example.ps.muggle.model.DataManager;
import com.example.ps.muggle.model.db.DBHelper;
import com.example.ps.muggle.model.db.ReamlHelper;
import com.example.ps.muggle.model.prefs.ImplPreferenceHelper;
import com.example.ps.muggle.model.prefs.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final MyApp app;

    public AppModule(MyApp app) {
        this.app = app;
    }

    @Singleton
    @Provides
    MyApp provideApplicationContext() {
        return app;
    }

    @Singleton
    @Provides
    HttpHelper provideRetrofitHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Singleton
    @Provides
    PreferenceHelper providePreferenceHelper(ImplPreferenceHelper preferenceHelper) {
        return preferenceHelper;
    }

    @Singleton
    @Provides
    DBHelper provideDBHelper(ReamlHelper reamlHelper) {
        return reamlHelper;
    }

    @Singleton
    @Provides
    DataManager provideDataManager(HttpHelper httpHelper, PreferenceHelper preferenceHelper, ReamlHelper reamlHelper) {
        return new DataManager(httpHelper, reamlHelper, preferenceHelper);
    }

}
