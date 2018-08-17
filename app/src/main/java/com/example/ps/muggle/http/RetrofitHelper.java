package com.example.ps.muggle.http;

import com.example.ps.muggle.http.api.MyApis;
import com.example.ps.muggle.http.response.MyHttpResponse;
import com.example.ps.muggle.model.bean.RootBean;
import com.example.ps.muggle.model.bean.VersionBean;
import com.google.gson.JsonObject;

import javax.inject.Inject;

import io.reactivex.Flowable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RetrofitHelper implements HttpHelper {
    private MyApis mApiService;

    @Inject
    public RetrofitHelper(MyApis myApiService) {
        this.mApiService = myApiService;
    }


    @Override
    public Flowable<RootBean> fetchRecommend(RequestBody json) {
        return mApiService.fetchRecommend(json);
    }

    @Override
    public Flowable<RootBean<VersionBean>> fetchVersion() {
        return mApiService.fetchVersion();
    }

    @Override
    public Flowable<RootBean> fetchVideoInfo(JsonObject json) {
        return mApiService.fetchVideoInfo(addToken(json));
    }


    private RequestBody addToken(JsonObject json) {
        json.addProperty("token", "111111");
        return RequestBody.create(MediaType.parse("application/json"), json.toString());
    }
}
