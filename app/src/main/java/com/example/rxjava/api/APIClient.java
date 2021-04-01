package com.example.rxjava.api;

import android.os.Build;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit=null;

    public static Retrofit getApiClient(String url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                   // .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
