package com.example.ps.muggle.app;

import android.app.Application;

import com.example.ps.muggle.di.component.AppComponent;
import com.example.ps.muggle.di.component.DaggerAppComponent;
import com.example.ps.muggle.di.module.AppModule;
import com.example.ps.muggle.di.module.HttpModule;
import com.example.ps.muggle.utils.ContextUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import io.realm.Realm;

public class MyApp extends Application {

    private static MyApp instance;

    public static AppComponent appComponent;

    public static int width = 0;

    public static int height = 0;

    public static synchronized MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        width = ContextUtils.getSreenWidth(this);
        height = ContextUtils.getSreenHeight(this);
        //初始化数据库
        Realm.init(getApplicationContext());
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("mmmmm")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));


    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
