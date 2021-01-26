package com.example.alaatask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofitInstance(){
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("https://alaatv.com/api/v2/home/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    private RetrofitInstance() {
    }
}
