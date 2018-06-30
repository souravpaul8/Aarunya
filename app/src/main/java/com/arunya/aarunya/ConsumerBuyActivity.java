package com.arunya.aarunya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ConsumerBuyActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_item_list);


        final ArrayList<Crops> crops = new ArrayList<Crops>();
        Crops crop = new Crops("Wheat", "10 Kg", "Rs. 20/Kg","Chandigarh",R.drawable.wheat);
        crops.add(crop);
        crops.add(new Crops("Rice", "20 Kg","Rs. 40/Kg","Dhanbad" ,R.drawable.rice));

        CropsAdapter adapter = new CropsAdapter(this, crops);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }


}
