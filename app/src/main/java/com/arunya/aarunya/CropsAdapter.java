package com.arunya.aarunya;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SOURAV PAUL on 3/16/2018.
 */

public class CropsAdapter extends ArrayAdapter<Crops> {


    public CropsAdapter (Activity context, ArrayList<Crops> crops) {

        super(context , 0, crops);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cons_buy_list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Crops cropsView = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView cropTypeTextView = (TextView) listItemView.findViewById(R.id.crop_type);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        cropTypeTextView.setText(cropsView.getCrop());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView quantityTextView = (TextView) listItemView.findViewById(R.id.quantity_in_number);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        quantityTextView.setText(cropsView.getQuantity());

        // Find the TextView in the cons_buy_list_item.xml layout with the ID version_number
        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price_in_number);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        priceTextView.setText(cropsView.getPrice());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView districtTextView = (TextView) listItemView.findViewById(R.id.district);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        districtTextView.setText(cropsView.getDistrict());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView image = (ImageView) listItemView.findViewById(R.id.image_view);

        // set the image to iconView
        image.setImageResource(cropsView.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
