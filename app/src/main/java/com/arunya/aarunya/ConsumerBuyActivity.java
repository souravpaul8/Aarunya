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

        /**words.add(new Words("Two", "Ditio", R.drawable.number_two, R.raw.two));
        words.add(new Words("Three", "Tritio", R.drawable.number_three, R.raw.three));
        words.add(new Words("Four", "Choturtho", R.drawable.number_four, R.raw.four));
        words.add(new Words("Five", "Ponchom", R.drawable.number_five, R.raw.five));
        words.add(new Words("Six", "Shoshtho", R.drawable.number_six, R.raw.six));
        words.add(new Words("Seven", "Shoptom", R.drawable.number_seven, R.raw.seven));
        words.add(new Words("Eight", "Oshtom", R.drawable.number_eight, R.raw.eight));
        words.add(new Words("Nine", "Nobom", R.drawable.number_nine, R.raw.nine));
        words.add(new Words("Ten", "Doshom", R.drawable.number_ten, R.raw.ten));
         */

        CropsAdapter adapter = new CropsAdapter(this, crops);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }


}
