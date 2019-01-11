package com.demo.livedatawithwebservice.remote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/api/users?page=2")
    Call<UserListResponse> getUserList();
}
