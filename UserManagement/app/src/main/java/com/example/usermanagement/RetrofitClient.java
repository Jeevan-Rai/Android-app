package com.example.usermanagement;

import com.example.usermanagement.ModelResponse.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String Base_Url = "http://192.168.0.178/UserApi/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;

    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    private RetrofitClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


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
