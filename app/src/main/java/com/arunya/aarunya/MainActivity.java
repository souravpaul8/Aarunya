package com.arunya.aarunya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pro= (Button) findViewById(R.id.button);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openproactivity();
            }
        });
    }
    public void openproactivity(){
        Intent in = new Intent(this,producer.class);
        startActivity(in);

    }
}
