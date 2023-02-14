package com.example.animal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnimalDetails extends AppCompatActivity {
private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView name,description;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        name=findViewById(R.id.TV_name_details);
        description=findViewById(R.id.TV_details);
        bundle=getIntent().getExtras();
        if(bundle!=null) {
          name.setText(  bundle.getString("name"));
            description.setText(bundle.getString("family"));
        }
    }
}