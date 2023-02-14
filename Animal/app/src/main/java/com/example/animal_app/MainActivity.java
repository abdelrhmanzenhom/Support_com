package com.example.animal_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List <Animal>animalList;
private Animal_Adabter adabt;
private RecyclerView RC;
public static AnimalDataBase AD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AD=new AnimalDataBase(this);
        setContentView(R.layout.activity_main);
        FloatingActionButton floatbotton=findViewById(R.id.floatingActionButton);
        RC=findViewById(R.id.recyclerview1);
        animalList=new ArrayList<>();


        animalList=AD.get_Animals();

        adabt =new Animal_Adabter(this,animalList);

        RC.setLayoutManager(new LinearLayoutManager(this));
        RC.setAdapter(adabt);
        floatbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddAnimalActivity.class);
                startActivity(intent);

                adabt.notifyDataSetChanged();
            }
        });


    }
    public  void add()
    {




    }

}