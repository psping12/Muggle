package com.example.ps.muggle.http.api;

import com.example.ps.muggle.model.bean.RootBean;
import com.example.ps.muggle.model.bean.VersionBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyApis {
    String HOST = "https://api.fankcool.com";

    @POST("api/v2/videoRecsList")
    Flowable<RootBean> fetchRecommend(@Body RequestBody json);

    @GET("api/v2/android/lastapk")
    Flowable<RootBean<VersionBean>> fetchVersion();

    @POST("api/v2/videos/look")
    Flowable<RootBean> fetchVideoInfo(@Body RequestBody body);

}
