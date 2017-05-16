package com.nk.nkbilibili.api;

import com.nk.nkbilibili.api.util.EntityUtils;
import com.nk.nkbilibili.api.util.HttpUtils;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiClient {

    private ApiClient() {}

    public static final LiveApiService liveApiService = new Retrofit.Builder()
        .baseUrl(ApiDefine.LIVE_APP_INDEX)
        .client(HttpUtils.client)
        .addConverterFactory(GsonConverterFactory.create(EntityUtils.gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
        .create(LiveApiService.class);
}
