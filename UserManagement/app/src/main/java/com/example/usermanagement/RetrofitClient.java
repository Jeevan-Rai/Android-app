package com.example.usermanagement;

import com.example.usermanagement.ModelResponse.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String Base_Url = "http://192.168.0.178/UserApi/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;


    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    public static synchronized RetrofitClient getInstance() {
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Api getapi(){
       return retrofit.create(Api.class);
    }
}
