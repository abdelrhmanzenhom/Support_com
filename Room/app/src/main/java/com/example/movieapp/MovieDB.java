package com.example.movieapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities={Movie.class},version = 2,exportSchema = false)
public abstract class MovieDB extends RoomDatabase {
    private static MovieDB instanse;
    public abstract MovieDAO movieDao();

    public static MovieDB getInstanse (Context context)
    {
        if(instanse==null)
        {
            instanse= Room.databaseBuilder(context.getApplicationContext(),MovieDB.class,"database.db").
                    fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instanse;
    }
}
