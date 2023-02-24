package com.example.movieapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdabter extends RecyclerView.Adapter<MovieAdabter.MovieViewHolder> {
    List<Movie>movieList=new ArrayList<>();

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdabter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdabter.MovieViewHolder holder, int position) {
        holder.user_id.setText(String.valueOf(movieList.get(position).getUserID()));
holder.id.setText(String.valueOf(movieList.get(position).getId()));
holder.title.setText(movieList.get(position).getTitle());
holder.body.setText(movieList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
TextView id;
TextView user_id;
        TextView title;
        TextView body;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id=itemView.findViewById(R.id.userid_TV);
            id=itemView.findViewById(R.id.id_TV);
            title=itemView.findViewById(R.id.title_TV);
            body=itemView.findViewById(R.id.body_TV);
        }
    }
}
