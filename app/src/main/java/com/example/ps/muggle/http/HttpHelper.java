package com.example.ps.muggle.http;

import com.example.ps.muggle.model.bean.RootBean;
import com.example.ps.muggle.model.bean.VersionBean;
import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface HttpHelper {

    Flowable<RootBean> fetchRecommend(RequestBody json);

    Flowable<RootBean<VersionBean>> fetchVersion();

    Flowable<RootBean> fetchVideoInfo(JsonObject json);
}
