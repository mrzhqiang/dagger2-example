package com.github.mrzhqiang.dagger2_example.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HaowanbaApi {

    @GET("/")
    Call<String> home();
}
