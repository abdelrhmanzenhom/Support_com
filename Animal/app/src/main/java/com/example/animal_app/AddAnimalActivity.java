package com.example.animal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddAnimalActivity extends AppCompatActivity {
EditText name,family,age;
Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
        name=findViewById(R.id.ED_name);
        family=findViewById(R.id.ED_family);
        age=findViewById(R.id.ED_age);
        add_button=findViewById(R.id.BT_add);

       add_button.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                         public void onClick(View view) {
                                          int x=Integer.parseInt(age.getText().toString());
                                           Animal aa=new Animal( name.getText().toString(),family.getText().toString(),x);
                                           MainActivity.AD.insert_Animals(aa);

Intent insf=new Intent(AddAnimalActivity.this,MainActivity.class);
startActivity(insf);
                                         }
                                      }
       );



    }
}