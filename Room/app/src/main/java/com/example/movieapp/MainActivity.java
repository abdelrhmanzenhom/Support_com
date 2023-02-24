package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
MovieAdabter adabter;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
recyclerView=findViewById(R.id.RC_id);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
Api_interface api_interface= retrofit.create(Api_interface.class);
        MovieDB database=MovieDB.getInstanse(this);
adabter=new MovieAdabter();
        adabter.setMovieList( database.movieDao().getMovie());
        recyclerView.setAdapter(adabter);
Call<List<Movie>> call= api_interface.getMovie();

call.enqueue(new Callback<List<Movie>>() {
    @Override
    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        List <Movie>movielist=new ArrayList<>();
        for(Movie movie:database.movieDao().getMovie()) {
            movielist.add(movie);
        }

      //  recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    public void onFailure(Call<List<Movie>> call, Throwable t) {
        Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
    }
});

    }
}