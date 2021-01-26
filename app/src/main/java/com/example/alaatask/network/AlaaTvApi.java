package com.example.alaatask.network;

import com.example.alaatask.data.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlaaTvApi {
    @GET(".")
    Call<Data> getAllData();
}
