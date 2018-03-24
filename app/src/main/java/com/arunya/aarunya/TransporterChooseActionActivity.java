package com.arunya.aarunya;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransporterChooseActionActivity extends AppCompatActivity {

    Button routeBtn ,confirmBtn,contactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter_choose_action);

        routeBtn   = findViewById(R.id.route_btn);
        confirmBtn = findViewById(R.id.confirm_btn);
        contactBtn = findViewById(R.id.contact_btn);

        routeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir/?api=1&origin=23.7957,86.4304&destination=19.0760,72.8777"));
                startActivity(intent);

            }

        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransporterChooseActionActivity.this,TransporterConfirmActivity.class);
                startActivity(intent);

            }

        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransporterChooseActionActivity.this,TransporterContactActivity.class);
                startActivity(intent);

            }

        });
    }
}
