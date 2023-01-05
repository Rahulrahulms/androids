package com.example.sjcet.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;

    databse dbs=new databse(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void inse(View view) {
        String str1,str2;
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et1);
        str1=e1.getText().toString();
        str2=e2.getText().toString();
        boolean bb=dbs.insert(str1,str2);

        if(bb==true)
        {
            Toast.makeText(getApplicationContext(), "data Inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "data not  Inserted", Toast.LENGTH_SHORT).show();
        }





    }
}






package com.example.sjcet.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.ActionBarContextView;


public class databse extends SQLiteOpenHelper{



    public databse(Context context) {
        super(context, "sample.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table rahul(name TEXT,gender TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table IF EXISTS rahul");

    }

    public boolean insert(String name,String gender)
    {
        SQLiteDatabase dbs=this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("name",name);
        cv.put("gender",gender);
        long value=dbs.insert("sample.db",null,cv);

        if (value==-1)
        {
            return true;
        }
        else
        {
            return false;
        }


    }
}
