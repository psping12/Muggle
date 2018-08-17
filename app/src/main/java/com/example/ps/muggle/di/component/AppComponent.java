package com.example.ps.muggle.di.component;

import com.example.ps.muggle.app.MyApp;
import com.example.ps.muggle.di.module.AppModule;
import com.example.ps.muggle.di.module.HttpModule;
import com.example.ps.muggle.http.RetrofitHelper;
import com.example.ps.muggle.model.DataManager;
import com.example.ps.muggle.model.db.ReamlHelper;
import com.example.ps.muggle.model.prefs.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    MyApp getContext();

    RetrofitHelper retrofitHelper();

    DataManager dataManager();

    PreferenceHelper preferenceHelper();

    ReamlHelper reamHelper();

}
