package com.example.movieapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface MovieDAO {
    @Insert
    void insertMovie(Movie movie);
    @Query("select * from movie_table")
    List<Movie> getMovie();

}
