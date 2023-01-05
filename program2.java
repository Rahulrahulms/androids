package com.example.sjcet.myapplication8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submits(View view) {
        String email,password,username,dob,gender;
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);
        e4=findViewById(R.id.et4);
        e5=findViewById(R.id.et5);
        email=e1.getText().toString();
        password=e2.getText().toString();
        username=e3.getText().toString();
        dob=e4.getText().toString();
        gender=e5.getText().toString();
        boolean bn=validate(email,password,username,dob,gender);
        if (bn==true)
        {
           



            Toast.makeText(getApplicationContext(), "dataValidated", Toast.LENGTH_SHORT).show();
            //startActivity(i,"Main2Activity.class");


        }
        else
        {
            Toast.makeText(getApplicationContext(), "InValid data", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean validate(String e,String p,String u,String d,String g)
    {
        if (!(e.contains("@")) && e.isEmpty())
        {
            e1.setError("Invaild email");
            return false;
        }
        if (p.isEmpty())
        {
            e2.setError("Invaild password");
            return false;
        }
        if (u.isEmpty())
        {
            e3.setError("Invaild username");
            return false;
        }
        if (d.isEmpty())
        {
            e4.setError("Invaild dateofbirth");
            return false;
        }

        return true;

    }
}

