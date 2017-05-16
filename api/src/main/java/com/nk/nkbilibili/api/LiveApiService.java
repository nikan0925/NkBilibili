package com.nk.nkbilibili.api;

import com.nk.nkbilibili.api.entity.LiveAppIndexBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2017/5/16.
 */

public interface LiveApiService {

    @GET("AppNewIndex/common?_device=android" +
             "&appkey=1d8b6e7d45233436&build=502000" +
             "&mobi_app=android" +
             "&platform=android" +
             "&scale=xxhdpi" +
             "&ts=1494921155000" +
             "&sign=2461e5390b2f23c7f89c10295525b763")
    Observable<LiveAppIndexBean> getLiveAppIndex();
}
