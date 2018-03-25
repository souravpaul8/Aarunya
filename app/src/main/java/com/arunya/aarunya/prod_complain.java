package com.arunya.aarunya;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class prod_complain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mdl;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_complain);
        mdl = (DrawerLayout)findViewById(R.id.drawer_complain);
        mToggle = new ActionBarDrawerToggle(this,mdl,R.string.open,R.string.close);
        mdl.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView)findViewById(R.id.navView_complain);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.profile:
                Intent in = new Intent(prod_complain.this, Profile.class);
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

