package com.example.ps.muggle.model;

import com.example.ps.muggle.http.HttpHelper;
import com.example.ps.muggle.model.bean.RootBean;
import com.example.ps.muggle.model.bean.VersionBean;
import com.example.ps.muggle.model.db.DBHelper;
import com.example.ps.muggle.model.prefs.PreferenceHelper;
import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class DataManager implements HttpHelper, DBHelper, PreferenceHelper {
    private HttpHelper mHttpHelper;
    private DBHelper mDBHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper mHttpHelper, DBHelper mDBHelper, PreferenceHelper mPreferenceHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mDBHelper = mDBHelper;
        this.mPreferenceHelper = mPreferenceHelper;
    }

    ////////////////   http   ////////////////////
    @Override
    public Flowable<RootBean> fetchRecommend(RequestBody json) {
        return mHttpHelper.fetchRecommend(json);
    }

    @Override
    public Flowable<RootBean<VersionBean>> fetchVersion() {
        return mHttpHelper.fetchVersion();
    }

    @Override
    public Flowable<RootBean> fetchVideoInfo(JsonObject json) {
        return mHttpHelper.fetchVideoInfo(json);
    }

    ////////////////   db     ////////////////////
    @Override
    public void insertId(int id) {
        mDBHelper.insertId(id);
    }

    ////////////////   sp     ////////////////////
    @Override
    public boolean firstRun() {
        return mPreferenceHelper.firstRun();
    }


}
