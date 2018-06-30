package com.arunya.aarunya;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SOURAV PAUL on 3/31/2018.
 */

public class FindTransporterAdapter  extends ArrayAdapter<FindTransporterInfo> {


    public FindTransporterAdapter (Activity context, ArrayList<FindTransporterInfo> findTransporterInfo) {

        super(context , 0, findTransporterInfo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.find_transporter_list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        FindTransporterInfo findTransporterInfoView = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView cropTypeTextView = (TextView) listItemView.findViewById(R.id.transporter_name_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        cropTypeTextView.setText(findTransporterInfoView.getmName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView quantityTextView = (TextView) listItemView.findViewById(R.id.type_of_truck_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        quantityTextView.setText(findTransporterInfoView.getmTypeOfTruck());

        // Find the TextView in the cons_buy_list_item.xml layout with the ID version_number
        TextView priceTextView = (TextView) listItemView.findViewById(R.id.transport_quantity_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        priceTextView.setText(findTransporterInfoView.getmQuantity());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView districtTextView = (TextView) listItemView.findViewById(R.id.transporter_district_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        districtTextView.setText(findTransporterInfoView.getmDistrict());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView vehicleNumber = (TextView) listItemView.findViewById(R.id.transporter_vehicle_number_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        vehicleNumber.setText(findTransporterInfoView.getmVehicleNumber());




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
