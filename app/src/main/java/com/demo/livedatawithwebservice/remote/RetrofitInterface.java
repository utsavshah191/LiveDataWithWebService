package com.demo.livedatawithwebservice.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInterface {

    private static Retrofit retrofit = null;

    private static int CONNECTION_TIME_OUT = 30;

    public static final String BASE_URL = "https://reqres.in/";

    private RetrofitInterface() {

    }

    public static Retrofit getJsonClientWork() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS);
        // add logging as last interceptor
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

        return retrofit;
    }

}