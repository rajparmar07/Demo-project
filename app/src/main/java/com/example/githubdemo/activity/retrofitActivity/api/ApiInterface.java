package com.example.githubdemo.activity.retrofitActivity.api;

import com.example.githubdemo.activity.retrofitActivity.model.ListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    /* get photos */
    @GET("photos")
    Call<List<ListModel>> getPhotos();
}
