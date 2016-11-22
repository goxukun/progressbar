package com.xukun.forever.domehttps;

import okhttp3.OkHttpClient;

/**
 * Created by forever on 2016/11/22.
 */

public class OkHttpClientManager {

    public OkHttpClientManager(){}

    public static OkHttpClient getInstance(){
        return mOkhttpClient;
    }

    private static OkHttpClient mOkhttpClient;
    public static OkHttpClient mOkHttpClient(OkHttpClient mOkHttpClient){
        if(mOkhttpClient == null){
            mOkhttpClient = mOkHttpClient;
        }
        return mOkhttpClient;
    }

}
