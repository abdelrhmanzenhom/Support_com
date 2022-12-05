package com.example.third_supp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
         email=findViewById(R.id.email2EDT);
        EditText pass=findViewById(R.id.pass2EDT);
        Button signup=findViewById(R.id.singup2BTN);

        Button login=findViewById(R.id.login2BTN);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean f=false;

                if(email.getText().toString().equals("")){
                    Toast.makeText(Registration.this, "enter the email first", Toast.LENGTH_SHORT).show();
                    f=true;
                }
                if(pass.getText().toString().equals("")){
                    Toast.makeText(Registration.this, "enter the pass first", Toast.LENGTH_SHORT).show();
                    f=true;
                }
                if(f==false){
                    open3();

                    }


            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open2();

            }
        });
    }
    public void open2(){
        Intent log=new Intent(this,MainActivity.class);
        startActivity(log);
    }
    public void open3()
    { Intent home=new Intent(this,Home.class);
        String val=email.getText().toString();
        home.putExtra("keyy",val);
        startActivity((home));
    }
}