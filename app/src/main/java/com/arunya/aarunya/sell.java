package com.arunya.aarunya;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sell extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener{

    //to store the values
    private EditText basic_rate,qty;
    private String commodities;
    private String userID;
    private DrawerLayout mdl;
    private ActionBarDrawerToggle mToggle;


    //firebase objects
    private Button msellbtn;
    private DatabaseReference sellDatabase;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        Spinner sp_comm = findViewById(R.id.commodity);
        final ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource
                (this,R.array.pro_commodities,android.R.layout.simple_spinner_item);
    adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    sp_comm.setAdapter(adp);
    sp_comm.setOnItemSelectedListener(this);

    basic_rate=(EditText)findViewById(R.id.basicrate);
    qty = (EditText)findViewById(R.id.quantity);

    //for storing objects in database
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

            }
        };

    msellbtn = (Button) findViewById(R.id.submit);

    sellDatabase= FirebaseDatabase.getInstance().getReference().child("commodities");
    msellbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String srate = basic_rate.getText().toString();
            double rate = Double.parseDouble(srate);
            String sqty = qty.getText().toString();
            double quantity = Double.parseDouble(sqty);

            //adding child
            HashMap<String,String> datamap = new HashMap<String, String>();
            datamap.put("Commodities",commodities);
            datamap.put("Quantity",sqty);
            datamap.put("Basic Rate",srate);
            datamap.put("User Id",userID);
            sellDatabase.push().setValue(datamap);



        }
    });
        mdl = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mdl,R.string.open,R.string.close);
        mdl.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView)findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        commodities = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.profile:
                Intent in = new Intent(this, Profile.class);
                startActivity(in);
                return true;

        }
        switch (item.getItemId()){
            case R.id.support:
                Intent in = new Intent(this, Support.class);
                startActivity(in);
                return true;
        }

        switch (item.getItemId()){

            case R.id.language:
                Intent in = new Intent(this, LanguageActivity.class);
                startActivity(in);
                return true;

        }
        switch (item.getItemId()){

            case R.id.faq:
                Intent in = new Intent(this, prod_faq.class);
                startActivity(in);
                return true;

        }
        switch (item.getItemId()){

            case R.id.enquiry:
                Intent in = new Intent(this, Enquiry.class);
                startActivity(in);
                return true;

        }
        return false;
    }
}
