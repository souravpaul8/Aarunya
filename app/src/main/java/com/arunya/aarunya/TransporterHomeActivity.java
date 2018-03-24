package com.arunya.aarunya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TransporterHomeActivity extends AppCompatActivity {

    private Button viewAsignment;
    private Button news;
    private Button weather;
    private Button helpline;
    private Button history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter_home);

        viewAsignment =(Button)findViewById(R.id.view_assignment);
        news =(Button)findViewById(R.id.view_news);
        weather =(Button)findViewById(R.id.view_weather);
        helpline =(Button)findViewById(R.id.view_helpline);
        history =(Button)findViewById(R.id.view_history);


        viewAsignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransporterHomeActivity.this,TransporterViewAssignmentActivity.class);
                startActivity(intent);

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransporterHomeActivity.this,TransporterNewsActivity.class);
                startActivity(intent);

            }
        });


        /*weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


    }
}
