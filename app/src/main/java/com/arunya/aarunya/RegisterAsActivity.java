package com.arunya.aarunya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterAsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as);

        final Button registerAsProducer = (Button) findViewById(R.id.register_as_producer);
        final Button registerAsBuyer = (Button) findViewById(R.id.register_as_buyer);
        final Button registerAsTransporter = (Button) findViewById(R.id.register_as_transporter);

        registerAsProducer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent newRegistrationProducerIntent = new Intent(RegisterAsActivity.this, NewRegistrationProducerActivity.class);

                startActivity(newRegistrationProducerIntent);
            }
        });

        registerAsBuyer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent newRegistrationConsumerIntent = new Intent(RegisterAsActivity.this, NewRegistrationConsumerActivity.class);

                startActivity(newRegistrationConsumerIntent);
            }
        });

        registerAsTransporter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent newRegistrationTransporterIntent = new Intent(RegisterAsActivity.this, NewRegistrationTransporterActivity.class);

                startActivity(newRegistrationTransporterIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}