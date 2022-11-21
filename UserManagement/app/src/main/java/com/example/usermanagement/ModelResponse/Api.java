package com.example.usermanagement.ModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("uname") String uname,
            @Field("email") String email,
            @Field("pass") String pass
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("pass") String pass
    );

    @GET("fetchall.php")
    Call<FetchUserResponse> fetchUser();
}
