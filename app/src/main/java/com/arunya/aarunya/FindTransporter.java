package com.arunya.aarunya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FindTransporter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_transport_list);

        final ArrayList<FindTransporterInfo> findTransporterInfos = new ArrayList<FindTransporterInfo>();
        FindTransporterInfo transporter = new FindTransporterInfo("Satpal Singh", "Normal Truck", "100 Quintal", "Panipat", "HR-06-BH-3245");
        findTransporterInfos.add(transporter);
        findTransporterInfos.add(new FindTransporterInfo("Sushil Sharma", "Refrigerated Truck", "1000 Kg", "Nagpur", "MH-31-CX-1236"));
        findTransporterInfos.add(new FindTransporterInfo("Keerthi Kumar", "Normal Truck", "500 Kg", "Chennai", "TN-09-DE-5423"));


        FindTransporterAdapter adapter = new FindTransporterAdapter(this, findTransporterInfos);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
