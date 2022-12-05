package com.example.third_supp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name=findViewById(R.id.nameEDT);
        EditText email=findViewById(R.id.emailEDT);
        EditText pass=findViewById(R.id.passEDT);
        Button signup=findViewById(R.id.singupBTN);

        Button login=findViewById(R.id.LogBTN);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean f=false;
                if(name.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "enter the name first", Toast.LENGTH_SHORT).show();
                    f=true;
                }
                if(email.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "enter the email first", Toast.LENGTH_SHORT).show();
                    f=true;
                }
                if(pass.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "enter the pass first", Toast.LENGTH_SHORT).show();
                    f=true;
                }
                if(f==false)
                Toast.makeText(MainActivity.this, "sign up success "+name.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open();

            }
        });
    }
    public void open(){
        Intent log=new Intent(this,Registration.class);
        startActivity(log);
    }

}