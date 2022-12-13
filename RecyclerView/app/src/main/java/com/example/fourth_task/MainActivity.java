package com.example.fourth_task;

import static com.example.fourth_task.R.id.addBUTT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Habit> habtlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitsAdabter adabter=new HabitsAdabter();
         habtlist=new ArrayList<>();
        RecyclerView recycl=findViewById(R.id.recID);

        Button addhabit = findViewById(R.id.addBT);
        addhabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText addinghabit=findViewById(R.id.habitED);
                String ans=addinghabit.getText().toString();
                Habit a=new Habit();
                a.setName(ans);
                habtlist.add(a);
                habtlist =adabter.setHabitsList(habtlist);
                recycl.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recycl.setAdapter(adabter);
            }
        });






    }
}