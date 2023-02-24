package com.example.movieapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_interface {
    @GET("posts")
    Call<List<Movie>>getMovie();
}
