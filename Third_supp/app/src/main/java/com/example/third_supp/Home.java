package com.example.third_supp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
TextView an=findViewById(R.id.ans_TV);
String anss=getIntent().getExtras().getString("keyy");
an.setText("welcom back "+anss);
    }
}