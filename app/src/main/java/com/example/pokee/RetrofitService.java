package com.example.pokee;

import com.example.pokee.model.UserBody;
import com.example.pokee.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("{id}")
    Call<UserResponse> getUser(@Path("id") String id);

    @POST(".")
    Call<UserResponse> postUser(@Body UserBody requestPost);


}
