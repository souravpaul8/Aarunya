package com.arunya.aarunya;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class producer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public Button btn_sell;
    public Button btn_weather;
    public Button btn_faq;
    public Button btn_complain;
    public Button btn_news;
    public Button btn_offers;
    public Button btn_mrate;
    private DrawerLayout mdl;
    private ActionBarDrawerToggle mToggle;
    private Button btn_location;
    private LocationManager locationManager;
    private LocationListener locationListener;
    public double lattitude;
    public double longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);
        // To open Sell Activity
        btn_sell = (Button) findViewById(R.id.sell);
        btn_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensell();
            }
        });

        //To open Faq Activity
        btn_faq = (Button) findViewById(R.id.faq);
        btn_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfaq();
            }
        });

        //To open Complain
        btn_complain = (Button) findViewById(R.id.complain);
        btn_complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencomplain();
            }
        });

        //To open News
        btn_news = (Button) findViewById(R.id.news);
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennews();
            }
        });

        //To oprn weather
        btn_weather = (Button) findViewById(R.id.weather);
        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openweather();
            }
        });

        //To open govt offers

        btn_offers = (Button) findViewById(R.id.offers);
        btn_offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openscheme();
            }
        });

        //To open Mandi Rate

        btn_mrate = (Button) findViewById(R.id.mandirate);
        btn_mrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmandirate();
            }
        });
        //For Location

        btn_location = (Button) findViewById(R.id.location);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                longitude = location.getLongitude();
                lattitude = location.getLatitude();

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent in = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(in);

            }
        };

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                       android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                },10 );
                return;
            }
        }else{
            configureButton();
        }






        //For Drawer Layout
        mdl = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mdl,R.string.open,R.string.close);
        mdl.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView)findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(this);


    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public void opensell(){
        Intent in = new Intent(this,sell.class);
        startActivity(in);
    }
    public void openfaq(){
        Intent in = new Intent(this,prod_faq.class);
        startActivity(in);
    }

    public void opencomplain(){
        Intent in = new Intent(this,prod_complain.class);
        startActivity(in);
    }
    public void openWeb(View view){
        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"));
        startActivity(in);

    }
    public void opennews(){
        Intent in = new Intent(this,news.class);
        startActivity(in);
    }
    public void openweather(){
        Intent in = new Intent(this,weather.class);
        startActivity(in);
    }
    public void openscheme() {
        Intent in = new Intent(this,Government_schemes.class);
        startActivity(in);

    }
    public void openmandirate(){
        Intent in = new Intent(this,MandiRate.class);
        startActivity(in);
    }
}

