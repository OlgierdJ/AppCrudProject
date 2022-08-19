package com.example.appcrudproject;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface IPersonService {

    @POST("/api/person")
    Call<Person> create(@Body Person user);
    @GET("/api/person")
    Call<List<Person>> get();
    @POST("/api/person/{id}")
    Call<Person> get(@Path("id") String searchId);
    @PUT("/api/person")
    Call<Person> update(@Body Person user);
    @DELETE("/api/person")
    Call<Person> delete(@Path("id") String searchId);
}
