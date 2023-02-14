package com.example.animal_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AnimalDataBase extends SQLiteOpenHelper {
    private final String Table_name="Animal_table";
    private final String Column_ID="ID ",
            Column_name="NAME ",
    Column_FAMILY="FAMILY ",
            Column_AGE="AGE ";

    public AnimalDataBase(@Nullable Context context) {
        super(context,"Animal.db",null,6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
String the_qury="CREATE TABLE " + Table_name +" ("
        + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + Column_name + " TEXT NOT NULL,"
        + Column_FAMILY + " TEXT NOT NULL," + Column_AGE +
        " INTEGER NOT NULL"
        +" )";
db.execSQL(the_qury);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

db.execSQL("DROP TABLE IF EXISTS "+ Table_name);
onCreate(db);
    }
    public void insert_Animals(Animal animal)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Column_name,animal.getName());
        cv.put(Column_FAMILY,animal.getFamily());
        cv.put(Column_AGE,animal.getAge());
        db.insert(Table_name,null,cv);
    }
    public List<Animal> get_Animals()
    {
        SQLiteDatabase db=getReadableDatabase();
        List<Animal> animallists=new ArrayList<>();
        Cursor c=db.rawQuery("SELECT * FROM "+Table_name,null);
        if(c.moveToFirst())
        {
            do{
                Animal a=new Animal(c.getString(1),c.getString(2),c.getInt(3));
                animallists.add(a);
            }while(c.moveToNext());
        }
c.close();
        return animallists;
    }
}
