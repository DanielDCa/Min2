package com.example.min2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
@GET("/user/{userId}")
    Call<User> getInfo(@Path("userId")String userId);

/*@GET("{user}")
    Call<User> getUser(@Path("user")String name);

@GET("{user}/repos")
Call<List<Repositorio>> getRespos(@Path("user")String name);*/



}
