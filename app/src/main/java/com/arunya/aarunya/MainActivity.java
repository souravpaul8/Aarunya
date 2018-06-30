package com.arunya.aarunya;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseReference mdata= FirebaseDatabase.getInstance().getReference().child("current").child("type");

        String type=mdata.getKey().toString();
        if(type.equals("producer"))
        {
            Intent intent = new Intent(this, producer.class);
            startActivity(intent);
        }
        Intent intent = new Intent(this, producer.class);
        startActivity(intent);

        //Intent intent = new Intent(this, LanguageActivity.class);
        //startActivity(intent);
    }
}